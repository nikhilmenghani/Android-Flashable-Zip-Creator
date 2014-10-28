/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Core;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.TreePath;

/**
 *
 * @author ANSHU
 */
public class ProjectMouseAdapter extends MouseAdapter{
    private void myPopupEvent(MouseEvent e) {
                //System.out.println("Yo!");
                int x = e.getX();
                int y = e.getY();
                javax.swing.JTree myTree = (javax.swing.JTree) e.getSource();
                ProjectItemNode node = (ProjectItemNode) myTree.getLastSelectedPathComponent();
                if (node == null) {
                    return;
                }
                if (node instanceof FileNode) {
                    System.out.println(((FileNode) node).installLocation);
                }
                if (node instanceof GroupNode) {
                    System.out.println(((GroupNode) node).location);
                }
                TreePath path = (TreePath) myTree.getPathForLocation(x, y);
                if (path == null) {
                    return;
                }
                myTree.setSelectionPath(path);
//                JPopupMenu popup = new JPopupMenu();
//                popup.add(new JMenuItem(path.getLastPathComponent().toString()));
//                popup.add(new JMenuItem("Test"));
//                popup.show(myTree, x, y);
                JPopupMenu popup = MyPopup.getGroupPopup();
                Component[] menu = popup.getComponents();
                
                menu[1].addMouseListener(new java.awt.event.MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        System.out.println("Mouse Clicked here ");
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        System.out.println("Mouse pressed here");
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        System.out.println("Mouse Released here " + menu[1].getName());
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        System.out.println("Mouse entered here");
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        System.out.println("Mouse exited here");
                    }
                });
                popup.show(myTree, x, y);
            }

            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    myPopupEvent(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    myPopupEvent(e);
                }
            }
}
