/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.Core.GroupNode;

/**
 *
 * @author Nikhil
 */
public class AromaScriptOperations {

    String splashPath = "splash/AFZC";
    String fontsPath = "ttf/Roboto-Regular.ttf;ttf/DroidSansFallback.ttf;";

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
            case GroupNode.GROUP_SYSTEM_FRAMEWORK:
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
