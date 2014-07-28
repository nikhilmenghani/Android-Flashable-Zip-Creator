/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import static flashablezipcreator.AFZC.Protocols.p;
import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.ProjectTreeBuilder;
import flashablezipcreator.Operations.ProjectOperations;
import flashablezipcreator.Operations.UpdaterScriptOperations;
import flashablezipcreator.Operations.TreeOperations;
import flashablezipcreator.Protocols.Export;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class JTree extends JFrame implements TreeSelectionListener {

    /**
     * Creates new form JTreeDemo
     */
    DefaultTreeModel model;
    TreeOperations to;
    UpdaterScriptOperations uso;
    ProjectOperations po = new ProjectOperations();
    public JTree() throws IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws IOException {

        textField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        //tree configurations
        tree = ProjectTreeBuilder.buildTree();
        model = ProjectTreeBuilder.buildModel();
        jScrollPane1 = ProjectTreeBuilder.buildScrollPane();
        tree.addTreeSelectionListener(this);
        this.to = new TreeOperations(ProjectTreeBuilder.rootNode);
        uso = new UpdaterScriptOperations();

        p();
        p("new test");
        p();
        p("ProjectList");
        System.out.println(to.getNodeList(ProjectItemNode.NODE_PROJECT));
        p();
        p("Group list");
        System.out.println(to.getNodeList(ProjectItemNode.NODE_GROUP));
        p();
        p("SubGroup List");
        System.out.println(to.getNodeList(ProjectItemNode.NODE_SUBGROUP));
        p();
        p("File List");
        System.out.println(to.getNodeList(ProjectItemNode.NODE_FILE));
        p();
        
        p(uso.initiateUpdaterScript());
        for(ProjectItemNode node : to.getNodeList(ProjectItemNode.NODE_GROUP)){
            //p(so.addCheckBox((GroupNode)node));
            p(uso.generateUpdaterScript((GroupNode)node));
        }
        p(uso.terminateUpdaterScript());
        
        Export e = new Export();
        e.createZip(to.getNodeList(ProjectItemNode.NODE_FILE));
        
        //to expand all the rows
        to.expandDirectories(tree);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addButton.setText(">");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addButtonActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JTree.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        removeButton.setText("<");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField)
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton)
                        .addContainerGap(170, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();
        System.out.println();
//        switch (node.type) {
//            case ProjectItemNode.NODE_GROUP:
//                //to add Group Node
//                to.addChildTo(node, textField.getText(), GroupNode.GROUP_SYSTEM_APK, model);
//                break;
//            case ProjectItemNode.NODE_SUBGROUP:
//                //to add SubGroup Node
//                to.addChildTo(node, textField.getText(), SubGroupNode.TYPE_SYSTEM_MEDIA, model);
//        }
        //to add File Node
        to.addChildTo(node, textField.getText(), ProjectNode.PROJECT_AROMA, model);
//        this.tree = ProjectTreeBuilder.buildTree();
//        this.model = ProjectTreeBuilder.buildModel();
//        this.jScrollPane1 = ProjectTreeBuilder.buildScrollPane();
//        model.reload();
        //model.reload(node);
        to.expandDirectories(tree);
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();
        node.removeChild(node, model);
        to.expandDirectories(tree);
    }

    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField textField;
    private javax.swing.JTree tree;

    @Override
    public void valueChanged(TreeSelectionEvent tse) {
        ProjectItemNode node = (ProjectItemNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if (node instanceof FileNode) {
            System.out.println(((FileNode) node).parent);
        }
        if (node instanceof GroupNode) {
            System.out.println(((GroupNode) node).location);
        }
        //System.out.println(((FileNode)node).filePermission);

        //JOptionPane.showMessageDialog(this, "You have selected: " + node);
    }
}
