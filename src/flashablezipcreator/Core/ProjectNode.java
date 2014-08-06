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
public class ProjectNode extends ProjectItemNode{

    public int projectType;
    //public String path;
    
    public static final int PROJECT_NORMAL = 1;
    public static final int PROJECT_AROMA = 2;
    public static final int PROJECT_GAPPS = 3;
    public static final int PROJECT_ROM = 4;
    public static final int PROJECT_ADVANCED = 5;
    
    public ProjectNode(String title, int projectType, ProjectItemNode parent) {
        super(title, ProjectItemNode.NODE_PROJECT, parent);
        this.projectType = projectType;
        super.path = parent + File.separator + title;
        //System.out.println("Project Path is : " + path);
    }
    
}
