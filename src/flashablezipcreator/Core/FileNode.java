/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Core;

import java.io.File;

/**
 *
 * @author Nikhil
 */
public class FileNode extends ProjectItemNode {

    public String fileName;
    public String fileSourcePath;
    public String fileDestPath;
    public String installLocation;
    public String belongsToGroup;
    public String filePermission;
    public String fileDescription;
    public String fileZipPath = "";

    public FileNode(String fileSourcePath, GroupNode parent) {
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = parent.getLocation();
        setPermissions(parent);
//        if (parent.groupType == GroupNode.GROUP_AROMA_THEMES) {
            this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
            this.fileSourcePath = this.fileDestPath;
//        } else {
//            this.fileSourcePath = fileSourcePath;
//            this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
//        }
        fileZipPath = getZipPath();
    }

    public FileNode(String fileSourcePath, SubGroupNode parent) {
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = parent.getLocation();
        setPermissions(parent);
        this.fileSourcePath = fileSourcePath;
        this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
        fileZipPath = getZipPath();
    }

    public FileNode(String fileSourcePath, String installLocation, String permission, ProjectItemNode parent) {
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = installLocation;
        fileName = title;
        this.fileSourcePath = fileSourcePath;
        this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
        this.filePermission = permission;
        belongsToGroup = (parent.type == SubGroupNode.TYPE_CUSTOM) ? parent.parent.toString() : parent.toString();
        fileZipPath = getZipPath();
    }

    public void setPermissions(GroupNode parent) {
        switch (parent.groupType) {
            case GroupNode.GROUP_SYSTEM_APK:
            case GroupNode.GROUP_SYSTEM_CSC:
            case GroupNode.GROUP_SYSTEM_ETC:
            case GroupNode.GROUP_SYSTEM_FRAMEWORK:
            case GroupNode.GROUP_SYSTEM_LIB:
            case GroupNode.GROUP_SYSTEM_PRIV_APK:
                setPermissions("0", "0", "0644", parent.location + "/" + title);
                break;
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI:
            case GroupNode.GROUP_DATA_APP:
                setPermissions("1000", "1000", "0644", parent.location + "/" + title);
                break;

        }
    }

    public void setPermissions(SubGroupNode parent) {
        switch (parent.subGroupType) {
            case SubGroupNode.TYPE_SYSTEM_FONTS:
            case SubGroupNode.TYPE_SYSTEM_MEDIA:
                setPermissions("1000", "1000", "0644", parent.location + "/" + title);
                break;
            case SubGroupNode.TYPE_DATA_LOCAL:
                setPermissions("1000", "1000", "0664", parent.location + "/" + title);
                break;
        }
    }

    //this will generate a path that will be used as destination path of file in output zip.
    public final String getZipPath() {
        String str = "";
        str = fileDestPath;
        //System.out.println("String before : " + str);
        str = str.substring(str.indexOf(File.separator) + 1, str.length());
        str = str.substring(str.indexOf(File.separator) + 1, str.length());
        switch (parent.type) {
            case ProjectItemNode.NODE_GROUP:
                switch (((GroupNode) parent).groupType) {
                    case GroupNode.GROUP_SYSTEM_APK:
                        str = "system_app" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_PRIV_APK:
                        str = "system_priv_app" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_CSC:
                        str = "system_csc" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_ETC:
                        str = "system_etc" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_LIB:
                        str = "system_lib" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
                        str = "system_media_alarms" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
                        str = "system_media_notifications" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
                        str = "system_media_ringtones" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI:
                        str = "system_media_ui" + File.separator + str;
                        break;
                    case GroupNode.GROUP_DATA_APP:
                        str = "data_app" + File.separator + str;
                        break;
                    case GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP:
                        str = "system_preload" + File.separator + str;
                        break;
                    case GroupNode.GROUP_SYSTEM_FRAMEWORK:
                        str = "system_framework" + File.separator + str;
                        break;
                    case GroupNode.GROUP_CUSTOM:
                        str = "custom" + File.separator + str;
                        break;
                    case GroupNode.GROUP_AROMA_THEMES:
                        return this.fileDestPath.replaceAll("\\\\", "/");
                    //case GroupNode.GROUP_OTHER not needed and
                    //case GroupNode.GROUP_META_INF not needed.
                }
                break;
            case ProjectItemNode.NODE_SUBGROUP:
                switch (((SubGroupNode) parent).subGroupType) {
                    case SubGroupNode.TYPE_SYSTEM_FONTS:
                        str = "system_fonts" + File.separator + str;
                        break;
                    case SubGroupNode.TYPE_SYSTEM_MEDIA:
                        str = "system_media" + File.separator + str;
                        break;
                    case SubGroupNode.TYPE_DATA_LOCAL:
                        str = "data_local" + File.separator + str;
                        break;
                    case SubGroupNode.TYPE_CUSTOM:
                        str = "custom" + File.separator + str;
                        break;
                }
                break;
        }
        str = "customize" + File.separator + str;
        //System.out.println("String after : " + str);
        str = str.replaceAll("\\\\", "/");
        return str;
    }

    public void setPermissions(String i, String j, String k, String path) {
        this.filePermission = i + ", " + j + ", " + k + ", \"" + path + "\"";
    }

}
