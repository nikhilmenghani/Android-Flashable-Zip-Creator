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
public class ProjectNode extends ProjectItemNode {

    public int projectType;
    public boolean createZip = true; //when multiple projects will be loaded, this will help in choosing which one to create zip of.
    public String updater_script = "";
    public String aroma_config = "";
    public byte[] update_binary = null;
    public byte[] update_binary_installer = null;
    public String romName = "I Don't Know Rom";
    public String romVersion = "I Don't Know Version";
    public String romAuthor = "I Don't Know Developer";
    public String romDevice = "I Don't Know Device";
    public String romDate = "I Don't Know Date";
    public String gappsName = "I Don't Know Name";
    public String androidVersion = "I Don't Know Version";
    public String gappsType = "I Don't Know Type";
    public String gappsDate = "I Don't Know Date";

    public static final int PROJECT_NORMAL = 1;
    public static final int PROJECT_AROMA = 2;
    public static final int PROJECT_GAPPS = 3;
    public static final int PROJECT_ROM = 4;
    public static final int PROJECT_THEMES = 5;
    public static final int PROJECT_ADVANCED = 6;
    

    public ProjectNode(String title, int projectType, ProjectItemNode parent) {
        super(title, ProjectItemNode.NODE_PROJECT, parent);
        this.projectType = projectType;
        super.path = parent + File.separator + title;
    }
}
