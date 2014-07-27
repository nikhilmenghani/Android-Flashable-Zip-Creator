/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.SubGroupNode;

/**
 *
 * @author Nikhil
 */
public class ScriptOperations {

    String splashPath = "splash/AFZC";
    String fontsPath = "ttf/Roboto-Regular.ttf;ttf/DroidSansFallback.ttf;";
    public static final int installString = 1;
    public static final int deleteString = 2;
    public static final int normalString = 3;

    public String addSplashString() {
        return "anisplash(\n"
                + "2,\n"
                + "\"" + splashPath + "\", 1200\n"
                + ");";
    }

    public String addFontsString() {
        return "fontresload(\"0\", \"" + fontsPath + "\", \"12\");\n"
                + "fontresload(\"1\", \"" + fontsPath + "\", \"14\");";
    }

    public String addAgreeBox() {
        return "agreebox(\"Important notes!\","
                + " \"Terms & Conditions\","
                + " \"@alert\","
                + "resread(\"Terms and Conditions.txt\"),"
                + " \"I agree with these Terms of Use...\","
                + " \"You need to agree with the Terms of Use...\");";
    }

    public String addSelectBox(GroupNode node) {
        String str = "";
        switch (node.groupType) {
            case GroupNode.GROUP_DATA_LOCAL:
            case GroupNode.GROUP_SYSTEM_MEDIA:
            case GroupNode.GROUP_SYSTEM_FONTS:
            case GroupNode.GROUP_CUSTOM:
                //following condition is for custom group
                if (!node.isSelectBox()) {
                    break;
                }
                str += "selectbox(\"" + node.title + " List\",\"Select from " + node.title + "\",\"@personalize\",\"" + node.prop + "\",\n"
                        + "\"Select one from the list\", \"\", 2,\n"
                        + "\"Select None\",\"Skip this Group.\", 1";
                for (int i = 0; i < node.getChildCount(); i++) {
                    str += ",\n\"" + node.getChildAt(i).toString() + "\", \"\", 0";
                }
                str += ");\n";
                str += "writetmpfile(\"" + node.prop + "\",readtmpfile(\"" + node.prop + "\"));\n";
                break;
        }
        return str;
    }

    public String addPrintString(String str, int type) {
        switch (type) {
            case installString:
                return "ui_print(\"Installing " + str + "\");\n";
            case deleteString:
                return "ui_print(\"Deleting " + str + "\");\n";
        }
        return "ui_print(\"" + str + "\");\n";
    }

    public String addPrintString(String str) {
        return "ui_print(\"" + str + "\");\n";
    }

    public String initiateUpdaterScript() {
        return addPrintString("@Starting the install process")
                + addPrintString("Setting up required tools...")
                + addPrintString("Mounting Partitions...")
                + getMountMethod(1);
    }

    public String terminateUpdaterScript() {
        return "unmount(\"/data\");\n"
                + "unmount(\"/system\");\n"
                + addPrintString("@Finished Install");
    }

    public String getMountMethod(int type) {
        switch (type) {
            case 1:
                return "run_program(\"/sbin/busybox\",\"mount\", \"/system\");\n"
                        + "run_program(\"/sbin/busybox\",\"mount\", \"/data\");\n";
            case 2:
                //future aspect
                break;
        }
        return "";
    }

