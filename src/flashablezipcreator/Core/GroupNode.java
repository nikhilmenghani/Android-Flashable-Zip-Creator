/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Core;

import java.io.File;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Nikhil
 */
public class GroupNode extends ProjectItemNode {

    public String groupName;
    public String location;
    public String permissions;
    public int groupType;
    public String prop;
    public boolean isSelectBox = false;

    public static final int GROUP_SYSTEM_APK = 1;
    public static final int GROUP_SYSTEM_PRIV_APK = 2;
    public static final int GROUP_SYSTEM_LIB = 3;
    public static final int GROUP_PRELOAD_SYMLINK_SYSTEM_APP = 4;
    public static final int GROUP_SYSTEM_ETC = 5;
    public static final int GROUP_SYSTEM_CSC = 6;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_ALARMS = 7;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS = 8;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES = 9;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_UI = 10;
    public static final int GROUP_SYSTEM_MEDIA = 11;
    public static final int GROUP_SYSTEM_FONTS = 12;
    public static final int GROUP_DATA_APP = 13;
    public static final int GROUP_DATA_LOCAL = 14;
    public static final int GROUP_CUSTOM = 15;

    public GroupNode(String title, int type, ProjectNode parent) {
        super(title, ProjectItemNode.NODE_GROUP, parent);
        this.groupType = type;
        this.groupName = title;
        super.path = parent.path + File.separator + title;
        System.out.println("Group Path is : " + path);

        switch (type) {
            case GROUP_SYSTEM_APK:
                this.location = "system/app";
                this.permissions = "rwrr";
                this.prop = "system_app.prop";
                break;
            case GROUP_SYSTEM_PRIV_APK:
                this.location = "system/priv-app";
                this.permissions = "rwrr";
                this.prop = "system_priv.prop";
                break;
            case GROUP_SYSTEM_LIB:
                this.location = "system/lib";
                this.permissions = "rwrr";
                this.prop = "system_lib.prop";
                break;
            case GROUP_CUSTOM:
                this.location = "";
                this.permissions = "";
                this.prop = "custom.prop";
                this.isSelectBox = false;
                break;
        }
    }
    
    public boolean isSelectBox(){
        return isSelectBox;
    }
    
    public boolean isCheckBox(){
        return !isSelectBox;
    }

    public String getLocation() {
        return location;
    }

    public String getPermissions() {
        return permissions;
    }
}
