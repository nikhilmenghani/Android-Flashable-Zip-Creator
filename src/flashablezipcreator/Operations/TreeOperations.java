/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator.Operations;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.DiskOperations.Write;
import java.io.IOException;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Nikhil
 */
public class TreeOperations {
    Write w = new Write();
    public void buildDirectory(TreeNode node) throws IOException {
        if (!node.isLeaf()) {
            w.createFolder(((ProjectItemNode) node).path);
            for (int i = 0; i < node.getChildCount(); i++) {
                buildDirectory(node.getChildAt(i));
            }
        } else {
            w.writeFile(((FileNode) node).fileSourcePath, ((FileNode) node).fileDestPath);
        }
    }
    
    public void expandDirectories(JTree tree){
        for(int i = 0 ; i < tree.getRowCount(); i++){
            tree.expandRow(i);
        }
    }
}
