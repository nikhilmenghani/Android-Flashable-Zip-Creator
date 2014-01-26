/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Nikhil
 * @author Rajat
 */
public class AromaInstaller extends javax.swing.JFrame {//implements PropertyChangeListener{
    private CreateZip CZtask;
    private ImportZip IZtask;
    public ProgressBarUpdater ju;
    public AromaInstaller(){
        op.CSDArrayList = new ArrayList<>();
        op.CSDArrayList.add("Samsung Galaxy R");
        op.CSDArrayList.add("Samsung Galaxy Nexus");
        op.CSDArrayList.add("Samsung Galaxy Note II(N7100)");
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        contentPanel = new JPanel();
        fileModel = new DefaultListModel();
        fileListScrollPane = new JScrollPane();
        fileList = new JList(fileModel);
        groupListScrollPane = new JScrollPane();
        groupModel = new DefaultListModel();
        groupList = new JList(groupModel);
        groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                groupListSelection(lse);
            }
        });
        fileList = new JList(fileModel);
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                fileListSelection(lse);
            }
        });
        lblNote = new JLabel();
        btnAddFile = new JButton();
        btnRemoveFile = new JButton();
        lblGroup = new JLabel();
        btnAddGroup = new JButton();
        btnRemoveGroup = new JButton();
        btnApkGroup = new JButton();
        headingPanel = new JPanel();
        lblHeading = new JLabel();
        lblSubHeading = new JLabel();
        btnCreateNormalZip = new JButton();
        btnCreateAromaZip = new JButton();
        textFieldUpdateBinary = new JTextField();
        textFieldUpdateBinary.setEditable(false);
        btnBrowseUpdateBinary = new JButton();
        lblTitle = new JLabel();
        lblZipDestination = new JLabel();
        textFieldZipDestination = new JTextField();
        textFieldZipDestination.setEditable(false);
        btnBrowseZipDestination = new JButton();
        btnBootAnimGroup = new JButton();
        btnRingtonesGroup = new JButton();
        btnNotifGroup = new JButton();
        btnKernelGroup = new JButton();
        btnDeleteSystemFilesGroup = new JButton();
        btnSelectDevice = new JButton();
        btnResetAll = new JButton();
        btnAdvancedGroup = new JButton();
        btnLoadAromaFlashableZip = new JButton();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        openMenuItem = new JMenuItem();
        saveMenuItem = new JMenuItem();
        saveAsMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        editMenu = new JMenu();
        cutMenuItem = new JMenuItem();
        copyMenuItem = new JMenuItem();
        pasteMenuItem = new JMenuItem();
        deleteMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        contentsMenuItem = new JMenuItem();
        aboutMenuItem = new JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(new javax.swing.border.MatteBorder(null));

        fileList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fileListScrollPane.setViewportView(fileList);

        groupList.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        groupListScrollPane.setViewportView(groupList);

        lblNote.setText("Create Group and select items to add into the group...");

        btnAddFile.setBackground(new java.awt.Color(153, 180, 209));
        btnAddFile.setText("Add File...");
        btnAddFile.setActionCommand("Add File");
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        btnRemoveFile.setText("Remove File...");
        btnRemoveFile.setActionCommand("Remove File");
        btnRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFileActionPerformed(evt);
            }
        });

        lblGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGroup.setText("Apk Group");

        btnAddGroup.setText("Add Group...");
        btnAddGroup.setActionCommand("Add Group");
        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGroupActionPerformed(evt);
            }
        });

        btnRemoveGroup.setText("Remove Group...");
        btnRemoveGroup.setActionCommand("Remove Group");
        btnRemoveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(groupListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(fileListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(btnRemoveFile, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addComponent(btnAddFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(btnAddFile, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveFile, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addGap(205, 205, 205))
                            .addComponent(fileListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnApkGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnApkGroup.setSelected(true);
        btnApkGroup.setText("APKs Group");
        btnApkGroup.setActionCommand("APKs Group");
        btnApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApkGroupActionPerformed(evt);
            }
        });

        headingPanel.setBackground(new java.awt.Color(0, 0, 0));
        headingPanel.setForeground(new java.awt.Color(255, 255, 255));

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Android Flashable Zip Creator");

        lblSubHeading.setForeground(new java.awt.Color(204, 204, 204));
        lblSubHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubHeading.setText("By Nikhil Menghani And Rajat Patel");

        javax.swing.GroupLayout headingPanelLayout = new javax.swing.GroupLayout(headingPanel);
        headingPanel.setLayout(headingPanelLayout);
        headingPanelLayout.setHorizontalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headingPanelLayout.setVerticalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        btnCreateNormalZip.setText("Create Normal Flashable Zip");
        btnCreateNormalZip.setActionCommand("Create Normal Flashable Zip");
        btnCreateNormalZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCreateNormalZipActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(AromaInstaller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnCreateAromaZip.setText("Create Flashable Zip With Aroma Installer");
        btnCreateAromaZip.setActionCommand("Create Flashable Zip With Aroma Installer");
        btnCreateAromaZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCreateAromaZipActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(AromaInstaller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        textFieldUpdateBinary.setText("Click Here To Select updater-binary....");

        btnBrowseUpdateBinary.setText("Browse..");
        btnBrowseUpdateBinary.setActionCommand("Browse Update Binary");
        btnBrowseUpdateBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseUpdateBinaryActionPerformed(evt);
            }
        });

        lblTitle.setText("Device not in list? Then Select Working Updater Binary For Your Device : ");

        lblZipDestination.setText("Select Zip Destination : ");

        textFieldZipDestination.setText("Click Here To Select Zip Destination....");

        btnBrowseZipDestination.setText("Browse..");
        btnBrowseZipDestination.setActionCommand("Browse Zip Destination");
        btnBrowseZipDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseZipDestinationActionPerformed(evt);
            }
        });

        btnBootAnimGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnBootAnimGroup.setText("Boot Animaton Group");
        btnBootAnimGroup.setActionCommand("Boot Animation Group");
        btnBootAnimGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBootAnimGroupActionPerformed(evt);
            }
        });

        btnRingtonesGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnRingtonesGroup.setText("Ringtones Group");
        btnRingtonesGroup.setActionCommand("Ringtones Group");
        btnRingtonesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRingtonesGroupActionPerformed(evt);
            }
        });

        btnNotifGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnNotifGroup.setText("Notifications Group");
        btnNotifGroup.setActionCommand("Notifications Group");
        btnNotifGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifGroupActionPerformed(evt);
            }
        });

        btnKernelGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnKernelGroup.setText("Kernel Group");
        btnKernelGroup.setActionCommand("Kernel Group");
        btnKernelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKernelGroupActionPerformed(evt);
            }
        });

        btnDeleteSystemFilesGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnDeleteSystemFilesGroup.setText("Delete System Files Group");
        btnDeleteSystemFilesGroup.setActionCommand("Delete System Files Group");
        btnDeleteSystemFilesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSystemFilesGroupActionPerformed(evt);
            }
        });

        btnSelectDevice.setText("Select Your Device From Here");
        btnSelectDevice.setActionCommand("Select Your Device Here");
        btnSelectDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDeviceActionPerformed(evt);
            }
        });

        btnResetAll.setText("Reset All");
        btnResetAll.setActionCommand("Reset All");
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });

        btnAdvancedGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnAdvancedGroup.setText("Advanced Group");
        btnAdvancedGroup.setActionCommand("Advanced Group");
        btnAdvancedGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvancedGroupActionPerformed(evt);
            }
        });

        btnLoadAromaFlashableZip.setBackground(new java.awt.Color(153, 180, 209));
        btnLoadAromaFlashableZip.setText("Load Aroma Flashable Zip");
        btnLoadAromaFlashableZip.setActionCommand("Load Aroma Flashable Zip");
        btnLoadAromaFlashableZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAromaFlashableZipActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnApkGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBootAnimGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRingtonesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNotifGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKernelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteSystemFilesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdvancedGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadAromaFlashableZip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblZipDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldZipDestination))
                                    .addComponent(btnCreateNormalZip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnBrowseZipDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnResetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCreateAromaZip, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelectDevice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowseUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectDevice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldUpdateBinary)
                    .addComponent(btnBrowseUpdateBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnApkGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBootAnimGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRingtonesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotifGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKernelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteSystemFilesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdvancedGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoadAromaFlashableZip, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldZipDestination)
                    .addComponent(btnBrowseZipDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblZipDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateNormalZip, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnCreateAromaZip, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void addGroupUI(){
        frame= new JFrame();
        
        JDialog dialog = new JDialog(frame,"Create Group Name",true);
        
        addGroupPanel = new JPanel();
        addGroupNameTitle = new JLabel();
        groupName = new JTextField();
        
        btnContinue = new JButton();
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        
        btnCancel = new JButton();
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        
        addGroupTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addGroupNameTitle.setText("Group Name :");

        btnContinue.setText("Continue");

        btnCancel.setText("Cancel");

        addGroupTitle.setText("Enter the name of group in which files will be added.");

        javax.swing.GroupLayout addGroupPanelLayout = new javax.swing.GroupLayout(addGroupPanel);
        addGroupPanel.setLayout(addGroupPanelLayout);
        addGroupPanelLayout.setHorizontalGroup(
            addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addGroupTitle)
                    .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addComponent(addGroupNameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        addGroupPanelLayout.setVerticalGroup(
            addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(addGroupTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGroupNameTitle)
                    .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinue)
                    .addComponent(btnCancel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        pack();
        
        dialog.setContentPane(addGroupPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
            frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    //This is UI of Add Apk Group in Aroma Tab..
    public void addApkGroupUI(){
        frame= new JFrame();
        
        JDialog dialog = new JDialog(frame,"Create Group Name",true);
        
        addGroupPanel = new JPanel();
        addGroupNameTitle = new JLabel();
        groupName = new JTextField();
        
        addApkGroupRadSystem = new JRadioButton();
        addApkGroupRadSystem.setSelected(true);
        addApkGroupRadSystem.setActionCommand("Add System Apk Group");
        
        addApkGroupRadData = new JRadioButton();
        addApkGroupRadData.setActionCommand("Add Data Apk Group");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(addApkGroupRadSystem);
        buttonGroup.add(addApkGroupRadData);
        
        btnContinue = new JButton();
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        
        btnCancel = new JButton();
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        
        addGroupTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addGroupNameTitle.setText("Group Name :");

        addApkGroupRadSystem.setText("Installs to /system/app");

        addApkGroupRadData.setText("Installs to /data/app");

        btnContinue.setText("Continue");

        btnCancel.setText("Cancel");

        addGroupTitle.setText("Enter the name of group in which files will be added.");

        javax.swing.GroupLayout addGroupPanelLayout = new javax.swing.GroupLayout(addGroupPanel);
        addGroupPanel.setLayout(addGroupPanelLayout);
        addGroupPanelLayout.setHorizontalGroup(
            addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addGroupTitle)
                    .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addComponent(addGroupNameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addApkGroupRadData)
                            .addComponent(addApkGroupRadSystem)
                            .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        addGroupPanelLayout.setVerticalGroup(
            addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(addGroupTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGroupNameTitle)
                    .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addApkGroupRadSystem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addApkGroupRadData)
                .addGap(26, 26, 26)
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinue)
                    .addComponent(btnCancel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
        dialog.setContentPane(addGroupPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
            frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    public void supportedDevicesUI(){
        frame= new JFrame();
        
        JDialog dialog = new JDialog(frame,"Currently Supported Devices",true);
        
        CSD_panel = new JPanel();
       
        CSD_heading = new JLabel();
        CSD_title = new JLabel();
        CSD_note1 = new JLabel();
        CSD_note2 = new JLabel();
        CSD_note3 = new JLabel();
        
        DefaultListModel CSDModel = new DefaultListModel();
        
        CSDList = new JList(CSDModel);
        
        JScrollPane CSDScrollPanel = new JScrollPane();
        CSDScrollPanel.setViewportView(CSDList);
        
        for(String deviceName : op.CSDArrayList){
            CSDModel.addElement(deviceName);
        }
        CSDList.setSelectedValue(op.selectedDevice, true
        );
        JButton CSD_continue = new JButton();
        JButton CSD_cancel = new JButton();
        
        CSD_title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CSD_title.setText("Select Your Device If it is listed in Currently Supported Devices");

        CSD_heading.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CSD_heading.setText("Currently Supported Devices");

        CSD_note1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note1.setText("Note : If You Select your device from following list, you dont need to add update-binary file explicitly. ");

        CSD_note2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note2.setText("However if you still add update-binary file, added file will override existing update-binary file.");

        CSD_continue.setText("Continue!");
        CSD_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_continueActionPerformed(evt);
            }
        });

        CSD_cancel.setText("Cancel");
        CSD_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_cancelActionPerformed(evt);
            }
        });

        CSD_note3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CSD_note3.setText("More Devices Will Be Added Soon...");

        CSD_panel.add(CSD_cancel);
        CSD_panel.add(CSD_continue);

        javax.swing.GroupLayout CSD_panelLayout = new javax.swing.GroupLayout(CSD_panel);
        CSD_panel.setLayout(CSD_panelLayout);
        CSD_panelLayout.setHorizontalGroup(
            CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CSD_panelLayout.createSequentialGroup()
                .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(CSD_note2))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(CSD_title))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(CSD_note1))
                    .addGroup(CSD_panelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CSD_note3)
                            .addComponent(CSD_heading)))
                    .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(CSD_panelLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(CSDScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CSD_panelLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(CSD_continue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(CSD_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        CSD_panelLayout.setVerticalGroup(
            CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CSD_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(CSD_title)
                .addGap(18, 18, 18)
                .addComponent(CSD_note1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CSD_note2)
                .addGap(18, 18, 18)
                .addComponent(CSD_heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CSDScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CSD_note3)
                .addGap(39, 39, 39)
                .addGroup(CSD_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CSD_continue)
                    .addComponent(CSD_cancel))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pack();
        //setLocationRelativeTo(null);
        
        dialog.setContentPane(CSD_panel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
            frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        //dialog.setLocationRelativeTo(null);
    }
    
    public void deleteSystemApkUI(){
        frame = new JFrame();
        
        JDialog dialog = new JDialog(frame, "Delete System Apk", true);
        
        deleteSystemPanel = new JPanel();
        deleteApkName = new JTextField();
        lbl_deleteFileName = new JLabel();
        lbl_deleteSystemExtension = new JLabel();
        lbl_deleteSystemTitle = new JLabel();
        btnAddDeleteFile = new JButton();
        btnRemoveDeleteFile = new JButton();
        btnDoneDeleteFile = new JButton();
        btnResetDeleteFile = new JButton();
        deleteSystemScrollPane = new JScrollPane();
        deletefileModel = new DefaultListModel();
        try{
            this.deletefileModel.removeAllElements();
            for(String fileName : op.deleteApkList){
                System.out.println("File Added To List is : " + fileName);
                this.deletefileModel.addElement(fileName);
            }
        }catch(NullPointerException npe){
            System.out.println("Exception Caught while opening delete system apk UI");
        }
        deleteSystemFileList = new JList(deletefileModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteApkName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_deleteFileName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteFileName.setText("Enter File Name : ");

        lbl_deleteSystemExtension.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemExtension.setText(".apk");

        lbl_deleteSystemTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemTitle.setText("Enter Exact Name of apk file which you want to delete from system");

        btnAddDeleteFile.setText("Add");
        btnAddDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeleteFileActionPerformed(evt);
            }
        });

        btnRemoveDeleteFile.setText("Remove");
        btnRemoveDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDeleteFileActionPerformed(evt);
            }
        });

        btnDoneDeleteFile.setText("Done!");
        btnDoneDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneDeleteFileActionPerformed(evt);
            }
        });

        btnResetDeleteFile.setText("Reset");
        btnResetDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDeleteFileActionPerformed(evt);
            }
        });

        deleteSystemFileList.setFont(new java.awt.Font("Tahoma", 0, 14));
        deleteSystemFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                deleteSystemFileListValueChanged(evt);
            }
        });
        deleteSystemScrollPane.setViewportView(deleteSystemFileList);

        javax.swing.GroupLayout deleteSystemPanelLayout = new javax.swing.GroupLayout(deleteSystemPanel);
        deleteSystemPanel.setLayout(deleteSystemPanelLayout);
        deleteSystemPanelLayout.setHorizontalGroup(
            deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteSystemPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_deleteSystemTitle)
                    .addGroup(deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(deleteSystemPanelLayout.createSequentialGroup()
                            .addComponent(lbl_deleteFileName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_deleteSystemExtension))
                        .addGroup(deleteSystemPanelLayout.createSequentialGroup()
                            .addComponent(deleteSystemScrollPane)
                            .addGap(18, 18, 18)
                            .addGroup(deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        deleteSystemPanelLayout.setVerticalGroup(
            deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteSystemPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_deleteSystemTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_deleteFileName)
                    .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deleteSystemExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(deleteSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(deleteSystemPanelLayout.createSequentialGroup()
                        .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteSystemScrollPane))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(deleteSystemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(deleteSystemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
        
        dialog.setContentPane(deleteSystemPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    public void importZipUI(){
        frame = new JFrame();
        
        JDialog dialog = new JDialog(frame,"Import ZIP",true);
        
        ImportZip_panel = new JPanel();
        btnBrowseZip = new JButton();
        jScrollPane1 = new JScrollPane();
        lblProgress = new  JLabel();
        lblSelectZip = new JLabel();
        progressImportZip = new JProgressBar();
        textAreaImportZipLog = new JTextArea();
        textFieldSelectZip = new JTextField();
        
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
        
        dialog.setContentPane(ImportZip_panel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    public void createZipUI(){
        frame = new JFrame();
        
        JDialog dialog = new JDialog(frame,"Creating ZIP",true);
        
        CZ_Panel = new JPanel();
        CZ_headingPanel = new JPanel();
        lblCZHeading = new JLabel();
        jScrollPane1 = new JScrollPane();
        textAreaCZ = new JTextArea();
        progressCZ = new JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CZ_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblCZHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblCZHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblCZHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCZHeading.setText("Creating Flashable ZIP");

        javax.swing.GroupLayout CZ_headingPanelLayout = new javax.swing.GroupLayout(CZ_headingPanel);
        CZ_headingPanel.setLayout(CZ_headingPanelLayout);
        CZ_headingPanelLayout.setHorizontalGroup(
            CZ_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        CZ_headingPanelLayout.setVerticalGroup(
            CZ_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        textAreaCZ.setColumns(20);
        textAreaCZ.setRows(5);
        jScrollPane1.setViewportView(textAreaCZ);

        javax.swing.GroupLayout CZ_PanelLayout = new javax.swing.GroupLayout(CZ_Panel);
        CZ_Panel.setLayout(CZ_PanelLayout);
        CZ_PanelLayout.setHorizontalGroup(
            CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CZ_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CZ_PanelLayout.setVerticalGroup(
            CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CZ_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(CZ_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(CZ_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
        
        dialog.setContentPane(CZ_Panel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                CZwindowOpened(evt);
                
            }
        });
        dialog.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
//        CZtask = new createZipTask();
//        CZtask.execute();
    }
    
    private void CZwindowOpened(WindowEvent evt) {
        //op.removeEmptyGroup();
        CZtask = new CreateZip(this, this.op);   
        CZtask.execute();
    }
    
    public void btnBrowseZipActionPerformed(ActionEvent evt) {
        if(this.setExistingZipPath()){
            //setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            IZtask = new ImportZip(this, this.op);
            IZtask.execute();
        }else{
            setLog("Cancelled By User", textAreaImportZipLog);
        }
    }
    
    public boolean setExistingZipPath(){
        System.out.println("Load Flashable Zip Clicked..!!");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZip);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Existing Zip File Location : " + file.getAbsolutePath());
            if(file.isDirectory() || returnVal == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(this, "Invalid File Type..!!\n Try Again..!!");
                return false;
            }
            else{
                op.existingZipPath = file.getAbsolutePath(); 
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "File access cancelled by user.");
            return false;
        }
    }
    
    public void setLog(String message, JTextArea textArea){
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    //All event handling functions here..!!
    public void btnContinueActionPerformed(ActionEvent ae) {
        updateGroupList(this.lastSelected); 
    }                                                         

    public void btnCancelActionPerformed(ActionEvent ae) {
        System.out.println("Button clicked is : " + ae.getActionCommand());
        frame.dispose();
    }
    
    public void btnApkGroupActionPerformed(java.awt.event.ActionEvent evt) {                                               
        System.out.println("Add Apk Group Clicked.. " + evt.getActionCommand());
        
        removeHighlight(this.lastSelected);
        btnApkGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Apk Group");
        
        updateFileList();
        //addApkGroupUI();
    }                                              

    public void btnBootAnimGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("Add Boot Animation Group Clicked..");
        removeHighlight(this.lastSelected);
        btnBootAnimGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Boot Animations Group");
        
        updateFileList();
    }                                                   

    public void btnRingtonesGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        System.out.println("Add Ringtones Group Clicked..");
        removeHighlight(this.lastSelected);
        btnRingtonesGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Ringtones Group");
        
        updateFileList();
    }                                                    

    public void btnNotifGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        System.out.println("Add Notifications Group Clicked..");
        removeHighlight(this.lastSelected);
        btnNotifGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Notifications Group");
        
        updateFileList();
    }                                                

    public void btnKernelGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        System.out.println("Add Kernel Group Clicked..");
        removeHighlight(this.lastSelected);
        btnKernelGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Kernel Group");
        
        updateFileList();
    }                                                 

    public void btnDeleteSystemFilesGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        System.out.println("Add Delete System Files Group Clicked..");
        this.deleteSystemApkUI();
    }                                                            

    public void btnAdvancedGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("Add Advanced Group Clicked..");
        JOptionPane.showMessageDialog(this, "Currently Work In Progress..!!\nWill Be Available Soon..!!\nSuggestions to add features are welcomed..!! ");
//        removeHighlight(this.lastSelected);
//        btnDeleteSystemFilesGroup.setSelected(true);
//        this.lastSelected = evt.getActionCommand();
//        
//        refreshGroupList(this.lastSelected);
//        this.lblGroup.setText("Advanced Group");
//        
//        updateFileList();
    }                                                   

    public void btnLoadAromaFlashableZipActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        this.importZipUI();
    }                                                        

    public void btnSelectDeviceActionPerformed(java.awt.event.ActionEvent evt) {                                                
        System.out.println("Selected Devices Clicked..");
        supportedDevicesUI();
    }                                               

    public void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(this.lastSelected + " Clicked Add Group");
        //op.getJarFileName();
        displayAddGroupUI(lastSelected);
    }                                           

    public void btnRemoveGroupActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(this.lastSelected + " Clicked Remove Group");
        try{
            removeGroup(this.groupList.getSelectedValue().toString());
        }catch(NullPointerException npe){
            System.out.println("Exception Caught while Removing Group..!!");
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
        
    }                                              

    public void btnBrowseUpdateBinaryActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        System.out.println("Browse Update Binary Clicked..!!");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(btnBrowseUpdateBinary);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("update-binary File Location : " + file.getAbsolutePath());
            if(!file.getName().equals("update-binary")){
                JOptionPane.showMessageDialog(null, "Selected File May not be update-binary file..!!\nYou are using this file at your own risk..!");
            }
            textFieldUpdateBinary.setText(file.getAbsolutePath());
            op.updateBinaryPath = file.getAbsolutePath();
            op.selectedDevice = "";
        } else {
            System.out.println("File access cancelled by user.");
        }
    }                                                     

    public void btnBrowseZipDestinationActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        System.out.println("Browse Zip Destination Clicked..");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZipDestination);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Zip File Destination Location : " + file.getAbsolutePath());
            if(!file.getAbsolutePath().endsWith(".zip")){
                op.zipDestination = file.getAbsolutePath() + ".zip";
            }else{
                op.zipDestination = file.getAbsolutePath();
            }
            textFieldZipDestination.setText(op.zipDestination);
            op.tempFolderPath = file.getParent() + "\\temp$$folder";
            System.out.println("Temp Folder Path : " + op.tempFolderPath);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }                                                       

    public void btnAddFileActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.out.println("Add File Clicked");
        if(!groupList.isSelectionEmpty()){
            chooseFile(this.lastSelected);
        }
        else{
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Files!!");
        }
        
    }                                          

    public void btnRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {                                              
        System.out.println("Remove File Clicked..!!");
        //this.lastSelected = evt.getActionCommand();
        try{
            removeFile(this.fileList.getSelectedValue().toString());
        }catch(NullPointerException npe){
            JOptionPane.showMessageDialog(this, "Select File To Remove..!!");
        }
    }                                             

    public void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("Reset All Button Clicked..");
        resetAll();
        
    }                                           

    public void btnCreateNormalZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException { 
        
        System.out.println("normal Zip Action Performed..");
        if(this.checkIfEverythingIsOkay()){
            op.flashableZipType = evt.getActionCommand();
            //CZtask = new createZipTask();
            this.createZipUI();
            //JOptionPane.showMessageDialog(this, "Zip File Successfully Created..!! Enjoy..!!");
            File f = new File("Temp");
            if(f.isDirectory()&&f.exists())
                op.deleteDirectories("Temp");
        }
    }                                                  

    public void btnCreateAromaZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                                  
        System.out.println("Create Aroma Zip Clicked..");
        if(this.checkIfEverythingIsOkay()){
            op.flashableZipType = evt.getActionCommand();
            //op.removeEmptyGroup();
            //createZipAt(op.zipDestination);
            this.createZipUI();
            //JOptionPane.showMessageDialog(this, "Zip File Successfully Created..!! Enjoy..!!");
            File f = new File("Temp");
            if(f.isDirectory()&&f.exists())
                op.deleteDirectories("Temp");
        }
    }
    
    public void groupListSelection(ListSelectionEvent lse){
        System.out.println("Group List Clicked..");
        try{
            if (!lse.getValueIsAdjusting()) {
                updateFileList();
            }   
        }catch (NullPointerException npe){
            System.out.println("Exception Caught....");
            //aromaFileModel.removeAllElements();
        }
    }
    
    public void fileListSelection(ListSelectionEvent lse){
        System.out.println();
    }
    
    public void CSD_continueActionPerformed(ActionEvent ae){
        op.selectedDevice = this.CSDList.getSelectedValue().toString();
        System.out.println(op.selectedDevice);
        textFieldUpdateBinary.setText("update-binary of " + op.selectedDevice + " Imported Successfully..!");
        frame.dispose();
    }
    
    public void CSD_cancelActionPerformed(ActionEvent ae){
        frame.dispose();
    }
    
    public void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    private void btnAddDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        System.out.println("Add Delete File Button Clicked..!!");
        if(!deleteApkName.getText().equals("")){
            op.deleteApkList.add(deleteApkName.getText() + ".apk");
            deletefileModel.addElement(deleteApkName.getText() + ".apk");
            deleteApkName.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "Add File Name First..!!");
        }
    }                                                

    private void btnRemoveDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("Remove Delete File Button Clicked..!!");
        if(!deleteSystemFileList.isSelectionEmpty()){
            op.deleteApkList.remove(deleteSystemFileList.getSelectedValue());
            deletefileModel.removeElement(deleteSystemFileList.getSelectedValue());
        }
        else{
            JOptionPane.showMessageDialog(this, "Select File Name First..!!");
        }
    }                                                   

    private void btnDoneDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        System.out.println("Done Delete File Button Clicked..!!");
        frame.dispose();
    }                                                 

    private void btnResetDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        deletefileModel.removeAllElements();
        op.deleteApkList = new ArrayList<String>();
        deleteSystemFileList.removeAll();
        deleteApkName.setText("");
    }      
    
    private void deleteSystemFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {                                                  
        // TODO add your handling code here:
    }
    
    /**
     * Custom Functions Here..
     */
    
    public void removeFile(String fileName){
        if(!this.fileList.isSelectionEmpty()){
            //this.fileList.setSelectionModel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            switch(lastSelected){
                case "APKs Group":
                    if(op.map.containsKey("APKs-System_"+this.groupList.getSelectedValue().toString())){// && op.map.values().contains(fileName)){
                        op.map.removeMapping("APKs-System_"+this.groupList.getSelectedValue().toString(), op.getFilePath("APKs-System_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-System_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);                       
                    }else{
                        op.map.removeMapping("APKs-Data_"+this.groupList.getSelectedValue().toString(), op.getFilePath("APKs-Data_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-Data_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);                       
                    }
                    break;
                case "Boot Animation Group":
                    op.map.removeMapping("BootAnimations_"+this.groupList.getSelectedValue().toString(), op.getFilePath("BootAnimations_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("BootAnimations_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Ringtones Group":
                    op.map.removeMapping("Ringtones_"+this.groupList.getSelectedValue().toString(), op.getFilePath("Ringtones_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Ringtones_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Notifications Group":
                    op.map.removeMapping("Notifications_"+this.groupList.getSelectedValue().toString(), op.getFilePath("Notifications_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Notifications_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Kernel Group":
                    op.map.removeMapping("Kernel_"+this.groupList.getSelectedValue().toString(), op.getFilePath("Kernel_"+this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Kernel_"+this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Advanced Group":
                    op.map.removeMapping(this.groupList.getSelectedValue().toString(), op.getFilePath(this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList(this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Delete System Files Group":
                    op.map.removeMapping(this.groupList.getSelectedValue().toString(), op.getFilePath(this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList(this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
    }
    
    public void resetAll(){
        op.lastActionCommand = "";
        op.updateBinaryPath = "";
        op.zipDestination = "";
        op.tempFolderPath = "";
        op.selectedDevice = "";
        op.aroma_config = "";
        op.updater_script = "";
        op.flashableZipType = "";
        op.jarFileName = "";

        op.groupArrayList = new ArrayList<>();
        op.systemList = new ArrayList<>();
        op.dataList = new ArrayList<>();
        op.bootAnimList = new ArrayList<>();
        op.ringtoneList = new ArrayList<>();
        op.notifList = new ArrayList<>();
        op.kernelList = new ArrayList<>();
        op.advancedList = new ArrayList<>();
        op.deleteApkList = new ArrayList<>();
        op.arrayList = new ArrayList<>();
        op.jarFileList = new ArrayList<>();

        op.map = new MultiValueMap();
        
        removeHighlight(this.lastSelected);
        
        this.lastSelected = "APKs Group";
        this.btnApkGroup.setSelected(true);
        
        this.refreshGroupList(this.lastSelected);
        
        this.textFieldUpdateBinary.setText("Click Here To Select updater-binary....");
        this.textFieldZipDestination.setText("Click Here To Select Zip Destination....");
    }
    
    public void removeGroup(String groupName){
        System.out.println(this.lastSelected + " is last selected");
        System.out.println("Map Before : " + op.map);
        System.out.println("Group List Contains : " + op.groupArrayList);
        if(!this.groupList.isSelectionEmpty()){
            switch(this.lastSelected){
                case "APKs Group":
                    if(op.systemList.contains("APKs-System_"+groupName)){
                        op.systemList.remove("APKs-System_"+groupName);
                        op.groupArrayList.remove("APKs-System_"+groupName);
                        op.map.remove("APKs-System_"+groupName);
                    }
                    if(op.dataList.contains("APKs-Data_"+groupName)){
                        op.dataList.remove("APKs-Data_"+groupName);
                        op.groupArrayList.remove("APKs-Data_"+groupName);
                        op.map.remove("APKs-Data_"+groupName);
                    }
                    break;
                case "Boot Animation Group":
                    op.bootAnimList.remove("BootAnimations_"+groupName);
                    op.groupArrayList.remove("BootAnimations_"+groupName);
                    op.map.remove("BootAnimations_"+groupName);
                    break;
                case "Ringtones Group":
                    op.ringtoneList.remove("Ringtones_"+groupName);
                    op.groupArrayList.remove("Ringtones_"+groupName);
                    op.map.remove("Ringtones_"+groupName);
                    break;
                case "Notifications Group":
                    op.notifList.remove("Notifications_"+groupName);
                    op.groupArrayList.remove("Notifications_"+groupName);
                    op.map.remove("Notifications_"+groupName);
                    break;
                case "Kernel Group":
                    op.kernelList.remove("Kernel_"+groupName);
                    op.groupArrayList.remove("Kernel_"+groupName);
                    op.map.remove("Kernel_"+groupName);
                    break;
                case "Advanced Group":
                    op.advancedList.remove(groupName);
                    op.map.remove(groupName);
                    break;
                case "Delete System Files Group":
                    op.deleteApkList.remove(groupName);
                    op.map.remove(groupName);
                default:
                System.out.println("Something Went Wrong..!!");
            }
            //op.groupArrayList.remove(groupName);
            refreshGroupList(this.lastSelected);
            System.out.println("Map After : " + op.map);
            System.out.println("Group List Contains : " + op.groupArrayList);
        }
        else{
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
    }
    
    public boolean checkIfEverythingIsOkay(){
        if(op.selectedDevice.equals("")&&this.textFieldUpdateBinary.getText().equals("Click Here To Select updater-binary....")){
            JOptionPane.showMessageDialog(this, "update-binary not imported..!!");
            return false;
        }
        else if(op.zipDestination.equals("")){
            JOptionPane.showMessageDialog(this, "You Forgot to enter destination path of Zip file..!!");
            return false;
        }
        else if(op.groupArrayList.isEmpty()){
            JOptionPane.showMessageDialog(this, "Zip cannot be created without group..\nFirst create one..!!");
            return false;
        }
        else if(op.map.isEmpty()){
            JOptionPane.showMessageDialog(this, "Add Files to group..\nWithout files, nothing can be done with Zip file..!!");
            return false;
        }
        return true;
    }
    
    public void updateFileList(){
        try{
            switch(lastSelected){
                case "APKs Group":
                    if(op.groupArrayList.contains("APKs-System_"+this.groupList.getSelectedValue().toString()) && op.groupArrayList.contains("APKs-Data_"+this.groupList.getSelectedValue().toString())){
                        //BIG FAULT HERE......NO SOLUTION AVAILABLE
                        break;
                    }
                    if(op.map.containsKey("APKs-System_"+this.groupList.getSelectedValue().toString()) || op.groupArrayList.contains("APKs-System_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-System_"+groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    }
                    else if(op.map.containsKey("APKs-Data_"+this.groupList.getSelectedValue().toString()) || op.groupArrayList.contains("APKs-Data_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-Data_"+groupList.getSelectedValue().toString(), this.fileModel, op.map); 
                    }
                    break;
                case "Boot Animation Group":
                    if(op.map.containsKey("BootAnimations_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("BootAnimations_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Ringtones Group":
                    if(op.map.containsKey("Ringtones_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Ringtones_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Notifications Group":
                    if(op.map.containsKey("Notifications_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Notifications_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Kernel Group":
                    if(op.map.containsKey("Kernel_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Kernel_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Advanced Group":
                    if(op.map.containsKey("Advanced_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Advanced_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Delete System Files Group":
                    if(op.map.containsKey("DeleteApk_"+this.groupList.getSelectedValue().toString())){
                        System.out.println("Working!!" );
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("DeleteApk_"+groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                default:
                    System.out.println("in Default....");
                    fileModel.removeAllElements();
                    System.out.println("Not Working!!");
            }
        }catch(NullPointerException npe){
            System.out.println("Exception Caught in updateFileList");
            //npe.printStackTrace();
            fileModel.removeAllElements();
        }
    }
    
    public void chooseFile(String lastSelected){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        //FileFilter filter = new FileNameExtensionFilter("." + extension, extension);
        FileFilter filter;
        
        switch(lastSelected){
            case "APKs Group":
                filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(filter);
                if(op.groupArrayList.contains("APKs-System_"+groupList.getSelectedValue().toString())){
                    op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "APKs-System");
                    System.out.println("Map contains : " + op.map);
                }else{
                    op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "APKs-Data");
                    System.out.println("Map contains : " + op.map);
                }
                break;
            case "Boot Animation Group":
                filter = new FileNameExtensionFilter(".zip", "zip");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "BootAnimations");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Ringtones Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Ringtones");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Notifications Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Notifications");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Kernel Group":
                filter = new FileNameExtensionFilter(".img", "img");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Kernel");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Advanced Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                //this.filterFile(fileChooser, "zip", aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, op.map);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Delete System Files Group":
                    default:
                    System.out.println("Something Went Wrong..!!");
        }
    }
    
    public void updateGroupList(String lastSelected){
        if(!this.groupName.getText().equals("") && !this.groupName.getText().contains("_")){
                switch(lastSelected){
                    case "APKs Group":
                        if(op.groupArrayList.contains("APKs-System_"+this.groupName.getText()) || op.groupArrayList.contains("APKs-Data_"+this.groupName.getText())){
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }
                        else if(this.buttonGroup.getSelection().getActionCommand().equals("Add System Apk Group")){ //&& !op.groupArrayList.contains("APKs-System_"+this.groupName.getText())
                            op.groupArrayList.add("APKs-System_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.systemList.add("APKs-System_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break;
                        }
                        else if(!this.buttonGroup.getSelection().getActionCommand().equals("Add System Apk Group") ){//&& !op.groupArrayList.contains("APKs-Data_"+this.groupName.getText())){
                            op.groupArrayList.add("APKs-Data_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.dataList.add("APKs-Data_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }
                    case "Boot Animation Group":
                        if(!op.groupArrayList.contains("BootAnimations_"+this.groupName.getText())){
                            op.groupArrayList.add("BootAnimations_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.bootAnimList.add("BootAnimations_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }
                        
                    case "Ringtones Group":
                        if(!op.groupArrayList.contains("Ringtones_"+this.groupName.getText())){
                            op.groupArrayList.add("Ringtones_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.ringtoneList.add("Ringtones_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break; 
                        }else{
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }
                    case "Notifications Group":
                        if(!op.groupArrayList.contains("Notifications_"+this.groupName.getText())){
                            op.groupArrayList.add("Notifications_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.notifList.add("Notifications_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }   
                    case "Kernel Group":
                        if(!op.groupArrayList.contains("Kernel_"+this.groupName.getText())){
                            op.groupArrayList.add("Kernel_"+this.groupName.getText());
                            System.out.println(op.groupArrayList.toString());
                            op.kernelList.add("Kernel_"+this.groupName.getText());
                            groupModel.addElement(this.groupName.getText());
                            groupList.setSelectedIndex(groupModel.getSize()-1);
                            frame.dispose();
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                            break;
                        }
                    case "Advanced Group":
                        op.advancedList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        frame.dispose();
                        break;
                    case "Delete System Files Group":
                        op.deleteApkList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        frame.dispose();
                        default:
                        System.out.println("Something Went Wrong..!!");
                }
        }else{
            if(this.groupName.getText().contains("_")){
                JOptionPane.showMessageDialog(null, "You Cannot Have Underscore(_) in Group Name..!!");
            }else{
                JOptionPane.showMessageDialog(null, "You Cannot Continue Without Setting Group Name..!!");
            } 
        }
    }
    
    public void refreshGroupList(String lastSelected){
        try{
            System.out.println("Group model empty is : " + groupModel.isEmpty());
                this.groupModel.removeAllElements();
                System.out.println("Group model empty is : " + groupModel.isEmpty());
                switch(lastSelected){
                    case "APKs Group":
                        if(!op.systemList.isEmpty()){
                            op.fillListModelWithArrayList(groupModel, op.systemList, "APKs-System");
                        }
                        if(!op.dataList.isEmpty()){
                            op.fillListModelWithArrayList(groupModel, op.dataList, "APKs-Data");
                        }
                        groupList.setSelectedIndex(0);
                        //System.out.println("Button Group is : " + this.buttonGroup.getSelection().getActionCommand());
                        break;
                    case "Boot Animation Group":
                        op.fillListModelWithArrayList(groupModel, op.bootAnimList, "BootAnimations");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.bootAnimList);
                        break;
                    case "Ringtones Group":
                        op.fillListModelWithArrayList(groupModel, op.ringtoneList, "Ringtones");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.ringtoneList);
                        break;
                    case "Notifications Group":
                        op.fillListModelWithArrayList(groupModel, op.notifList, "Notifications");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Kernel Group":
                        op.fillListModelWithArrayList(groupModel, op.kernelList, "Kernel");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Advanced Group":
                        op.fillListModelWithArrayList(groupModel, op.advancedList, "Advanced");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Delete System Files Group":
                        op.fillListModelWithArrayList(groupModel, op.deleteApkList, "DeleteSystemApk");
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
//                        op.deleteApkList.add(this.groupName.getText());
//                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        default:
                        System.out.println("Something Went Wrong..!!");
                }
                

                //This will close/dispose current dialogbox..
                //frame.dispose();
            
        }catch(NullPointerException npe){
            System.out.println("Exception caught in refreshGroupList");
            npe.printStackTrace();
        }   
    }
    
    public void displayAddGroupUI(String lastSelected){
        switch(lastSelected){
            case "APKs Group" :
                addApkGroupUI();
                break;
            case "Boot Animation Group":
                addGroupUI();
                break;
            case "Ringtones Group":
                addGroupUI();
                break;
            case "Notifications Group":
                addGroupUI();
                break;
            case "Kernel Group":
                addGroupUI();
                break;
            case "Advanced Group":
                btnAdvancedGroup.setSelected(false);
                break;
            case "Delete System Files Group":
                btnDeleteSystemFilesGroup.setSelected(false);
                default:
                System.out.println("Something Went Wrong..!!");
        }
    }
    
    public void removeHighlight(String lastSelected){
        switch(lastSelected){
            case "APKs Group" :
                btnApkGroup.setSelected(false);
                break;
            case "Boot Animation Group":
                btnBootAnimGroup.setSelected(false);
                break;
            case "Ringtones Group":
                btnRingtonesGroup.setSelected(false);
                break;
            case "Notifications Group":
                btnNotifGroup.setSelected(false);
                break;
            case "Kernel Group":
                btnKernelGroup.setSelected(false);
                break;
            case "Advanced Group":
                //btnAdvancedGroup.setSelected(false);
                break;
            case "Delete System Files Group":
                btnDeleteSystemFilesGroup.setSelected(false);
                default:
                System.out.println("Something Went Wrong..!!");
        }
        
    }
    
    public void updateUIwithZIPdata() throws IOException{
        MultiValueMap mvm  = op.extractTheZip(op.existingZipPath);
        //op.getArrayListFromZip(op.existingZipPath);
        System.out.println("Map Before : "+op.map);
        groupModel.clear();
        op.map.putAll(mvm);       
        op.groupArrayList.addAll(op.getGroupListFromMVM(mvm));
        System.out.println("Updated GroupList : "+op.groupArrayList);
        System.out.println("Updated Map : "+op.map);
        for(String element:op.groupArrayList){
            String[] temp = element.split("_");
            switch(temp[0]){
                case "APKs-System":
                    op.systemList.add(element);
                    break;
                case "APKs-Data":
                    op.dataList.add(element);
                    break;
                case "BootAnimations":
                    op.bootAnimList.add(element);
                    break;
                case "Ringtones":
                    op.ringtoneList.add(element);
                    break;
                case "Notifications":
                    op.notifList.add(element);
                    break;
            }
        }
        this.refreshGroupList("APKs Group");
        //this.refreshGroupList(this.lastSelected);
        //op.updateFileListWithSelectedGroupList(this.lastSelected, fileModel, mvm);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AromaInstaller().setVisible(true);
            }
        });
    }
    
    //Declarations here...
    
    Operations op = new Operations();
    
    String lastSelected = "APKs Group";
    
    public JPanel CZ_Panel;
    public JPanel CZ_headingPanel;
    public JScrollPane jScrollPane1;
    public JLabel lblCZHeading;
    public JProgressBar progressCZ;
    public JTextArea textAreaCZ;
    
    public JPanel ImportZip_panel;
    public JButton btnBrowseZip;
    public JScrollPane scrollPaneIZ;
    public JLabel lblProgress;
    public JLabel lblSelectZip;
    public JProgressBar progressImportZip;
    public JTextArea textAreaImportZipLog;
    public JTextField textFieldSelectZip;
    
    public JList CSDList;
    public JScrollPane CSDScrollPanel;
    public JButton CSD_cancel;
    public JButton CSD_continue;
    public JLabel CSD_heading;
    public JLabel CSD_note1;
    public JLabel CSD_note2;
    public JLabel CSD_note3;
    public JPanel CSD_panel;
    public JLabel CSD_title;
    
    public DefaultListModel groupModel;
    public DefaultListModel fileModel;
    public DefaultListModel deletefileModel;
    
    public JFrame frame;
    ButtonGroup buttonGroup;
    public JRadioButton addApkGroupRadData;
    public JRadioButton addApkGroupRadSystem;
    public JTextField groupName;
    public JLabel addGroupTitle;
    public JLabel addGroupNameTitle;
    public JPanel addGroupPanel;
    public JMenuItem aboutMenuItem;
    
    private javax.swing.JButton btnAddDeleteFile;
    private javax.swing.JButton btnDoneDeleteFile;
    private javax.swing.JButton btnRemoveDeleteFile;
    private javax.swing.JButton btnResetDeleteFile;
    private javax.swing.JTextField deleteApkName;
    private javax.swing.JList deleteSystemFileList;
    private javax.swing.JPanel deleteSystemPanel;
    private javax.swing.JScrollPane deleteSystemScrollPane;
    private javax.swing.JLabel lbl_deleteFileName;
    private javax.swing.JLabel lbl_deleteSystemExtension;
    private javax.swing.JLabel lbl_deleteSystemTitle;
    
    public JButton btnSupportedDevices;
    public JButton btnCancel;
    public JButton btnContinue;
    public JButton btnAdvancedGroup;
    public JButton btnApkGroup;
    public JButton btnBootAnimGroup;
    public JButton btnDeleteSystemFilesGroup;
    public JButton btnAddFile;
    public JButton btnAddGroup;
    public JButton btnKernelGroup;
    public JButton btnNotifGroup;
    public JButton btnRingtonesGroup;
    public JButton btnBrowseUpdateBinary;
    public JButton btnBrowseZipDestination;
    public JButton btnCreateAromaZip;
    public JButton btnCreateNormalZip;
    public JButton btnLoadAromaFlashableZip;
    public JButton btnRemoveFile;
    public JButton btnRemoveGroup;
    public JButton btnResetAll;
    public JButton btnSelectDevice;
    public JPanel contentPanel;
    public JMenuItem contentsMenuItem;
    public JMenuItem copyMenuItem;
    public JMenuItem cutMenuItem;
    public JMenuItem deleteMenuItem;
    public JMenu editMenu;
    public JMenuItem exitMenuItem;
    public JList fileList;
    public JScrollPane fileListScrollPane;
    public JMenu fileMenu;
    public JList groupList;
    public JScrollPane groupListScrollPane;
    public JPanel headingPanel;
    public JMenu helpMenu;
    public JMenu jMenu1;
    public JMenu jMenu2;
    public JMenuBar jMenuBar1;
    public JLabel lblGroup;
    public JLabel lblHeading;
    public JLabel lblNote;
    public JLabel lblSubHeading;
    public JLabel lblTitle;
    public JLabel lblZipDestination;
    public JMenuBar menuBar;
    public JMenuItem openMenuItem;
    public JMenuItem pasteMenuItem;
    public JMenuItem saveAsMenuItem;
    public JMenuItem saveMenuItem;
    public JTextField textFieldUpdateBinary;
    public JTextField textFieldZipDestination;
}
