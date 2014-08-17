/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikhil
 */
public class AromaScriptOperations {

    String splashPath = "splash/AFZC";
    String fontsPath = "ttf/Roboto-Regular.ttf;";

    public String addSplashString() {
        return "anisplash(\n"
                + "2,\n"
                + "\"" + splashPath + "\", 1200\n"
                + ");\n";
    }

    public String addFontsString() {
        return "fontresload(\"0\", \"" + fontsPath + "\", \"12\");\n"
                + "fontresload(\"1\", \"" + fontsPath + "\", \"14\");\n";
    }

    public String addThemesString(ProjectItemNode rootNode) {
        String str = "selectbox(\"Themes\",\"Choose your desired theme from following\",\"@personalize\",\"theme.prop\",\n";
        int i = 1;
        for (ProjectItemNode projectNode : rootNode.children) {
            if (((ProjectNode) projectNode).projectType == ProjectNode.PROJECT_THEMES) {
                for (ProjectItemNode theme : ((ProjectNode) projectNode).children) {
                    str += "\"" + theme.title + "\", \"\", " + i + ",\n";
                    i = 0;
                }
            }
        }
        str = str.substring(0, str.length() - 2);
        str += ");\n\n";
        i = 1;
        for (ProjectItemNode projectNode : rootNode.children) {
            if (((ProjectNode) projectNode).projectType == ProjectNode.PROJECT_THEMES) {
                for (ProjectItemNode theme : ((ProjectNode) projectNode).children) {
                    str += "if prop(\"theme.prop\", \"selected.0\")==\"" + i++ + "\" then\n"
                            + "theme(\"" + theme.title + "\");\n"
                            + "endif;\n"
                            + "\n";
                }
            }
        }
        return str;
    }

    public String addFontsViewBoxString(String font) {
        String str = "";
        str = "viewbox(" + font + "\"Preview\",\n"
                + "\"Preview:\\n\\n\"+\"AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz.,1234567890\\n\\n\"+\"Are you sure you want to continue installing this font?\",\n"
                + "\"@alert\");\n";
        return str;
    }

    public String addFontsViewBoxString() {
        String str = "";
        str = "viewbox(\"Preview\",\n"
                + "\"The font \"+getvar(\"fontname\")+\"... looks like this\\n\\n\"+"
                + "\"Preview:\\n\\n\"+\"AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz.,1234567890\\n\\n\"+\"Are you sure you want to continue installing this font?\",\n"
                + "\"@alert\");\n";
        return str;
    }

    public String addAgreeBox() {
        return "agreebox(\"Important notes!\","
                + " \"Terms & Conditions\","
                + " \"@alert\","
                + "resread(\"Terms and Conditions.txt\"),"
                + " \"I agree with these Terms of Use...\","
                + " \"You need to agree with the Terms of Use...\");\n";
    }

    public String addSelectBox(GroupNode node) {
        String str = "";
        switch (node.groupType) {
            case GroupNode.GROUP_DATA_LOCAL:
            case GroupNode.GROUP_SYSTEM_MEDIA:

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
            case GroupNode.GROUP_SYSTEM_FONTS:
                if (!node.isSelectBox()) {
                    break;
                }
                str += "selectbox(\"" + node.title + " List\",\"Select from " + node.title + " List For Preview\",\"@personalize\",\"" + node.prop + "\"";
                for (int i = 0; i < node.getChildCount(); i++) {
                    str += ",\n\"" + node.getChildAt(i).toString() + "\", \"\", 0";
                }
                str += ");\n";
                if (node.groupType == GroupNode.GROUP_SYSTEM_FONTS) {
                    for (int i = 0; i < node.getChildCount(); i++) {
                        SubGroupNode sgnode = (SubGroupNode) node.getChildAt(i);
                        str += "if prop(\"" + node.prop + "\", \"selected.0\")==\"" + (i + 1) + "\" then\n";
                        for (int j = 0; j < sgnode.getChildCount(); j++) {
                            FileNode fnode = (FileNode) sgnode.getChildAt(j);
                            if (((FileNode) fnode).title.equals("DroidSans.ttf")) {
                                str += "fontresload(\"0\", \"ttf/" + sgnode.toString() + ".ttf;\", \"12\");\n";
                            }
                        }
                        str += "setvar(\"fontname\",\"" + sgnode.toString() + "\");\n";
                        str += "endif;\n";
                    }
                    str += addFontsViewBoxString();
                    str += addFontsString();
                    str += "selectbox(\"" + node.title + " List\",\"Select from " + node.title + "\",\"@personalize\",\"" + node.prop + "\",\n"
                            + "\"Select one from the list\", \"\", 2,\n"
                            + "\"Select None\",\"Skip this Group.\", 1";
                    for (int i = 0; i < node.getChildCount(); i++) {
                        str += ",\n\"" + node.getChildAt(i).toString() + "\", \"\", 0";
                    }
                    str += ");\n";
                    str += "writetmpfile(\"" + node.prop + "\",readtmpfile(\"" + node.prop + "\"));\n";
                    str += addFontsString();
                }
                break;
        }
        return str;
    }

    public String addMenuBox(ProjectNode project) {
        String str = "";
        switch (project.projectType) {
            case ProjectNode.PROJECT_GAPPS:
                str += "menubox(\"" + "Menu" + " List\",\"Select from " + "following" + "\",\"@personalize\",\"" + project.title + ".prop" + "\",\n"
                        + "\"Install\", \"Install Gapps\", \"@install\"";
                str += ",\n\"" + "Skip" + "\", \"Do Not Install Gapps\", \"@apps\"";
                str += ");\n";
                str += "writetmpfile(\"" + project.title + ".prop" + "\",readtmpfile(\"" + project.title + ".prop" + "\"));\n";
                //str += "writetmpfile(\"" + project.title + ".prop" + "\",\"true=yes\");\n";
                break;
            case ProjectNode.PROJECT_ROM:
                str += "menubox(\"" + "Menu" + " List\",\"Select from " + "following" + "\",\"@personalize\",\"" + project.title + ".prop" + "\",\n"
                        + "\"Install\", \"Install Rom\", \"@install\"";
                str += ",\n\"" + "Skip" + "\", \"Do Not Install Rom\", \"@apps\"";
                str += ");\n";
                str += "writetmpfile(\"" + project.title + ".prop" + "\",readtmpfile(\"" + project.title + ".prop" + "\"));\n";
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
                + "writetmpfile(\"dalvik_choices.prop\",\"init=no\\n\");\n"
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
