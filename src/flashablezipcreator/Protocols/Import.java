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
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class Import {

    static ReadZip rz;
    static TreeOperations to;

    public static void from(String path, ProjectItemNode rootNode, int type, DefaultTreeModel model) throws IOException {
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
        while (rz.ze != null) {
            System.out.println();
            p("current file " + rz.ze.getName());
            System.out.println();
            String filePath = rz.ze.getName();
            String groupName = getGroupName(filePath);
            int groupType = getGroupType(filePath);
            boolean hasSubGroup = hasSubGroup(filePath);
            String subGroupName = getSubGroupName(groupName, filePath);
            int subGroupType = groupType; //Groups that have subGroups have same type.
            String fileName = (new File(filePath)).getName();
            FileNode file = null;
            if (hasSubGroup) {
                addFileToTree(fileName, subGroupName, subGroupType, groupName, groupType, projectName, projectType, model);
                file = to.getFileNode(fileName, subGroupName, groupName, projectName);
            } else {
                addFileToTree(fileName, groupName, groupType, projectName, projectType, model);
                file = to.getFileNode(fileName, groupName, projectName);
                if (groupType == GroupNode.GROUP_OTHER) {
                    file.fileZipPath = filePath;
                }
            }
            file.fileSourcePath = file.fileDestPath;
            rz.writeFileFromZip(rz.zis, file.fileSourcePath);
            rz.ze = rz.zis.getNextEntry();
        }
        rz.close();
    }

    public static void addFileToTree(String fileName, String subGroupName, int subGroupType, String groupName, int groupType, String projectName, int projectType, DefaultTreeModel model) {
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
        }
        if (to.getSubGroupNode(subGroupName, groupType, groupName, projectName) == null) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), subGroupName, subGroupType, model);
        }
        if (subGroupType == SubGroupNode.TYPE_CUSTOM) {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getSubGroupNode(subGroupName, subGroupType, groupName, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
    }

    public static void addFileToTree(String fileName, String groupName, int groupType, String projectName, int projectType, DefaultTreeModel model) {
        if (to.getGroupNode(groupName, groupType, projectName) == null) {
            to.addChildTo(to.getProjectNode(projectName, projectType), groupName, groupType, model);
        }
        if (groupType == GroupNode.GROUP_CUSTOM) {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, "", "", model);
        } else {
            to.addChildTo(to.getGroupNode(groupName, groupType, projectName), fileName, ProjectItemNode.NODE_FILE, model);
        }
    }

    public static boolean hasSubGroup(String path) {
        switch (getGroupType(path)) {
            case GroupNode.GROUP_SYSTEM_FONTS:
            case GroupNode.GROUP_SYSTEM_MEDIA:
            case GroupNode.GROUP_DATA_LOCAL:
                return true;
            case GroupNode.GROUP_CUSTOM:
                if (path.startsWith("customize")) {
                    path = path.substring(path.indexOf("/", path.indexOf("/", path.indexOf("/") + 1) + 1) + 1, path.length());
                    if (path.contains("/")) {
                        return true;
                    } else {
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
//        } else if (path.startsWith("system")) {
//            switch (groupName) {
//                case "Boot Animations":
//                    path = "Default";
//                    break;
//                case "Fonts":
//                    path = "System";
//                    break;
//            }
        }
        return path;
    }

    public static String getGroupName(String path) {
        String fullPath = path;
        if (path.startsWith("customize")) {
            path = path.substring(path.indexOf("/", path.indexOf("/") + 1) + 1, path.indexOf("/", path.indexOf("/", path.indexOf("/") + 1) + 1));
            return path;
        } else if (path.startsWith("system") || path.startsWith("data")) {
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
                if (fullPath.startsWith("data/app")) {
                    return "Data Apps";
                } else {
                    return "System Apps";
                }
            case "priv-app":
                return "Private Apps";
//            case "csc":
//                return "System Csc";
//            case "etc":
//                return "System Etc";
//            case "lib":
//                return "Libraries";
            case "local":
                if (fullPath.startsWith("data/local")) {
                    return "Boot Animations";
                } else {
                    break;
                }
//            case "preload":
//                //return;
//                break;
//            case "framework":
//                return "Frameworks";
//            case "fonts":
//                return "Fonts";
            case "custom":
                return "custom";
            default:
                if (fullPath.startsWith("system/media")) {
//                    if (fullPath.equals("system/media/bootanimation.zip")) {
//                        return "Boot Animations";
//                    }
                    fullPath = fullPath.substring(0, fullPath.lastIndexOf("/"));
                    switch (fullPath) {
                        case "system/media/audio/notifications":
                            return "Notifications Tones";
                        case "system/media/audio/ringtones":
                            return "Ringtones";
                        case "system/media/audio/alarms":
                            return "Alarm Tones";
                        case "system/media/audio/ui":
                            return "UI Tones";
                        default:
                            return "Others";
                    }
                } else {
                    return "Others";
                }
        }
        return path;
    }

    public static int getGroupType(String path) {
        String fullPath = path;
        if (path.startsWith("customize")) {
            path = path.substring(path.indexOf("/", path.indexOf("/") + 1) + 1, path.length());
        } else if (path.startsWith("system") || path.startsWith("data")) {
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
                //case "csc":
                return GroupNode.GROUP_SYSTEM_CSC;
            case "system_etc":
                //case "etc":
                return GroupNode.GROUP_SYSTEM_ETC;
            case "system_lib":
                //case "lib":
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
                //case "framework":
                return GroupNode.GROUP_SYSTEM_FRAMEWORK;
            case "system_fonts":
                //case "fonts":
                return GroupNode.GROUP_SYSTEM_FONTS;
            case "system_media":
                return GroupNode.GROUP_SYSTEM_MEDIA;
            case "data_local":
                return GroupNode.GROUP_DATA_LOCAL;
            case "custom":
                return GroupNode.GROUP_CUSTOM;
            case "Other":
                return GroupNode.GROUP_OTHER;
            default:
                if (fullPath.startsWith("system/media")) {
//                    if (fullPath.equals("system/media/bootanimation.zip")) {
//                        return GroupNode.GROUP_SYSTEM_MEDIA;
//                    }
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
                } else {
                    return GroupNode.GROUP_OTHER;
                }
        }
        //return -1;
    }
}
