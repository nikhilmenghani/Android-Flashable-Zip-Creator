/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

/**
 *
 * @author Rajat
 */
public class ImportZipUI extends javax.swing.JFrame {

    /**
     * Creates new form ImportZipUI
     */
    public ImportZipUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportZip_panel = new javax.swing.JPanel();
        lblSelectZip = new javax.swing.JLabel();
        textFieldSelectZip = new javax.swing.JTextField();
        btnBrowseZip = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaImportZipLog = new javax.swing.JTextArea();
        lblProgress = new javax.swing.JLabel();
        progressImportZip = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelectZip.setText("Select Zip : ");

        textFieldSelectZip.setEditable(false);
        textFieldSelectZip.setText("Click Browse To Select Zip File...");

        btnBrowseZip.setText("Browse..");
        btnBrowseZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseZipActionPerformed(evt);
            }
        });

        textAreaImportZipLog.setColumns(20);
        textAreaImportZipLog.setRows(5);
        jScrollPane1.setViewportView(textAreaImportZipLog);

        lblProgress.setText("Progress : ");

        javax.swing.GroupLayout ImportZip_panelLayout = new javax.swing.GroupLayout(ImportZip_panel);
        ImportZip_panel.setLayout(ImportZip_panelLayout);
        ImportZip_panelLayout.setHorizontalGroup(
            ImportZip_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportZip_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImportZip_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImportZip_panelLayout.createSequentialGroup()
                        .addComponent(lblSelectZip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSelectZip, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseZip))
                    .addGroup(ImportZip_panelLayout.createSequentialGroup()
                        .addComponent(lblProgress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(progressImportZip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        ImportZip_panelLayout.setVerticalGroup(
            ImportZip_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportZip_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImportZip_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectZip)
                    .addComponent(textFieldSelectZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseZip))
                .addGap(17, 17, 17)
                .addGroup(ImportZip_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImportZip_panelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblProgress))
                    .addComponent(progressImportZip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(ImportZip_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(ImportZip_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseZipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseZipActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImportZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ImportZipUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImportZip_panel;
    private javax.swing.JButton btnBrowseZip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblSelectZip;
    private javax.swing.JProgressBar progressImportZip;
    private javax.swing.JTextArea textAreaImportZipLog;
    private javax.swing.JTextField textFieldSelectZip;
    // End of variables declaration//GEN-END:variables
}
