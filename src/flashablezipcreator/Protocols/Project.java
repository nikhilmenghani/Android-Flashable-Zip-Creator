/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Operations.TreeOperations;

/**
 *
 * @author Nikhil
 */
public class Project {

    public static int romCount = 0;
    public static int gappsCount = 0;
    public static int aromaCount = 0;
    public static int normalCount = 0;

    static TreeOperations to;

    public static void countProjects(ProjectItemNode rootNode) {
        romCount = 0;
        gappsCount = 0;
        aromaCount = 0;
        normalCount = 0;
        to = new TreeOperations(rootNode);
        for (ProjectItemNode project : to.getNodeList(ProjectItemNode.NODE_PROJECT)) {
            switch (((ProjectNode) project).projectType) {
                case ProjectNode.PROJECT_ROM:
                    romCount++;
                    break;
                case ProjectNode.PROJECT_GAPPS:
                    gappsCount++;
                    break;
                case ProjectNode.PROJECT_AROMA:
                    aromaCount++;
                    break;
                case ProjectNode.PROJECT_NORMAL:
                    normalCount++;
                    break;
            }
        }
    }

    public static int returnMainProject(ProjectItemNode rootNode) {
        countProjects(rootNode);
        if (romCount > 0) {
            return ProjectNode.PROJECT_ROM;
        } else if (gappsCount > 0) {
            return ProjectNode.PROJECT_GAPPS;
        } else if (aromaCount > 0) {
            return ProjectNode.PROJECT_AROMA;
        } else if (normalCount > 0) {
            return ProjectNode.PROJECT_NORMAL;
        }
        return -1;
    }
}
