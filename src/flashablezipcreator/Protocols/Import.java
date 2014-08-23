/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import static flashablezipcreator.AFZC.Protocols.p;
import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.DiskOperations.ReadZip;
import flashablezipcreator.Operations.TreeOperations;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Import {

    static ReadZip rz;
    static TreeOperations to;
    static String exisingUpdaterScript = "";
    static ArrayList<String> repeatList = null;

    public static void fromZip(String path, ProjectItemNode rootNode, int type, DefaultTreeModel model) throws IOException, ParserConfigurationException, TransformerException, SAXException {
        repeatList = new ArrayList<>();
        rz = new ReadZip(path);
        to = new TreeOperations(rootNode);
        String projectName = (new File(path)).getName();
        projectName = projectName.substring(0, projectName.lastIndexOf("."));
        int projectType = type;
        //following is to check if project already exists.
        //If yes, we will add current files of zip to that node to support multiple zip imports. If no, we will create a new project node.
        if (to.getProjectNode(projectName, projectType) == null) {
            to.addChildTo(rootNode, projectName, projectType, model);
        }
        Xml.initialize();
        for (Enumeration<? extends ZipEntry> e = rz.zf.entries(); e.hasMoreElements();) {
            ZipEntry ze = e.nextElement();
            String name = ze.getName();
            InputStream in = rz.zf.getInputStream(ze);
            if (name.endsWith("/")) {
                continue;
            } else if (Project.getTempFilesList().contains(name)) {
                continue;
            }
            System.out.println();
            p("current file " + name);
            System.out.println();
            String filePath = name;
            String groupName = getGroupName(filePath);
            int groupType = getGroupType(filePath);
            boolean hasSubGroup = hasSubGroup(filePath);
            String subGroupName = getSubGroupName(groupName, filePath);
            int subGroupType = groupType; //Groups that have subGroups have same type.
            String fileName = (new File(filePath)).getName();
            FileNode file = null;

            if (hasSubGroup) {
                file = addFileToTree(fileName, subGroupName, subGroupType, groupName, groupType, projectName, projectType, model);
                if (subGroupType == SubGroupNode.TYPE_CUSTOM) {
                    Xml.addFileDataToSubGroup(file);
                }
            } else {
                if (filePath.contains("META-INF/com/google/android/update-binary")) {
                    to.getProjectNode(projectName, projectType).update_binary = rz.getBytesFromFile(in);
                    continue;
                } else if (filePath.contains("META-INF/com/google/android/updater-binary-installer")) {
                    to.getProjectNode(projectName, projectType).update_binary_installer = rz.getBytesFromFile(in);
                    continue;
                } else if (filePath.contains("META-INF/com/google/android/updater-script")) {
                    to.getProjectNode(projectName, projectType).updater_script += rz.getStringFromFile(in);
                    continue;
                } else if (filePath.contains("META-INF/com/google/android/aroma")) {
                    continue;
                } else if (name.equals(Xml.custom_path)) {
                    Xml.originalData = rz.getStringFromFile(in);
                    continue;
                }else if (name.equals(Xml.delete_path)) {
                    Xml.deleteData = rz.getStringFromFile(in);
                    continue;
                }
                file = addFileToTree(fileName, groupName, groupType, projectName, projectType, model);
                if (groupType == GroupNode.GROUP_OTHER) {
                    file.fileZipPath = filePath;
                } else if (groupType == GroupNode.GROUP_CUSTOM) {
                    Xml.addFileDataToGroup(file);
                }
            }
            file.fileSourcePath = file.fileDestPath;
            rz.writeFileFromZip(in, file.fileSourcePath);
        }
        Xml.terminate();
        Xml.parseXml(GroupNode.GROUP_CUSTOM, rootNode, model);//this sets values of custom group/subGroup
        Xml.parseXml(GroupNode.GROUP_DELETE_FILES, rootNode, model);//this creates new file objects of delete group
        JOptionPane.showMessageDialog(null, Xml.deleteData);
    }

    public static FileNode addFileToTree(String fileName, String subGroupName, int subGroupType, String groupName, int groupType, String projectName, int projectType, DefaultTreeModel model) {
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
            JOptionPane.showMessageDialog(null, groupName + " imported");
        }
        if (to.getSubGroupNode(subGroupName, groupType, groupName, projectName) == null) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), subGroupName, subGroupType, model);
        }
        if (subGroupType == SubGroupNode.TYPE_CUSTOM) {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
        return to.getFileNode(fileName, subGroupName, groupName, projectName);
    }

    public static FileNode addFileToTree(String fileName, String groupName, int groupType, String projectName, int projectType, DefaultTreeModel model) {
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
            JOptionPane.showMessageDialog(null, groupName + " imported");
        }
        if (to.getFileNode(fileName, groupName, projectName) != null) {
            if (groupType == GroupNode.GROUP_OTHER) {
                fileName += "_1";
                fileName = getUniqueName(fileName);
            }
        }
        if (groupType == GroupNode.GROUP_CUSTOM) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
        return to.getFileNode(fileName, groupName, projectName);
    }

    /*files with same name and located at multiple places are unique inspite of having same name.
     this is to prevent them from skipping.*/
    public static String getUniqueName(String fileName) {
        if (repeatList.contains(fileName)) {
            fileName += "_1";
            return getUniqueName(fileName);
        } else {
            repeatList.add(fileName);
            return fileName;
        }
    }

    public static boolean hasSubGroup(String path) {
        //System.out.println("Has SubGroup");
        switch (getGroupType(path)) {
            case GroupNode.GROUP_SYSTEM_FONTS:
            case GroupNode.GROUP_SYSTEM_MEDIA:
            case GroupNode.GROUP_AROMA_KERNEL:
            case GroupNode.GROUP_DATA_LOCAL:
                return true;
            case GroupNode.GROUP_CUSTOM:
                if (path.startsWith("customize")) {
                    System.out.println("path before " + path);
                    path = path.substring(path.indexOf("/", path.indexOf("/", path.indexOf("/") + 1) + 1) + 1, path.length());
                    if (path.contains("/")) {
                        System.out.println("Returning true for " + path);
                        return true;
                    } else {
                        System.out.println("Returning false for " + path);
                        return false;
                    }
                }
        }
        return false;
    }

    public static String getSubGroupName(String groupName, String path) {
        if (path.startsWith("customize")) {
            path = path.substring(path.indexOf("/", path.indexOf("/", path.indexOf("/") + 1) + 1) + 1, path.length());
            try {
                path = path.substring(0, path.indexOf("/"));
            } catch (StringIndexOutOfBoundsException er) {
                System.out.println("Group with custom file found..!! " + path);
            }
        }
        return path;
    }

    public static String getGroupName(String path) {
        String fullPath = path;
        if (path.startsWith("customize")) {
            path = path.substring(path.indexOf("/", path.indexOf("/") + 1) + 1, path.indexOf("/", path.indexOf("/", path.indexOf("/") + 1) + 1));
            return path;
        } else if (path.startsWith("system") || path.startsWith("data") || path.startsWith("preload/symlink/system/app/")) {
            path = path.substring(path.indexOf("/") + 1, path.length());
            if (path.contains("/")) {
                path = path.substring(0, path.indexOf("/"));
            }
            //this will check if folder has subdirectories. -> system/etc/xyz/
            if ((fullPath.substring(fullPath.indexOf("/", fullPath.indexOf(path) + 1) + 1, fullPath.length())).contains("/")) {
                path = (fullPath.substring(fullPath.indexOf("/", fullPath.indexOf(path) + 1) + 1, fullPath.length()));
            }
        }
        switch (path) {
            case "app":
                if (fullPath.startsWith("data/app") && fullPath.endsWith(".apk")) {
                    return "DataApps";
                } else if(fullPath.startsWith("system/app") && fullPath.endsWith(".apk")){
                    return "SystemApps";
                }
            case "priv-app":
                return "PrivateApps";
            case "local":
                if (fullPath.startsWith("data/local")) {
                    return "BootAnimations";
                } else {
                    break;
                }
//            case "symlink":
//                return "PreloadApps";
            case "custom":
                return "custom";
            default:
                if (fullPath.startsWith("system/media")) {
                    fullPath = fullPath.substring(0, fullPath.lastIndexOf("/"));
                    switch (fullPath) {
                        case "system/media/audio/notifications":
                            return "NotificationsTones";
                        case "system/media/audio/ringtones":
                            return "Ringtones";
                        case "system/media/audio/alarms":
                            return "AlarmTones";
                        case "system/media/audio/ui":
                            return "UITones";
                        default:
                            return "Others";
                    }
                }else if(fullPath.startsWith("preload/symlink/system/app")){
                    return "PreloadApps";
                } else {
                    return "Others";
                }
        }
        return path;
    }

    public static int getGroupType(String path) {
        String fullPath = path;
        if (path.startsWith("customize")) {
            path = path.substring(path.indexOf("/") + 1, path.indexOf("/", path.indexOf("/") + 1));
        } else if (path.startsWith("system") || path.startsWith("data") || path.startsWith("preload/symlink/system/app/")) {
            path = path.substring(path.indexOf("/") + 1, path.length());
            if (path.contains("/")) {
                path = path.substring(0, path.indexOf("/"));
            }
            //this will check if folder has subdirectories. -> system/etc/xyz/
            if ((fullPath.substring(fullPath.indexOf("/", fullPath.indexOf(path) + 1) + 1, fullPath.length())).contains("/")) {
                path = (fullPath.substring(fullPath.indexOf("/", fullPath.indexOf(path) + 1) + 1, fullPath.length()));// it will return xyz/
            }
        }

        switch (path) {
            case "system_app":
            case "app":
                if (fullPath.startsWith("data")) {
                    return GroupNode.GROUP_DATA_APP;
                } else {
                    return GroupNode.GROUP_SYSTEM_APK;
                }
            case "system_priv_app":
            case "priv-app":
                return GroupNode.GROUP_SYSTEM_PRIV_APK;
            case "system_csc":
                return GroupNode.GROUP_SYSTEM_CSC;
            case "dpi":
                return GroupNode.GROUP_DPI;
            case "system_etc":
                return GroupNode.GROUP_SYSTEM_ETC;
            case "system_lib":
                return GroupNode.GROUP_SYSTEM_LIB;
            case "system_media_alarms":
                return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS;
            case "system_media_notifications":
                return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS;
            case "system_media_ringtones":
                return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES;
            case "system_media_ui":
                return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI;
            case "data_app":
                return GroupNode.GROUP_DATA_APP;
            case "system_preload":
                return GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP;
            case "system_framework":
                return GroupNode.GROUP_SYSTEM_FRAMEWORK;
            case "system_fonts":
                return GroupNode.GROUP_SYSTEM_FONTS;
            case "system_media":
                return GroupNode.GROUP_SYSTEM_MEDIA;
            case "data_local":
                return GroupNode.GROUP_DATA_LOCAL;
            case "custom":
                return GroupNode.GROUP_CUSTOM;
            case "kernels":
                return GroupNode.GROUP_AROMA_KERNEL;
            case "Other":
                return GroupNode.GROUP_OTHER;
            default:
                if (fullPath.startsWith("system/media")) {
                    fullPath = fullPath.substring(0, fullPath.lastIndexOf("/"));
                    switch (fullPath) {
                        case "system/media":
                            return GroupNode.GROUP_OTHER;//files belonging to system/media but not bootanimation.zip
                        case "system/media/audio/notifications":
                            return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS;
                        case "system/media/audio/ringtones":
                            return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES;
                        case "system/media/audio/alarms":
                            return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS;
                        case "system/media/audio/ui":
                            return GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI;
                        default:
                            return GroupNode.GROUP_OTHER;// like system/media/video in stock touchwiz roms.
                    }
                }else if(fullPath.startsWith("preload/symlink/system/app")){
                    return GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP;
                }else {
                    return GroupNode.GROUP_OTHER;
                }
        }
    }
}