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
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Nikhil
 */
public class TreeOperations {

    Write w = new Write();

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
        if((node.type == ProjectItemNode.NODE_GROUP && ((GroupNode) node).groupType == GroupNode.GROUP_CUSTOM) || 
                (node.type == ProjectItemNode.NODE_SUBGROUP && ((SubGroupNode) node).subGroupType == SubGroupNode.TYPE_CUSTOM)){
            node.addChild(new FileNode(childTitle, installLocation, permission, (GroupNode) node), model);
        }
    }
    
    public void removeChildFrom(ProjectItemNode node, DefaultTreeModel model){
        node.removeChild(node, model);
    }

    public void buildDirectory(TreeNode node) throws IOException {
        if (!node.isLeaf()) {
            w.createFolder(((ProjectItemNode) node).path);
            for (int i = 0; i < node.getChildCount(); i++) {
                buildDirectory(node.getChildAt(i));
            }
        } else {
            try{
                w.writeFile(((FileNode) node).fileSourcePath, ((FileNode) node).fileDestPath);
            }catch(ClassCastException cce){
                System.out.println("Exception caught while casting..");
            }
        }
    }

    public void expandDirectories(JTree tree) {
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}
