/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator.Core;

import java.io.File;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Nikhil
 */
public class SubGroupNode extends ProjectItemNode{
    
    String parentNodeName;
    String subGroupName;
    //String path;
    int type;
    public static int TYPE_CUSTOM = 1;
    
    public SubGroupNode(String title, int type, GroupNode parent) {
        super(title, ProjectItemNode.NODE_SUBGROUP, parent);
        subGroupName = title;
        this.type = type;
        super.path = parent.path + File.separator + title;
        System.out.println("SubGroup Path is : " + path);
    }
}
