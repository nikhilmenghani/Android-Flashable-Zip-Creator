/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Operations.TreeOperations;
import flashablezipcreator.Operations.UpdaterScriptOperations;

/**
 *
 * @author Nikhil
 */
public class UpdaterScript {

    public static String updaterScript = "";
    public static TreeOperations to;
    public static UpdaterScriptOperations op = new UpdaterScriptOperations();
    public static String updaterScriptPath = "META-INF/com/google/android/updater-script";

    public static String build(ProjectItemNode rootNode) {
        updaterScript = "";
        to = new TreeOperations(rootNode);
        updaterScript += op.initiateUpdaterScript();
        for (ProjectItemNode project : to.getProjectsSorted(rootNode)) {
            if (((ProjectNode) project).createZip) {
                switch (((ProjectNode) project).projectType) {
                    case ProjectNode.PROJECT_ROM:
                        updaterScript += buildAdvancedScript((ProjectNode) project);
                        break;
                    case ProjectNode.PROJECT_GAPPS:
                        updaterScript += buildAdvancedScript((ProjectNode) project);
                        break;
                    case ProjectNode.PROJECT_AROMA:
                        updaterScript += buildAromaScript((ProjectNode) project);
                        break;
                    case ProjectNode.PROJECT_NORMAL:
                        updaterScript += buildNormalScript((ProjectNode) project);
                        break;

                    //following is not needed. added just in case.
                    case ProjectNode.PROJECT_ADVANCED:
                        break;
                }
            }
        }
        updaterScript += op.addWipeDalvikCacheString();
        updaterScript += op.addPrintString("@Finished Install");
        return updaterScript;
    }

    public static String buildNormalScript(ProjectNode project) {
        String str = "";
        return str;
    }

    public static String buildAromaScript(ProjectNode project) {
        String str = "";
        str += op.getMountMethod(1);
        str += "set_progress(0);\n";
        for (ProjectItemNode group : to.getNodeList(ProjectItemNode.NODE_GROUP)) {
            if (((ProjectNode) group.parent).projectType == project.projectType
                    && ((ProjectNode) group.parent).title.equals(project.title)) {
                str += op.generateUpdaterScript((GroupNode) group);
            }
        }
        str += "set_progress(1);\n";
        str += op.terminateUpdaterScript();
        return str;
    }

    public static String buildAdvancedScript(ProjectNode project) {
        String str = "";
        switch (project.projectType) {
            case ProjectNode.PROJECT_ROM:
                str += "if (file_getprop(\"/tmp/aroma/" + project.title + ".prop\", \"selected\")==\"1\") then\n";
                str += project.updater_script;
                str += "endif;\n";
                break;
            case ProjectNode.PROJECT_GAPPS:
                str += "if (file_getprop(\"/tmp/aroma/" + project.title + ".prop\", \"selected\")==\"1\") then\n";
                str += project.updater_script;
                str += "endif;\n";
                break;
        }
        str += op.getMountMethod(1);
        str += "set_progress(0);\n";
        for (ProjectItemNode group : to.getNodeList(ProjectItemNode.NODE_GROUP)) {
            if (((ProjectNode) group.parent).projectType == project.projectType
                    && ((ProjectNode) group.parent).title.equals(project.title)) {
                str += op.generateUpdaterScript((GroupNode) group);
            }
        }
        str += "set_progress(1);\n";
        str += op.terminateUpdaterScript();
        return str;
    }
}
