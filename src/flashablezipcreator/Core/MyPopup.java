/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Core;

import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Nikhil
 */
public class MyPopup {
    static JPopupMenu popup;
    
    public static JPopupMenu getGroupPopup(){
        popup = new JPopupMenu();
        JMenuItem mitemAddFile = new JMenuItem("Add File");
        mitemAddFile.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Action Performed");
            }
        });
        JMenuItem mitemRenameGroup = new JMenuItem("Rename Group");
        mitemRenameGroup.setName("RenameGroup");
        JMenuItem mitemDeleteGroup = new JMenuItem("Delete Group");
        popup.add(mitemAddFile);
        popup.add(mitemRenameGroup);
        popup.add(mitemDeleteGroup);
        return popup;
    }
}
