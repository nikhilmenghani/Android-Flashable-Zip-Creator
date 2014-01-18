/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author Nikhil
 * @author Rajat
 */
public class AromaInstaller extends javax.swing.JFrame{
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
        
        JPanel CSD_panel = new JPanel();
       
        JLabel CSD_heading = new JLabel();
        JLabel CSD_title = new JLabel();
        JLabel CSD_note1 = new JLabel();
        JLabel CSD_note2 = new JLabel();
        JLabel CSD_note3 = new JLabel();
        
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
    
    //All event handling functions here..!!
    public void btnContinueActionPerformed(ActionEvent ae) {
        updateGroupList(this.lastSelected);
        
    }                                                         

    public void btnCancelActionPerformed(ActionEvent ae) {
        System.out.println("Button clicked is : " + ae.getActionCommand());
        frame.dispose();
    }
    
    public void btnApkGroupActionPerformed(java.awt.event.ActionEvent evt) {                                               
        System.out.println("Add Apk Group Clicked.." + evt.getActionCommand());
        
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
        removeHighlight(this.lastSelected);
        btnDeleteSystemFilesGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Delete System Files Group");
        
        updateFileList();
    }                                                            

    public void btnAdvancedGroupActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("Add Advanced Group Clicked..");
        removeHighlight(this.lastSelected);
        btnDeleteSystemFilesGroup.setSelected(true);
        this.lastSelected = evt.getActionCommand();
        
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Advanced Group");
        
        updateFileList();
    }                                                   

    public void btnLoadAromaFlashableZipActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        System.out.println();
    }                                                        

    public void btnSelectDeviceActionPerformed(java.awt.event.ActionEvent evt) {                                                
        System.out.println("Selected Devices Clicked..");
        supportedDevicesUI();
    }                                               

    public void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(this.lastSelected + " Clicked Add Group");
        displayAddGroupUI(lastSelected);
    }                                           

    public void btnRemoveGroupActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(this.lastSelected + " Clicked Remove Group");
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
        System.out.println();
    }                                             

    public void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println();
    }                                           

    public void btnCreateNormalZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                                   
        System.out.println("normal Zip Action Performed..");
    }                                                  

    public void btnCreateAromaZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                                  
        System.out.println("Create Aroma Zip Clicked..");
        if(this.checkIfEverythingIsOkay()){
            op.createZipAt(op.zipDestination);
        }
        JOptionPane.showMessageDialog(this, "Zip File Successfully Created..!! Enjoy..!!");
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

    /**
     * Custom Functions Here..
     */
    
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
            if(op.keyExistInMap(this.groupList.getSelectedValue().toString(), op.map)){
            System.out.println("Working!!" );
            fileModel.removeAllElements();
            op.updateFileListWithSelectedGroupList(groupList.getSelectedValue().toString(), fileModel, op.map);
        }
        else{
            fileModel.removeAllElements();
            System.out.println("Not Working!!");
        }
        }catch(NullPointerException npe){
            System.out.println("Exception Caught in updateFileList");
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
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel);
                System.out.println("Map contains : " + op.map);
                break;
            case "Boot Animation Group":
                filter = new FileNameExtensionFilter(".zip", "zip");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Ringtones Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Notifications Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Kernel Group":
                filter = new FileNameExtensionFilter(".img", "img");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Advanced Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                //this.filterFile(fileChooser, "zip", aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, op.map);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Delete System Files Group":
                    Default:
                    System.out.println("Something Went Wrong..!!");
        }
    }
    
    public void updateGroupList(String lastSelected){
        if(!this.groupName.getText().equals("")){
            if(!op.groupArrayList.contains(this.groupName)){
                op.groupArrayList.add(this.groupName.getText());
                switch(lastSelected){
                    case "APKs Group":
                        if(this.buttonGroup.getSelection().getActionCommand().equals("Add System Apk Group")){
                            op.systemList.add(this.groupName.getText());
                        }
                        else{
                            op.dataList.add(this.groupName.getText());
                        }
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Boot Animation Group":
                        op.bootAnimList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Ringtones Group":
                        op.ringtoneList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Notifications Group":
                        op.notifList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Kernel Group":
                        op.kernelList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Advanced Group":
                        op.advancedList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
                        break;
                    case "Delete System Files Group":
                        op.deleteApkList.add(this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize()-1);
//                        op.deleteApkList.add(this.groupName.getText());
//                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        Default:
                        System.out.println("Something Went Wrong..!!");
                }
                

            //This will close/dispose current dialogbox..
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "You Cannot Continue Without Setting Group Name..!!");
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
                            op.fillListModelWithArrayList(groupModel, op.systemList);
                        }
                        if(!op.dataList.isEmpty()){
                            op.fillListModelWithArrayList(groupModel, op.dataList);
                        }
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group is : " + this.buttonGroup.getSelection().getActionCommand());
                        break;
                    case "Boot Animation Group":
                        op.fillListModelWithArrayList(groupModel, op.bootAnimList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.bootAnimList);
                        break;
                    case "Ringtones Group":
                        op.fillListModelWithArrayList(groupModel, op.ringtoneList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.ringtoneList);
                        break;
                    case "Notifications Group":
                        op.fillListModelWithArrayList(groupModel, op.notifList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Kernel Group":
                        op.fillListModelWithArrayList(groupModel, op.kernelList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Advanced Group":
                        op.fillListModelWithArrayList(groupModel, op.advancedList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        break;
                    case "Delete System Files Group":
                        op.fillListModelWithArrayList(groupModel, op.deleteApkList);
                        groupList.setSelectedIndex(0);
                        System.out.println("Button Group Added in : " + op.lastActionCommand);
//                        op.deleteApkList.add(this.groupName.getText());
//                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                        Default:
                        System.out.println("Something Went Wrong..!!");
                }
                

                //This will close/dispose current dialogbox..
                frame.dispose();
            
        }catch(NullPointerException npe){
            System.out.println("Exception caught in refreshGroupList");
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
                Default:
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
                btnAdvancedGroup.setSelected(false);
                break;
            case "Delete System Files Group":
                btnDeleteSystemFilesGroup.setSelected(false);
                Default:
                System.out.println("Something Went Wrong..!!");
        }
        
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
    public JFrame frame;
    ButtonGroup buttonGroup;
    public JRadioButton addApkGroupRadData;
    public JRadioButton addApkGroupRadSystem;
    public JTextField groupName;
    public JLabel addGroupTitle;
    public JLabel addGroupNameTitle;
    public JPanel addGroupPanel;
    public JMenuItem aboutMenuItem;
    
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
