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
public class FileNode extends ProjectItemNode{

    public String fileName;
    public String fileSourcePath;
    public String fileDestPath;
    public String installLocation;
    public String belongsToGroup;
    public String filePermission;
    public String fileDescription;
    
    public FileNode(String fileSourcePath, GroupNode parent){
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = parent.getLocation();
        this.filePermission = parent.getPermissions();
        this.fileSourcePath = fileSourcePath;
        //System.out.println(parent.getPath());
        this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
    }
    
    public FileNode(String fileSourcePath, SubGroupNode parent){
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = parent.getLocation();
        this.filePermission = parent.getPermissions();
        this.fileSourcePath = fileSourcePath;
        //System.out.println(parent.getPath());
        this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
    }
    
    public FileNode(String fileSourcePath, String installLocation, String permission, ProjectItemNode parent) {
        super((new File(fileSourcePath)).getName(), ProjectItemNode.NODE_FILE, parent);
        this.installLocation = installLocation;
        fileName = title;
        this.fileSourcePath = fileSourcePath;
        //System.out.println(parent.getPath());
        this.fileDestPath = parent.path + File.separator + (new File(fileSourcePath)).getName();
        this.filePermission = permission;
        belongsToGroup = (parent.type == SubGroupNode.TYPE_CUSTOM) ? parent.parent.toString() : parent.toString();
    }
    
}
