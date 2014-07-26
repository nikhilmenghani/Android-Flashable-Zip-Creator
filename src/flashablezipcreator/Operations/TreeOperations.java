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
import flashablezipcreator.DiskOperations.Write;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class TreeOperations {

    Write w = new Write();
    ArrayList<ProjectItemNode> list = new ArrayList<>();
    ProjectItemNode rootNode;

    public TreeOperations(ProjectItemNode rootNode){
        this.rootNode = rootNode;
    }
    
    public void addChildTo(ProjectItemNode node, String childTitle, int childType, DefaultTreeModel model) {
        switch (node.type) {
            case ProjectItemNode.NODE_ROOT:
                node.addChild(new ProjectNode(childTitle, childType, node), model);
                break;
            case ProjectItemNode.NODE_PROJECT:
                node.addChild(new GroupNode(childTitle, childType, (ProjectNode) node), model);
                break;
            case ProjectItemNode.NODE_GROUP:
                switch (((GroupNode) node).groupType) {
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
                        if (childType == ProjectItemNode.NODE_FILE) {
                            node.addChild(new FileNode(childTitle, (GroupNode) node), model);
                        } else {
                            System.out.println("You cannot add subgroup for this type..!!");
                        }
                        break;
                    //Group of predefined locations that need subgroups
                    case GroupNode.GROUP_SYSTEM_FONTS:
                    case GroupNode.GROUP_DATA_LOCAL:
                    case GroupNode.GROUP_SYSTEM_MEDIA:
                        switch (childType) {
                            case SubGroupNode.TYPE_SYSTEM_FONTS:
                            case SubGroupNode.TYPE_SYSTEM_MEDIA:
                            case SubGroupNode.TYPE_DATA_LOCAL:
                                node.addChild(new SubGroupNode(childTitle, childType, (GroupNode) node), model);
                                break;
                            case ProjectItemNode.NODE_FILE:
                                System.out.println("You cannot add files for this type..!!\n add a subgroup and then files to it..!!");
                                break;
                        }
                        break;
                    //Group of custom location.
                    case GroupNode.GROUP_CUSTOM:
                        if (childType == SubGroupNode.TYPE_CUSTOM) {
                            node.addChild(new SubGroupNode(childTitle, childType, (GroupNode) node), model);
                        }
                    //here File Node can also act as child but due to different requirements of parameters,
                    //explicit call to another addChildTo function is required.
                }
            case ProjectItemNode.NODE_SUBGROUP:
                switch (((SubGroupNode) node).subGroupType) {
                    case SubGroupNode.TYPE_SYSTEM_FONTS:
                    case SubGroupNode.TYPE_SYSTEM_MEDIA:
                    case SubGroupNode.TYPE_DATA_LOCAL:
                        node.addChild(new FileNode(childTitle, (SubGroupNode) node), model);
                        break;
                }
        }
    }

    public void addChildTo(ProjectItemNode node, String childTitle, String installLocation, String permission, DefaultTreeModel model) {
        if ((node.type == ProjectItemNode.NODE_GROUP && ((GroupNode) node).groupType == GroupNode.GROUP_CUSTOM)
                || (node.type == ProjectItemNode.NODE_SUBGROUP && ((SubGroupNode) node).subGroupType == SubGroupNode.TYPE_CUSTOM)) {
            node.addChild(new FileNode(childTitle, installLocation, permission, (GroupNode) node), model);
        }
    }

    public void removeChildFrom(ProjectItemNode node, DefaultTreeModel model) {
        node.removeChild(node, model);
    }

    public void buildDirectory() throws IOException{
        buildDirectory(this.rootNode);
    }
    
    public void buildDirectory(ProjectItemNode node) throws IOException {
        if (!node.isLeaf()) {
            w.createFolder(((ProjectItemNode) node).path);
            for (int i = 0; i < node.getChildCount(); i++) {
                buildDirectory((ProjectItemNode) node.getChildAt(i));
            }
        } else {
            try {
                //this will create a file in project folder.
                w.writeFile(((FileNode) node).fileSourcePath, ((FileNode) node).fileDestPath);
                //this will make location of file from user selected location to project location.
                ((FileNode) node).fileSourcePath = ((FileNode) node).fileDestPath;
            } catch (ClassCastException cce) {
                System.out.println("Exception caught while casting..");
            }
        }
    }

    //this will iterate from given node to leaf node i.e. File Node and return list of FileNodes.
    public ArrayList<ProjectItemNode> parseNode(ProjectItemNode node) {
        if (!node.isLeaf()) {
            for (int i = 0; i < node.getChildCount(); i++) {
                parseNode((ProjectItemNode) node.getChildAt(i));
            }
        } else {
            list.add((FileNode) node);
        }
        return list;
    }

    public ArrayList<ProjectItemNode> getNodeList(int nodeType){
        return getNodeList(this.rootNode, nodeType);
    }
    
    public ArrayList<ProjectItemNode> getNodeList(ProjectItemNode rootNode, int nodeType) {
        list = new ArrayList<>();
        ArrayList<ProjectItemNode> projectList = new ArrayList<>();
        ArrayList<ProjectItemNode> groupList = new ArrayList<>();
        ArrayList<ProjectItemNode> subGroupList = new ArrayList<>();
        ArrayList<ProjectItemNode> fileList = parseNode(rootNode);
        for (ProjectItemNode fileNode : fileList) {
            switch (fileNode.parent.type) {
                case ProjectItemNode.NODE_GROUP:
                    if (!groupList.contains(fileNode.parent)) {
                        groupList.add(fileNode.parent);
                    }
                    if (!projectList.contains(fileNode.parent.parent)) {
                        projectList.add(fileNode.parent.parent);
                    }
                    break;
                case ProjectItemNode.NODE_SUBGROUP:
                    if (!subGroupList.contains(fileNode.parent)) {
                        subGroupList.add(fileNode.parent);
                    }
                    if (!groupList.contains(fileNode.parent.parent)) {
                        groupList.add(fileNode.parent.parent);
                    }
                    if (!projectList.contains(fileNode.parent.parent.parent)) {
                        projectList.add(fileNode.parent.parent.parent);
                    }
                    break;
            }
        }
        switch (nodeType) {
            case ProjectItemNode.NODE_PROJECT:
                return projectList;
            case ProjectItemNode.NODE_GROUP:
                return groupList;
            case ProjectItemNode.NODE_SUBGROUP:
                return subGroupList;
            case ProjectItemNode.NODE_FILE:
                return fileList;
        }
        return null;
    }

    public void expandDirectories(JTree tree) {
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}