    public String generateUpdaterScript(GroupNode node) {
        String str = "";
        switch (node.groupType) {
            //Group of predefined locations
            case GroupNode.GROUP_SYSTEM_APK:
            case GroupNode.GROUP_SYSTEM_PRIV_APK:
            case GroupNode.GROUP_SYSTEM_CSC:
            case GroupNode.GROUP_SYSTEM_ETC:
            case GroupNode.GROUP_SYSTEM_LIB:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI:
            case GroupNode.GROUP_DATA_APP:
            case GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP:
                if (node.isCheckBox()) {
                    int count = 1;
                    str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"item.1." + count++ + "\")==\"1\") then \n";
                    for (ProjectItemNode file : node.children) {
                        str += addPrintString(((FileNode) file).title, installString);
                        str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                        str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                    }
                    str += "endif;\n";
                    for (ProjectItemNode file : node.children) {
                        str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"item.1." + count++ + "\")==\"1\") then \n"
                                + addPrintString(((FileNode) file).title, installString)
                                + "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                                str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                str += "endif;\n";
                    }
                } else {
                    System.out.println("This Group doesn't support selectBox");
                }
                break;
            //Group of predefined locations that need subgroups
            case GroupNode.GROUP_SYSTEM_FONTS:
            case GroupNode.GROUP_DATA_LOCAL:
            case GroupNode.GROUP_SYSTEM_MEDIA:
                if (node.isSelectBox()) {
                    int count = 2;
                    for (ProjectItemNode subGroup : node.children) {
                        str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"selected.1\")==\"" + count++ + "\") then \n";
                        str += addPrintString(((SubGroupNode) subGroup).title, installString);
                        for (ProjectItemNode file : subGroup.children) {
                            switch (node.groupType) {
                                case GroupNode.GROUP_SYSTEM_FONTS:
                                    str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                                    str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                    break;
                                case GroupNode.GROUP_DATA_LOCAL:
                                case GroupNode.GROUP_SYSTEM_MEDIA:
                                    //this will rename any zip package to bootamination.zip allowing users to add bootanimation.zip with custom names.
                                    str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + "bootanimation.zip" + "\");\n";
                                    str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                    break;
                            }
                        }
                        str += "endif;\n";
                    }
                }
                break;
            //Group of custom location.
            case GroupNode.GROUP_CUSTOM:
                if (node.isCheckBox()) {
                    int count = 1;
                    str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"item.1." + count++ + "\")==\"1\") then \n";
                    for (ProjectItemNode tempNode : node.children) {
                        switch (tempNode.type) {
                            case ProjectItemNode.NODE_SUBGROUP:
                                str += addPrintString(((SubGroupNode) tempNode).title, installString);
                                for (ProjectItemNode file : tempNode.children) {
                                    str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                                    str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                }
                                break;
                            case ProjectItemNode.NODE_FILE:
                                str += addPrintString(((FileNode) tempNode).title, installString);
                                str += "package_extract_file(\"" + ((FileNode) tempNode).getZipPath() + "\", \"" + ((FileNode) tempNode).installLocation + "/" + ((FileNode) tempNode).title + "\");\n";
                                str += "set_perm(" + ((FileNode) tempNode).filePermission + ");\n";
                        }
                    }
                    str += "endif;\n";
                    for (ProjectItemNode tempNode : node.children) {
                        switch (tempNode.type) {
                            case ProjectItemNode.NODE_SUBGROUP:
                                str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"item.1." + count++ + "\")==\"1\") then \n";
                                str += addPrintString(((SubGroupNode) tempNode).title, installString);
                                for (ProjectItemNode file : tempNode.children) {
                                    str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                                    str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                }
                                str += "endif;\n";
                                break;
                            case ProjectItemNode.NODE_FILE:
                                str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"item.1." + count++ + "\")==\"1\") then \n";
                                str += addPrintString(((FileNode) tempNode).title, installString);
                                str += "package_extract_file(\"" + ((FileNode) tempNode).getZipPath() + "\", \"" + ((FileNode) tempNode).installLocation + "/" + ((FileNode) tempNode).title + "\");\n";
                                str += "set_perm(" + ((FileNode) tempNode).filePermission + ");\n";
                                str += "endif;\n";
                        }
                    }
                } else if (node.isSelectBox()) {
                    int count = 2;
                    for (ProjectItemNode tempNode : node.children) {
                        switch (tempNode.type) {
                            case ProjectItemNode.NODE_SUBGROUP:
                                str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"selected.1\")==\"" + count++ + "\") then \n";
                                str += addPrintString(((SubGroupNode) tempNode).title, installString);
                                for (ProjectItemNode file : tempNode.children) {
                                    str += "package_extract_file(\"" + ((FileNode) file).getZipPath() + "\", \"" + ((FileNode) file).installLocation + "/" + ((FileNode) file).title + "\");\n";
                                    str += "set_perm(" + ((FileNode) file).filePermission + ");\n";
                                }
                                str += "endif;\n";
                                break;
                            case ProjectItemNode.NODE_FILE:
                                str += "if (file_getprop(\"/tmp/aroma/" + node.prop + "\", \"selected.1\")==\"" + count++ + "\") then \n";
                                str += addPrintString(((FileNode) tempNode).title, installString);
                                str += "package_extract_file(\"" + ((FileNode) tempNode).getZipPath() + "\", \"" + ((FileNode) tempNode).installLocation + "/" + ((FileNode) tempNode).title + "\");\n";
                                str += "set_perm(" + ((FileNode) tempNode).filePermission + ");\n";
                                str += "endif;\n";
                        }
                    }
                    str += "endif;\n";
                }
                break;
        }
        return str;
    }

    public String addCheckBox(GroupNode node) {
        String str = "";
        switch (node.groupType) {
            case GroupNode.GROUP_SYSTEM_APK:
            case GroupNode.GROUP_SYSTEM_PRIV_APK:
            case GroupNode.GROUP_SYSTEM_CSC:
            case GroupNode.GROUP_SYSTEM_ETC:
            case GroupNode.GROUP_SYSTEM_LIB:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
            case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI:
            case GroupNode.GROUP_DATA_APP:
            case GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP:
            case GroupNode.GROUP_CUSTOM:
                //following condition is for custom group
                if (!node.isCheckBox()) {
                    break;
                }
                str += "checkbox(\"" + node.title + " List\",\"Select from " + node.title + "\",\"@personalize\",\"" + node.prop + "\",\n"
                        + "\"Select files from the list\", \"\", 2,\n"
                        + "\"Select All\",\"Installs All Files.\", 1";
                for (int i = 0; i < node.getChildCount(); i++) {
                    str += ",\n\"" + node.getChildAt(i).toString() + "\", \"\", 0";
                }
                str += ");\n";
                str += "writetmpfile(\"" + node.prop + "\",readtmpfile(\"" + node.prop + "\"));\n";
                break;
        }
        return str;
    }

    public String addCheckViewBox() {
        String str = "checkviewbox(\n"
                + "\"Ready to Install\",\n"
                + "    \"The wizard is ready to begin installation.\\n\\n\"+\n"
                + "	\"Press <b>Next</b> to begin the installation.\\n\\n\"+\n"
                + "	\"If you want to review or change any of your installation settings, press <b>Back</b>. Press Left Hard Button -> Quit Installation to exit the wizard.\\n\\n\\n\\n\\n\\n\\n\",\n"
                + "    \"@install\",\n"
                + "\"<b>Clear Dalvik Cache</b> After Installation.\",\n"
                + "\"0\",\n"
                + "\"clear_it\");\n"
                + "if\n"
                + "  getvar(\"clear_it\")==\"1\"\n"
                + "then\n"
                + "  writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n"
                + "endif;\n";
        return str;
    }

    public String setNextText(String text) {
        return "ini_set(\"text_next\", \"" + text + "\");\n";
    }

    public String addInstallString() {
        return "install(\"Installing\", \"Your selected files are being installed. Please Wait...\", \"@install\");\n";
    }

}
