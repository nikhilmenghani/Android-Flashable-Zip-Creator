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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Nikhil
 */
public class AromaInstallerTemp extends javax.swing.JFrame{
    
    AromaInstallerTemp(){
        this.CSDArrayList = new ArrayList<>();
        CSDArrayList.add("Samsung Galaxy R(i9103)");
        CSDArrayList.add("Samsung Galaxy Nexus");
        CSDArrayList.add("Samsung Galaxy Note II(N7100)");
        initComponents();
    }
    public void initComponents(){
        
        aroma_addApkGroup = new JButton();
        aroma_addApkGroup.setActionCommand("Aroma Add Apk Group");
        aroma_addApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addApkGroupActionPerformed(evt);
            }
        });
        
        aroma_listApkGroup = new JButton();
        aroma_listApkGroup.setActionCommand("Aroma List Apk Group");
        aroma_listApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listApkGroupActionPerformed(evt);
            }
        });
        
        aroma_addApkFiles = new JButton();
        aroma_addApkFiles.setActionCommand("Aroma Add Apk Files");
        aroma_addApkFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addApkFilesActionPerformed(evt);
            }
        });
        
        aroma_removeApkFiles = new JButton();
        aroma_removeApkFiles.setActionCommand("Aroma Remove Apk Files");
        aroma_removeApkFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeApkFilesActionPerformed(evt);
            }
        });
        
        aroma_lbl_addGroup = new JLabel();
        aroma_addBootAnimGroup = new JButton();
        aroma_addBootAnimGroup.setActionCommand("Aroma Add BootAnim Group");
        aroma_addBootAnimGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addBootAnimGroupActionPerformed(evt);
            }
        });
        
        aroma_listBootAnimGroup = new JButton();
        aroma_listBootAnimGroup.setActionCommand("Aroma List BootAnim Group");
        aroma_listBootAnimGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listBootAnimGroupActionPerformed(evt);
            }
        });
        
        aroma_removeBootAnimFiles = new JButton();
        aroma_removeBootAnimFiles.setActionCommand("Aroma Remove BootAnim Files");
        aroma_removeBootAnimFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeBootAnimFilesActionPerformed(evt);
            }
        });
        
        aroma_addBootAnimFiles = new JButton();
        aroma_addBootAnimFiles.setActionCommand("Aroma Add BootAnim Files");
        aroma_addBootAnimFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addBootAnimFilesActionPerformed(evt);
            }
        });
        
        aroma_addRingtoneGroup = new JButton();
        aroma_addRingtoneGroup.setActionCommand("Aroma Add Ringtone Group");
        aroma_addRingtoneGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addRingtoneGroupActionPerformed(evt);
            }
        });
        
        aroma_addNotifGroup = new JButton();
        aroma_addNotifGroup.setActionCommand("Aroma Add Notif Group");
        aroma_addNotifGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addNotifGroupActionPerformed(evt);
            }
        });
        
        aroma_addkernelGroup = new JButton();
        aroma_addkernelGroup.setActionCommand("Aroma Add Kernel Group");
        aroma_addkernelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addkernelGroupActionPerformed(evt);
            }
        });
        
        aroma_addDeleteApkGroup = new JButton();
        aroma_addDeleteApkGroup.setActionCommand("Aroma Add Delete Apk Group");
        aroma_addDeleteApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addDeleteApkGroupActionPerformed(evt);
            }
        });
        
        aroma_addOtherFilesGroup = new JButton();
        aroma_addOtherFilesGroup.setActionCommand("Aroma Add Other Files Group");
        aroma_addOtherFilesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addOtherFilesGroupActionPerformed(evt);
            }
        });
        
        aroma_listRingtoneGroup = new JButton();
        aroma_listRingtoneGroup.setActionCommand("Aroma List Ringtone Group");
        aroma_listRingtoneGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listRingtoneGroupActionPerformed(evt);
            }
        });
        
        aroma_listNotifGroup = new JButton();
        aroma_listNotifGroup.setActionCommand("Aroma List Notif Group");
        aroma_listNotifGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listNotifGroupActionPerformed(evt);
            }
        });
        
        aroma_listKernelGroup = new JButton();
        aroma_listKernelGroup.setActionCommand("Aroma list Kernel Group");
        aroma_listKernelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listKernelGroupActionPerformed(evt);
            }
        });
        
        aroma_listDeleteApkGroup = new JButton();
        aroma_listDeleteApkGroup.setActionCommand("Aroma List Delete Apk");
        aroma_listDeleteApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listDeleteApkGroupActionPerformed(evt);
            }
        });
        
        aroma_listOtherFilesGroup = new JButton();
        aroma_listOtherFilesGroup.setActionCommand("Aroma List Other Files Group");
        aroma_listOtherFilesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listOtherFilesGroupActionPerformed(evt);
            }
        });
        
        aroma_removeRingtoneFiles = new JButton();
        aroma_removeRingtoneFiles.setActionCommand("Aroma Remove Ringtone Files");
        aroma_removeRingtoneFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeRingtoneFilesActionPerformed(evt);
            }
        });
        
        aroma_removeNotifFiles = new JButton();
        aroma_removeNotifFiles.setActionCommand("Aroma Remove Notif Files");
        aroma_removeNotifFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeNotifFilesActionPerformed(evt);
            }
        });
        
        aroma_removeKernelFiles = new JButton();
        aroma_removeKernelFiles.setActionCommand("Aroma Remove Kernel Files");
        aroma_removeKernelFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeKernelFilesActionPerformed(evt);
            }
        });
        
        aroma_removeApksToDelete = new JButton();
        aroma_removeApksToDelete.setActionCommand("Aroma Remove Apks To Delete");
        aroma_removeApksToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeApksToDeleteActionPerformed(evt);
            }
        });
        aroma_removeOtherFiles = new JButton();
        aroma_removeOtherFiles.setActionCommand("Aroma Remove Other Files");
        aroma_removeOtherFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeOtherFilesActionPerformed(evt);
            }
        });
        
        aroma_addRingtoneFiles = new JButton();
        aroma_addRingtoneFiles.setActionCommand("Aroma Add Ringtone Files");
        aroma_addRingtoneFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addRingtoneFilesActionPerformed(evt);
            }
        });
        
        aroma_addNotifFiles = new JButton();
        aroma_addNotifFiles.setActionCommand("Aroma Add Notif Files");
        aroma_addNotifFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addNotifFilesActionPerformed(evt);
            }
        });
        
        aroma_addKernelFiles = new JButton();
        aroma_addKernelFiles.setActionCommand("Aroma Add Kernel Files");
        aroma_addKernelFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addKernelFilesActionPerformed(evt);
            }
        });
        
        aroma_addApksToDelete = new JButton();
        aroma_addApksToDelete.setActionCommand("Aroma Add Apks To Delete");
        aroma_addApksToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addApksToDeleteActionPerformed(evt);
            }
        });
        
        aroma_addOtherFiles = new JButton();
        aroma_addOtherFiles.setActionCommand("Aroma Add Other Files");
        aroma_addOtherFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addOtherFilesActionPerformed(evt);
            }
        });
        
        aroma_load = new JButton();
        aroma_load.setActionCommand("Aroma Load");
        aroma_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_loadActionPerformed(evt);
            }
        });
        
        aroma_listAllGroups = new JButton();
        aroma_listAllGroups.setActionCommand("Aroma List All Groups");
        aroma_listAllGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listAllGroupsActionPerformed(evt);
            }
        });
        
        aroma_listAllFiles = new JButton();
        aroma_listAllFiles.setActionCommand("Aroma List All Files");
        aroma_listAllFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_listAllFilesActionPerformed(evt);
            }
        });
        
        aroma_remove = new JButton();
        aroma_remove.setActionCommand("Aroma Remove");
        aroma_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeActionPerformed(evt);
            }
        });
        
        aroma_removeGroup = new JButton();
        aroma_removeGroup.setActionCommand("Aroma List All Files");
        aroma_removeGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_removeGroupActionPerformed(evt);
            }
        });
        
        
        
        normal_addSystemApps = new JButton();
        normal_addSystemApps.setActionCommand("Normal Add System Apps");
        normal_addSystemApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addSystemAppsActionPerformed(evt);
            }
        });
        
        normal_addDataApps = new JButton();
        normal_addDataApps.setActionCommand("Normal Add Data Apps");
        normal_addDataApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addDataAppsActionPerformed(evt);
            }
        });
        
        normal_addRingtones = new JButton();
        normal_addRingtones.setActionCommand("Normal Add Ringtones");
        normal_addRingtones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addRingtonesActionPerformed(evt);
            }
        });
        
        normal_addNotifTones = new JButton();
        normal_addNotifTones.setActionCommand("Normal Add Notif Tones");
        normal_addNotifTones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addNotifTonesActionPerformed(evt);
            }
        });
        
        normal_removeSystemApps = new JButton();
        normal_removeSystemApps.setActionCommand("Normal Remove System Apps");
        normal_removeSystemApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeSystemAppsActionPerformed(evt);
            }
        });
        
        normal_browseKernel = new JButton();
        normal_browseKernel.setActionCommand("Normal Browse Kernel");
        normal_browseKernel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_browseKernelActionPerformed(evt);
            }
        });
        
        normal_browseBootAnim = new JButton();
        normal_browseBootAnim.setActionCommand("Normal Browse Boot Anim");
        normal_browseBootAnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_browseBootAnimActionPerformed(evt);
            }
        });
        
        normal_lbl_clickToRemove = new JLabel();
        
        normal_removeDataApps = new JButton();
        normal_removeDataApps.setActionCommand("Normal Remove Data Apps");
        normal_removeDataApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeDataAppsActionPerformed(evt);
            }
        });
        
        normal_removeRingtones = new JButton();
        normal_removeRingtones.setActionCommand("Normal Remove Ringtones");
        normal_removeRingtones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeRingtonesActionPerformed(evt);
            }
        });
        
        normal_removeNotifTones = new JButton();
        normal_removeNotifTones.setActionCommand("Normal Remove Notif Tones");
        normal_removeNotifTones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeNotifTonesActionPerformed(evt);
            }
        });
        
        normal_addOtherFiles = new JButton();
        normal_addOtherFiles.setActionCommand("Normal Add Other Files");
        normal_addOtherFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addOtherFilesActionPerformed(evt);
            }
        });
        
        normal_removeOtherFiles = new JButton();
        normal_removeOtherFiles.setActionCommand("Normal Remove Other Files");
        normal_removeOtherFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeOtherFilesActionPerformed(evt);
            }
        });
        
        normal_listSystemApps = new JButton();
        normal_listSystemApps.setActionCommand("Normal List System Apps");
        normal_listSystemApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listSystemAppsActionPerformed(evt);
            }
        });
        
        normal_listDataApps = new JButton();
        normal_listDataApps.setActionCommand("Normal List Data Apps");
        normal_listDataApps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listDataAppsActionPerformed(evt);
            }
        });
        
        normal_listRingtones = new JButton();
        normal_listRingtones.setActionCommand("Normal List Ringtones");
        normal_listRingtones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listRingtonesActionPerformed(evt);
            }
        });
        
        normal_listNotifTones = new JButton();
        normal_listNotifTones.setActionCommand("Normal List Notif Tones");
        normal_listNotifTones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listNotifTonesActionPerformed(evt);
            }
        });
        
        normal_listOtherFiles = new JButton();
        normal_listOtherFiles.setActionCommand("Normal List Other Files");
        normal_listOtherFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listOtherFilesActionPerformed(evt);
            }
        });
        
        normal_addFilesToDelete = new JButton();
        normal_addFilesToDelete.setActionCommand("Normal Add Files To Delete");
        normal_addFilesToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_addFilesToDeleteActionPerformed(evt);
            }
        });
        
        normal_removeFilesToDelete = new JButton();
        normal_removeFilesToDelete.setActionCommand("Normal Remove Files To Delete");
        normal_removeFilesToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_removeFilesToDeleteActionPerformed(evt);
            }
        });
        
        normal_listFilesToDelete = new JButton();
        normal_listFilesToDelete.setActionCommand("Normal List Files To Delete");
        normal_listFilesToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normal_listFilesToDeleteActionPerformed(evt);
            }
        });
        
        btnBrowseUpdateBinary = new JButton();
        btnBrowseUpdateBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseUpdateBinaryActionPerformed(evt);
            }
        });
        
        btnBrowseZip = new JButton();
        btnBrowseZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseZipActionPerformed(evt);
            }
        });
        
        btnCreateFlashableZip = new JButton();
        btnCheckOkay = new JButton();
        btnCurrentlySupportedDevices = new JButton();
        btnCurrentlySupportedDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentlySupportedDevicesActionPerformed(evt);
            }
        });
        
        btnResetEverything = new JButton();
        
        normal_tabbedPane = new JTabbedPane();
        
        aroma_panel = new JPanel();
        
        normal_panel = new JPanel();
        
        aroma_groupScrollPane = new JScrollPane();
        aroma_filesScrollPane = new JScrollPane();
        
        normal_groupScrollPane = new JScrollPane();
        normal_filesScrollPane = new JScrollPane();
        
        
        
        aroma_lbl_listAll = new JLabel();
        aroma_lbl_addFiles = new JLabel();
        aroma_lbl_removeFiles = new JLabel();
        
        normal_lbl_files = new JLabel();
        normal_lbl_listAll = new JLabel();
        normal_lbl_clickToAdd = new JLabel();
        normal_lbl_groups = new JLabel();
        
        lblUpdateBinary = new JLabel();
        
        txtaromaExistingZip = new JTextField();
        txtnormalKernel = new JTextField();
        txtnormalBootAnim = new JTextField();
        txtUpdateBinary = new JTextField();
        txtZipDestination = new JTextField();
        
        lblCheckOkay = new JLabel();
        
        menuBar = new JMenuBar();
        
        menuBarFile = new JMenu();
        menuBarHelp = new JMenu();
        
        menuItemExit = new JMenuItem();
        menuItemFAQ = new JMenuItem();
        menuItemAbout = new JMenuItem();

        aromaGroupModel = new DefaultListModel();
        aromaFileModel = new DefaultListModel();
        
        normalGroupModel = new DefaultListModel();
        normalFileModel = new DefaultListModel();
        
        aroma_groupList = new JList(aromaGroupModel);
        aroma_groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                aroma_groupListSelection(lse);
            }
        });
        
        aroma_fileList = new JList(aromaFileModel);
        
        normal_groupList = new JList(normalGroupModel);
        normal_groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                normal_groupListSelection(lse);
            }
        });
        
        normal_fileList = new JList(normalFileModel);
        
        aroma_groupScrollPane.setViewportView(aroma_groupList);

        aroma_filesScrollPane.setViewportView(aroma_fileList);

        aroma_addApkGroup.setText("Apk Group");

        aroma_listApkGroup.setText("Apk Group");

        aroma_addApkFiles.setText("Apks");

        aroma_removeApkFiles.setText("Apks");

        aroma_lbl_addGroup.setText("             Add Groups           ");

        aroma_addBootAnimGroup.setText("Boot Animation Group");

        aroma_listBootAnimGroup.setText("Boot Animation Group");

        aroma_removeBootAnimFiles.setText("Boot Animations");

        aroma_addBootAnimFiles.setText("Boot Animations");

        aroma_addRingtoneGroup.setText("Ringtone Group");

        aroma_addNotifGroup.setText("Notification Group");

        aroma_addkernelGroup.setText("Kernel Group");

        aroma_addDeleteApkGroup.setText("Delete Apk Group");

        aroma_addOtherFilesGroup.setText("Other Files Group");

        aroma_listRingtoneGroup.setText("Ringtone Group");

        aroma_listNotifGroup.setText("Notification Group");

        aroma_listKernelGroup.setText("Kernel Group");

        aroma_listDeleteApkGroup.setText("Delete Apk Group");

        aroma_listOtherFilesGroup.setText("Other Files Group");

        aroma_removeRingtoneFiles.setText("Ringtones");

        aroma_removeNotifFiles.setText("Notification Tones");

        aroma_removeKernelFiles.setText("Kernels");

        aroma_removeApksToDelete.setText("Apks To Delete");

        aroma_removeOtherFiles.setText("Other Files");

        aroma_addRingtoneFiles.setText("Ringtones");

        aroma_addNotifFiles.setText("Notification Tones");

        aroma_addKernelFiles.setText("Kernels");

        aroma_addApksToDelete.setText("Apks To Delete");

        aroma_addOtherFiles.setText("Other Files");

        aroma_lbl_listAll.setText("                 List All");

        aroma_lbl_addFiles.setText("             Add Files");

        aroma_lbl_removeFiles.setText("         Remove Files");

        txtaromaExistingZip.setText("Load Existing Aroma Flashable Zip To Make Changes...");

        aroma_load.setText("Load");

        aroma_listAllGroups.setText("List All Groups");

        aroma_listAllFiles.setText("List All Files");
        
        aroma_remove.setText("Remove");
        
        aroma_removeGroup.setText("Remove Group");

        //When UI of Aroma Tab is changed, portion from content starts and content ends is required to be changed...
        
        //content starts.........
        
        javax.swing.GroupLayout aroma_panelLayout = new javax.swing.GroupLayout(aroma_panel);
        aroma_panel.setLayout(aroma_panelLayout);
        aroma_panelLayout.setHorizontalGroup(
            aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aroma_panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aroma_panelLayout.createSequentialGroup()
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(aroma_addBootAnimGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_addApkGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_addRingtoneGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_addNotifGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_addkernelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_addOtherFilesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aroma_lbl_addGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(aroma_addDeleteApkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aroma_panelLayout.createSequentialGroup()
                                .addComponent(aroma_groupScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aroma_panelLayout.createSequentialGroup()
                                .addComponent(aroma_removeGroup)
                                .addGap(50, 50, 50)))
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aroma_lbl_listAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listApkGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listBootAnimGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listRingtoneGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listNotifGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listKernelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listDeleteApkGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_listOtherFilesGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aroma_addBootAnimFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aroma_addApkFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(aroma_panelLayout.createSequentialGroup()
                                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(aroma_addApksToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(aroma_addNotifFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aroma_addRingtoneFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aroma_addKernelFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aroma_addOtherFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(aroma_lbl_addFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aroma_panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(aroma_filesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aroma_panelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(aroma_remove))))
                    .addComponent(txtaromaExistingZip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aroma_removeBootAnimFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeApkFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeRingtoneFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeNotifFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeKernelFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeApksToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_removeOtherFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_lbl_removeFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aroma_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
            .addGroup(aroma_panelLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(aroma_listAllGroups)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aroma_listAllFiles)
                .addGap(250, 250, 250))
        );
        aroma_panelLayout.setVerticalGroup(
            aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aroma_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_lbl_addGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aroma_lbl_listAll)
                    .addComponent(aroma_lbl_addFiles)
                    .addComponent(aroma_lbl_removeFiles)
                    .addComponent(aroma_removeGroup)
                    .addComponent(aroma_remove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(aroma_panelLayout.createSequentialGroup()
                            .addComponent(aroma_removeApkFiles)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_removeBootAnimFiles)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_removeRingtoneFiles)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_removeNotifFiles)
                            .addGap(11, 11, 11)
                            .addComponent(aroma_removeKernelFiles)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_removeOtherFiles)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_removeApksToDelete))
                        .addGroup(aroma_panelLayout.createSequentialGroup()
                            .addComponent(aroma_addApkGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addBootAnimGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addRingtoneGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addNotifGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addkernelGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addOtherFilesGroup)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aroma_addDeleteApkGroup))
                        .addComponent(aroma_groupScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(aroma_filesScrollPane))
                    .addGroup(aroma_panelLayout.createSequentialGroup()
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listApkGroup)
                            .addComponent(aroma_addApkFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listBootAnimGroup)
                            .addComponent(aroma_addBootAnimFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listRingtoneGroup)
                            .addComponent(aroma_addRingtoneFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listNotifGroup)
                            .addComponent(aroma_addNotifFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listKernelGroup)
                            .addComponent(aroma_addKernelFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listOtherFilesGroup)
                            .addComponent(aroma_addOtherFiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aroma_listDeleteApkGroup)
                            .addComponent(aroma_addApksToDelete))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_listAllFiles)
                    .addComponent(aroma_listAllGroups))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(aroma_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaromaExistingZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aroma_load))
                .addGap(17, 17, 17))
        );
        
        //content ends.........
        
        normal_tabbedPane.addTab("Create Aroma Flashable Zip", aroma_panel);

        normal_addSystemApps.setText("System Apps");

        normal_lbl_clickToAdd.setText("Click here to add");

        normal_addDataApps.setText("Data Apps");

        normal_addRingtones.setText("Ringtones");

        normal_addNotifTones.setText("Notification Tones");

        txtnormalKernel.setText("Browse here to add boot.img file of kernel to be flashed...");

        normal_removeSystemApps.setText("System Apps");

        normal_lbl_groups.setText("Groups");

        txtnormalBootAnim.setText("Browse here to add bootanimation.zip file of boot animation to be added...");

        normal_browseKernel.setText("Browse");

        normal_browseBootAnim.setText("Browse");

        normal_lbl_clickToRemove.setText("Click here to remove");

        normal_removeDataApps.setText("Data Apps");

        normal_removeRingtones.setText("Ringtones");

        normal_removeNotifTones.setText("Notification Tones");

        normal_addOtherFiles.setText("Other Files");

        normal_removeOtherFiles.setText("Other Files");

        normal_groupScrollPane.setViewportView(normal_groupList);

        normal_filesScrollPane.setViewportView(normal_fileList);

        normal_lbl_files.setText("Files");

        normal_listSystemApps.setText("System Apps");

        normal_listDataApps.setText("Data Apps");

        normal_listRingtones.setText("Ringtones");

        normal_listNotifTones.setText("Notification Tones");

        normal_listOtherFiles.setText("Other Files");

        normal_lbl_listAll.setText("List All");

        normal_addFilesToDelete.setText("Files to Delete");

        normal_removeFilesToDelete.setText("Files to Delete");

        normal_listFilesToDelete.setText("Files to Delete");
        
        //When UI of Normal Tab is changed, portion from content starts and content ends is required to be changed...
        
        //content starts.........

        javax.swing.GroupLayout normal_panelLayout = new javax.swing.GroupLayout(normal_panel);
        normal_panel.setLayout(normal_panelLayout);
        normal_panelLayout.setHorizontalGroup(
            normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(normal_panelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(normal_panelLayout.createSequentialGroup()
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(normal_addNotifTones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(normal_addRingtones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(normal_addDataApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(normal_addSystemApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(normal_addOtherFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(normal_lbl_clickToAdd))
                            .addComponent(normal_addFilesToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addComponent(normal_lbl_groups)
                                .addGap(100, 100, 100)
                                .addComponent(normal_lbl_clickToRemove)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, normal_panelLayout.createSequentialGroup()
                                .addComponent(normal_groupScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(normal_removeNotifTones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_removeDataApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_removeSystemApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_removeRingtones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_removeOtherFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_removeFilesToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(normal_lbl_files)
                                .addGap(139, 139, 139)
                                .addComponent(normal_lbl_listAll))
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(normal_filesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(normal_listNotifTones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_listSystemApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_listDataApps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_listRingtones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_listOtherFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normal_listFilesToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(normal_panelLayout.createSequentialGroup()
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnormalKernel)
                            .addComponent(txtnormalBootAnim, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(normal_browseKernel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(normal_browseBootAnim, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(33, 33, 33)))
                .addGap(147, 147, 147))
        );
        normal_panelLayout.setVerticalGroup(
            normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(normal_panelLayout.createSequentialGroup()
                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(normal_panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(normal_lbl_clickToAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(normal_lbl_groups)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, normal_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(normal_lbl_clickToRemove)
                            .addComponent(normal_lbl_files)
                            .addComponent(normal_lbl_listAll))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(normal_filesScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(normal_panelLayout.createSequentialGroup()
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addComponent(normal_listSystemApps)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(normal_listDataApps)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(normal_listRingtones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(normal_listNotifTones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(normal_listOtherFiles))
                            .addGroup(normal_panelLayout.createSequentialGroup()
                                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(normal_panelLayout.createSequentialGroup()
                                        .addComponent(normal_removeSystemApps)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(normal_removeDataApps)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(normal_removeRingtones)
                                        .addGap(11, 11, 11)
                                        .addComponent(normal_removeNotifTones))
                                    .addGroup(normal_panelLayout.createSequentialGroup()
                                        .addComponent(normal_addSystemApps)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(normal_addDataApps)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(normal_addRingtones)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(normal_addNotifTones)))
                                .addGap(11, 11, 11)
                                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(normal_addOtherFiles)
                                    .addComponent(normal_removeOtherFiles))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(normal_addFilesToDelete)
                            .addComponent(normal_removeFilesToDelete)
                            .addComponent(normal_listFilesToDelete)))
                    .addComponent(normal_groupScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(normal_panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(normal_browseKernel))
                    .addComponent(txtnormalKernel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(normal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnormalBootAnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normal_browseBootAnim))
                .addGap(18, 18, 18))
        );
        
        //content ends.........

        normal_tabbedPane.addTab("Create Normal Flashable Zip", normal_panel);

        lblUpdateBinary.setText("Enter Working update-binary File from your device's existing ROM (i.e. located in META-INF/com/google/android/ folder) if your device is not listed here in List of ");

        txtUpdateBinary.setText("Browse File From Here...");

        btnBrowseUpdateBinary.setText("Browse");

        txtZipDestination.setText("Select Destination Folder...");

        btnBrowseZip.setText("Browse");

        btnCreateFlashableZip.setText("Create Flashable Zip");

        btnCheckOkay.setText("Check If Everything is Okay!");

        lblCheckOkay.setText("After you are ready to Create Zip File, Click Here, It is Recommended to");

        btnCurrentlySupportedDevices.setText("Currently Supported Devices");

        btnResetEverything.setText("Reset Everything");

        menuBarFile.setText("File");

        menuItemExit.setText("Exit");
        menuBarFile.add(menuItemExit);

        menuBar.add(menuBarFile);

        menuBarHelp.setText("Help");

        menuItemFAQ.setText("FAQ");
        menuBarHelp.add(menuItemFAQ);

        menuItemAbout.setText("About");
        menuBarHelp.add(menuItemAbout);

        menuBar.add(menuBarHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCheckOkay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckOkay)
                        .addGap(30, 30, 30)
                        .addComponent(btnResetEverything)
                        .addGap(30, 30, 30)
                        .addComponent(btnCreateFlashableZip))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtZipDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBrowseZip, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(normal_tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBrowseUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblUpdateBinary)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCurrentlySupportedDevices))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUpdateBinary)
                    .addComponent(btnCurrentlySupportedDevices))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseUpdateBinary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normal_tabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtZipDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseZip))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheckOkay)
                    .addComponent(btnCheckOkay)
                    .addComponent(btnCreateFlashableZip)
                    .addComponent(btnResetEverything))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    //All UI designing functions here...
    
    //This one is generalUI for all groups..
    public void aromaAddGroupUI(){
        frame= new JFrame();
        
        JDialog dialog = new JDialog(frame,"Create Group Name",true);
        
        aroma_addGroupPanel = new JPanel();
        aroma_addGroupNameTitle = new JLabel();
        aroma_groupName = new JTextField();
        
        aroma_addGroupBtnContinue = new JButton();
        aroma_addGroupBtnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addGroupBtnContinueActionPerformed(evt);
            }
        });
        
        aroma_addGroupBtnCancel = new JButton();
        aroma_addGroupBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addGroupBtnCancelActionPerformed(evt);
            }
        });
        
        aroma_addGroupTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aroma_addGroupNameTitle.setText("Group Name :");

        aroma_addGroupBtnContinue.setText("Continue");

        aroma_addGroupBtnCancel.setText("Cancel");

        aroma_addGroupTitle.setText("Enter the name of group in which files will be added.");

        javax.swing.GroupLayout aroma_addGroupPanelLayout = new javax.swing.GroupLayout(aroma_addGroupPanel);
        aroma_addGroupPanel.setLayout(aroma_addGroupPanelLayout);
        aroma_addGroupPanelLayout.setHorizontalGroup(
            aroma_addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aroma_addGroupPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(aroma_addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aroma_addGroupTitle)
                    .addGroup(aroma_addGroupPanelLayout.createSequentialGroup()
                        .addComponent(aroma_addGroupNameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aroma_groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(aroma_addGroupPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(aroma_addGroupBtnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aroma_addGroupBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        aroma_addGroupPanelLayout.setVerticalGroup(
            aroma_addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aroma_addGroupPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(aroma_addGroupTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aroma_addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_addGroupNameTitle)
                    .addComponent(aroma_groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(aroma_addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_addGroupBtnContinue)
                    .addComponent(aroma_addGroupBtnCancel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(aroma_addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(aroma_addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        pack();
        
        dialog.setContentPane(aroma_addGroupPanel);
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
    
    //This is UI of Add Apk Group in Aroma Tab..
    public void aromaAddApkGroupUI(){
        frame= new JFrame();
        
        JDialog dialog = new JDialog(frame,"Create Group Name",true);
        
        aroma_addGroupPanel = new JPanel();
        aroma_addGroupNameTitle = new JLabel();
        aroma_groupName = new JTextField();
        
        aroma_addApkGroupRadSystem = new JRadioButton();
        aroma_addApkGroupRadSystem.setSelected(true);
        aroma_addApkGroupRadSystem.setActionCommand("Aroma Add System Apk Group");
        
        aroma_addApkGroupRadData = new JRadioButton();
        aroma_addApkGroupRadData.setActionCommand("Aroma Add Data Apk Group");
        
        groupButton = new ButtonGroup();
        groupButton.add(aroma_addApkGroupRadSystem);
        groupButton.add(aroma_addApkGroupRadData);
        
        aroma_addGroupBtnContinue = new JButton();
        aroma_addGroupBtnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addGroupBtnContinueActionPerformed(evt);
            }
        });
        
        aroma_addGroupBtnCancel = new JButton();
        aroma_addGroupBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aroma_addGroupBtnCancelActionPerformed(evt);
            }
        });
        
        aroma_addGroupTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aroma_addGroupNameTitle.setText("Group Name :");

        aroma_addApkGroupRadSystem.setText("Installs to /system/app");

        aroma_addApkGroupRadData.setText("Installs to /data/app");

        aroma_addGroupBtnContinue.setText("Continue");

        aroma_addGroupBtnCancel.setText("Cancel");

        aroma_addGroupTitle.setText("Enter the name of group in which files will be added.");

        javax.swing.GroupLayout aroma_addApkGroupPanelLayout = new javax.swing.GroupLayout(aroma_addGroupPanel);
        aroma_addGroupPanel.setLayout(aroma_addApkGroupPanelLayout);
        aroma_addApkGroupPanelLayout.setHorizontalGroup(
            aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aroma_addApkGroupPanelLayout.createSequentialGroup()
                .addGroup(aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aroma_addApkGroupPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(aroma_addGroupBtnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(aroma_addGroupBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(aroma_addApkGroupPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aroma_addGroupTitle)
                            .addGroup(aroma_addApkGroupPanelLayout.createSequentialGroup()
                                .addComponent(aroma_addGroupNameTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aroma_addApkGroupRadData)
                                    .addComponent(aroma_addApkGroupRadSystem)
                                    .addComponent(aroma_groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        aroma_addApkGroupPanelLayout.setVerticalGroup(
            aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aroma_addApkGroupPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(aroma_addGroupTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_addGroupNameTitle)
                    .addComponent(aroma_groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aroma_addApkGroupRadSystem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aroma_addApkGroupRadData)
                .addGap(26, 26, 26)
                .addGroup(aroma_addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aroma_addGroupBtnContinue)
                    .addComponent(aroma_addGroupBtnCancel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(aroma_addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(aroma_addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        pack();
        dialog.setContentPane(aroma_addGroupPanel);
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
    
    public void currentlySupportedDevicesUI(){
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
        
        for(String deviceName : this.CSDArrayList){
            CSDModel.addElement(deviceName);
        }
        CSDList.setSelectedValue(this.selectedDevice, true
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(CSD_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
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
    
    //All event handling functions here...
    
    public void aroma_addGroupBtnContinueActionPerformed(ActionEvent ae) {
        System.out.println("Button clicked is : " + ae.getActionCommand());
        System.out.println("Root Button clicked is : " + this.lastActionCommand);
        
        if(!this.aroma_groupName.getText().equals("")){
            if(!this.aroma_groupArrayList.contains(this.aroma_groupName)){
                // Following Switch identifies which button generated event..
                this.aroma_groupArrayList.add(this.aroma_groupName.getText());
                switch(this.lastActionCommand){
                    case "Aroma Add Apk Group":
                        if(this.groupButton.getSelection().getActionCommand().equals("Aroma Add System Apk Group")){
                            this.aroma_systemList.add(this.aroma_groupName.getText());
                        }
                        else{
                            this.aroma_dataList.add(this.aroma_groupName.getText());
                        }
                        System.out.println("Button Group is : " + this.groupButton.getSelection().getActionCommand());
                        break;
                    case "Aroma Add BootAnim Group":
                        this.aroma_bootAnimList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        break;
                    case "Aroma Add Ringtone Group":
                        this.aroma_ringtoneList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        break;
                    case "Aroma Add Notif Group":
                        this.aroma_notifList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        break;
                    case "Aroma Add Kernel Group":
                        this.aroma_kernelList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        break;
                    case "Aroma Add Other Files Group":
                        this.aroma_otherFileList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        break;
                    case "Aroma Add Delete Apk Group":
                        this.aroma_deleteApkList.add(this.aroma_groupName.getText());
                        System.out.println("Button Group Added in : " + this.lastActionCommand);
                        Default:
                        System.out.println("Something Went Wrong..!!");
                }
                aromaGroupModel.addElement(this.aroma_groupArrayList.get(this.aroma_groupArrayList.size()-1));

                //This will close/dispose current dialogbox..
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "You Cannot Continue Without Setting Group Name..!!");
        }
    }                                                         

    public void aroma_addGroupBtnCancelActionPerformed(ActionEvent ae) {
        System.out.println("Button clicked is : " + ae.getActionCommand());
        frame.dispose();
    }
    
    public void aroma_listApkGroupActionPerformed(ActionEvent ae) {     
        if(this.aroma_systemList.isEmpty() && this.aroma_dataList.isEmpty()){
            JOptionPane.showMessageDialog(null, "Group does not exist..!!");
        }
        else{
            aroma_groupList.clearSelection();
            aromaGroupModel.removeAllElements();
            for(String system_list : aroma_systemList){
                aromaGroupModel.addElement(system_list);
            }
            for(String data_list : aroma_dataList){
                aromaGroupModel.addElement(data_list);
            }
        }
        // TODO add your handling code here:
    }                                                  

    public void aroma_listBootAnimGroupActionPerformed(ActionEvent ae) {                                                        
        this.listGroup(this.aroma_bootAnimList, this.aromaGroupModel);
    }                                                       

    public void aroma_listRingtoneGroupActionPerformed(ActionEvent ae) {                                                        
        this.listGroup(this.aroma_ringtoneList, this.aromaGroupModel);
    }                                                       

    public void aroma_listNotifGroupActionPerformed(ActionEvent ae) {                                                     
        this.listGroup(this.aroma_notifList, this.aromaGroupModel);
    }                                                    

    public void aroma_listKernelGroupActionPerformed(ActionEvent ae) {                                                      
        this.listGroup(this.aroma_kernelList, this.aromaGroupModel);
    }                                                     

    public void aroma_listOtherFilesGroupActionPerformed(ActionEvent ae) {                                                          
        this.listGroup(this.aroma_otherFileList, this.aromaGroupModel);
    }                                                         

    public void aroma_listDeleteApkGroupActionPerformed(ActionEvent ae) {                                                         
        this.listGroup(this.aroma_deleteApkList, this.aromaGroupModel);
    }                                                        

    public void aroma_addApkFilesActionPerformed(ActionEvent ae) {
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not an apk group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                 

    public void aroma_addBootAnimFilesActionPerformed(ActionEvent ae) {                                                       
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not a Boot Animation group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                      

    public void aroma_addRingtoneFilesActionPerformed(ActionEvent ae) {                                                       
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not a Ringtones group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                      

    public void aroma_addNotifFilesActionPerformed(ActionEvent ae) {                                                    
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not a Notification Tones group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                   

    public void aroma_addKernelFilesActionPerformed(ActionEvent ae) {                                                     
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not a Kernel group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                    

    public void aroma_addOtherFilesActionPerformed(ActionEvent ae) {                                                    
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not an Other Files group..!!");
        }
        else{
            this.chooseFile(ae.getActionCommand());
        }
    }                                                   

    public void aroma_addApksToDeleteActionPerformed(ActionEvent ae) {                                                      
        if(this.aroma_groupList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Apps!!");
        }
        else if(!isRelativeGroup(this.aroma_groupList.getSelectedValue().toString(), ae.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Selected Group is not a Delete Apk group..!!");
        }
        else{
            //this.chooseFile(ae.getActionCommand());
        }
    }                                                     

    public void aroma_removeApkFilesActionPerformed(ActionEvent ae) {                                                     
        // TODO add your handling code here:
    }                                                    

    public void aroma_removeBootAnimFilesActionPerformed(ActionEvent ae) {                                                          
        // TODO add your handling code here:
    }                                                         

    public void aroma_removeRingtoneFilesActionPerformed(ActionEvent ae) {                                                          
        // TODO add your handling code here:
    }                                                         

    public void aroma_removeNotifFilesActionPerformed(ActionEvent ae) {                                                       
        // TODO add your handling code here:
    }                                                      

    public void aroma_removeKernelFilesActionPerformed(ActionEvent ae) {                                                        
        // TODO add your handling code here:
    }                                                       

    public void aroma_removeOtherFilesActionPerformed(ActionEvent ae) {                                                       
        // TODO add your handling code here:
    }                                                      

    public void aroma_removeApksToDeleteActionPerformed(ActionEvent ae) {                                                         
        // TODO add your handling code here:
    }                                                        

    public void aroma_listAllGroupsActionPerformed(ActionEvent ae) {
        if(!this.aroma_groupArrayList.isEmpty()){
            this.listGroup(this.aroma_groupArrayList, this.aromaGroupModel);
        }
        else{
            JOptionPane.showMessageDialog(null, "No Group Added so far..!!");
        }
    }                                                   

    public void aroma_listAllFilesActionPerformed(ActionEvent ae) {                                                   
        // TODO add your handling code here:
    }                                                  

    public void aroma_loadActionPerformed(ActionEvent ae) {                                           
        // TODO add your handling code here:
    }
    
    public void aroma_removeGroupActionPerformed(ActionEvent ae){
        if(!this.aroma_groupArrayList.isEmpty()){
            if(!this.aroma_groupList.isSelectionEmpty()){
                this.removeGroup(this.aroma_groupList.getSelectedValue().toString());
            }
            else{
                JOptionPane.showMessageDialog(this, "Select Group First..!!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "No Group Added so far. Add Group First..!!");
        }
        
    }
    
    public void aroma_removeActionPerformed(ActionEvent ae){
        // TODO add your handling code here:
    }
    
    public void aroma_addRingtoneGroupActionPerformed(ActionEvent ae) {                                                       
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }                                                      

    public void aroma_addNotifGroupActionPerformed(ActionEvent ae) {                                                    
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }                                                   

    public void aroma_addkernelGroupActionPerformed(ActionEvent ae) {                                                     
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }                                                    

    public void aroma_addOtherFilesGroupActionPerformed(ActionEvent ae) {                                                         
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }                                                        

    public void aroma_addDeleteApkGroupActionPerformed(ActionEvent ae) {                                                        
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }        
    
    public void aroma_addBootAnimGroupActionPerformed(ActionEvent ae){
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddGroupUI();
    }
    
    public void aroma_addApkGroupActionPerformed(ActionEvent ae){
        System.out.println("Button clicked is : " + ae.getActionCommand());
        this.lastActionCommand = ae.getActionCommand(); //setting this value so that, when continue is pressed it could be known which button generated event..!
        this.aromaAddApkGroupUI();
    }
    
    public void aroma_groupListSelection(ListSelectionEvent lse){
        try{
            if (!lse.getValueIsAdjusting()) {
                if(keyExistInMap(this.aroma_groupList.getSelectedValue().toString(), this.aroma_map)){
                    System.out.println("Working!!" );
                    aromaFileModel.removeAllElements();
                    addListToModelWithStringIndex(this.aroma_groupList.getSelectedValue().toString(), aromaFileModel, this.aroma_map);
                }
                else{
                    aromaFileModel.removeAllElements();
                    System.out.println("Not Working!!");
                }
            }   
        }catch (NullPointerException npe){
            System.out.println("Exception Caught....");
            //aromaFileModel.removeAllElements();
        }
    }
    
    public void normal_groupListSelection(ListSelectionEvent lse){
        if (!lse.getValueIsAdjusting()) {
            if(keyExistInMap(normal_groupList.getSelectedValue().toString(), this.normal_map)){
                System.out.println("Working!!" );
                normalGroupModel.removeAllElements();
                addListToModelWithStringIndex(normal_groupList.getSelectedValue().toString(), normalGroupModel, this.normal_map);
            }
            else{
                normalGroupModel.removeAllElements();
                System.out.println("Not Working!!");
            }
        }        
    }
    
    public void normal_addSystemAppsActionPerformed(ActionEvent ae) {                                                     
        // TODO add your handling code here:
    }                                                    

    public void normal_addDataAppsActionPerformed(ActionEvent ae) {                                                   
        // TODO add your handling code here:
    }                                                  

    public void normal_addRingtonesActionPerformed(ActionEvent ae) {                                                    
        // TODO add your handling code here:
    }                                                   

    public void normal_addNotifTonesActionPerformed(ActionEvent ae) {                                                     
        // TODO add your handling code here:
    }                                                    

    public void normal_addOtherFilesActionPerformed(ActionEvent ae) {                                                     
        // TODO add your handling code here:
    }                                                    

    public void normal_addFilesToDeleteActionPerformed(ActionEvent ae) {                                                        
        // TODO add your handling code here:
    }                                                       

    public void normal_removeSystemAppsActionPerformed(ActionEvent ae) {                                                        
        // TODO add your handling code here:
    }                                                       

    public void normal_removeDataAppsActionPerformed(ActionEvent ae) {                                                      
        // TODO add your handling code here:
    }                                                     

    public void normal_removeRingtonesActionPerformed(ActionEvent ae) {                                                       
        // TODO add your handling code here:
    }                                                      

    public void normal_removeNotifTonesActionPerformed(ActionEvent ae) {                                                        
        // TODO add your handling code here:
    }                                                       

    public void normal_removeOtherFilesActionPerformed(ActionEvent ae) {                                                        
        // TODO add your handling code here:
    }                                                       

    public void normal_removeFilesToDeleteActionPerformed(ActionEvent ae) {                                                           
        // TODO add your handling code here:
    }                                                          

    public void normal_listSystemAppsActionPerformed(ActionEvent ae) {                                                      
        // TODO add your handling code here:
    }                                                     

    public void normal_listDataAppsActionPerformed(ActionEvent ae) {                                                    
        // TODO add your handling code here:
    }                                                   

    public void normal_listRingtonesActionPerformed(ActionEvent ae) {                                                     
        // TODO add your handling code here:
    }                                                    

    public void normal_listNotifTonesActionPerformed(ActionEvent ae) {                                                      
        // TODO add your handling code here:
    }                                                     

    public void normal_listOtherFilesActionPerformed(ActionEvent ae) {                                                      
        // TODO add your handling code here:
    }                                                     

    public void normal_listFilesToDeleteActionPerformed(ActionEvent ae) {                                                         
        // TODO add your handling code here:
    }                                                        

    public void normal_browseKernelActionPerformed(ActionEvent ae) {                                                    
        // TODO add your handling code here:
    }                                                   

    public void normal_browseBootAnimActionPerformed(ActionEvent ae) {                                                      
        // TODO add your handling code here:
    }
    
    public void CSD_continueActionPerformed(ActionEvent ae){
        this.selectedDevice = this.CSDList.getSelectedValue().toString();
        System.out.println(this.selectedDevice);
        txtUpdateBinary.setText("update-binary of " + this.selectedDevice + " Imported Successfully..!");
        frame.dispose();
    }
    
    public void CSD_cancelActionPerformed(ActionEvent ae){
        frame.dispose();
    }
    
    public void btnBrowseUpdateBinaryActionPerformed(ActionEvent ae){
        System.out.println("Source is " + ae.getClass());
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(btnBrowseUpdateBinary);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("update-binary File Location : " + file.getAbsolutePath());
            if(!file.getName().equals("update-binary")){
                JOptionPane.showMessageDialog(null, "Selected File May not be update-binary file..!!\nYou are using this file at your own risk..!");
            }
            txtUpdateBinary.setText(file.getAbsolutePath());
            this.updateBinaryPath = file.getAbsolutePath();
            this.selectedDevice = "";
        } else {
            System.out.println("File access cancelled by user.");
        }
    }
    
    public void btnBrowseZipActionPerformed(ActionEvent ae){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZip);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Zip File Destination Location : " + file.getAbsolutePath());
            if(!file.getAbsolutePath().endsWith(".zip")){
                this.zipDestination = file.getAbsolutePath() + ".zip";
            }else{
                this.zipDestination = file.getAbsolutePath();
            }
            txtZipDestination.setText(this.zipDestination);
            this.tempFolderPath = file.getParent() + "\\temp$$folder";
            System.out.println("Temp Folder Path : " + this.tempFolderPath);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }
    
    public void btnCurrentlySupportedDevicesActionPerformed(ActionEvent ae){
        this.currentlySupportedDevicesUI();
    }
    
    //All Custom Functions Here...
    
    public boolean isRelativeGroup(String groupName, String category){
        switch(category){
            case "Aroma Add Apk Files":
                if(this.aroma_systemList.contains(groupName) || this.aroma_dataList.contains(groupName)) return true;
                break;
            case "Aroma Add BootAnim Files":
                if(this.aroma_bootAnimList.contains(groupName)) return true;
                break;
            case "Aroma Add Ringtone Files":
                if(this.aroma_ringtoneList.contains(groupName)) return true;
                break;
            case "Aroma Add Notif Files":
                if(this.aroma_notifList.contains(groupName)) return true;
                break;
            case "Aroma Add Kernel Files":
                if(this.aroma_kernelList.contains(groupName)) return true;
                break;
            case "Aroma Add Other Files":
                if(this.aroma_otherFileList.contains(groupName)) return true;
                break;
        }
        return false;
    }
    
    public boolean keyExistInMap(String str, MultiValueMap mvm){
        try{
            Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry mapEntry = (Map.Entry) it.next();
                if(str.equals(mapEntry.getKey())){
                    return true;
                }
            }
        }catch (NullPointerException npe){
            System.out.println("Exception Caught");
            return false;
        }
        return false;
    }
    
    public String getNameFromPath(String str){
        String tempString[] = str.split("\\\\");
        System.out.println("Successfully Splitted from " + str + " to " + tempString[tempString.length-1]);
        return tempString[tempString.length-1];
    }
    
    public void addListToModelWithStringIndex(String str, DefaultListModel model, MultiValueMap mvm){
        ArrayList<String> arrayList = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            if(str.equals(mapEntry.getKey())){
                arrayList = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for (int j = 0; j < arrayList.size(); j++) {
                    System.out.println("Testing.. "+getNameFromPath(arrayList.get(j)));
                    System.out.println("\t" + mapEntry.getKey() + "\t  " + getNameFromPath(arrayList.get(j)));
                    model.addElement(getNameFromPath(arrayList.get(j)));
                }
            }
        }
    }
    
    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList,DefaultListModel fileModel, MultiValueMap map){
        
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File[] file = fileChooser.getSelectedFiles();
                for(int i=0; i<file.length; i++){
                    map.put(groupList.getSelectedValue(), file[i].getAbsolutePath());
                    System.out.println(file[i].getAbsolutePath());
                }
                fileModel.removeAllElements();
                addListToModelWithStringIndex(groupList.getSelectedValue().toString(), fileModel, map);
        } else {
        System.out.println("File access cancelled by user.");
        }
    }
    
    public void chooseFile(String rootComponent){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        //FileFilter filter = new FileNameExtensionFilter("." + extension, extension);
        FileFilter filter;
        
        switch(rootComponent){
            case "Aroma Add Apk Files":
                filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(filter);
                this.filterFile(fileChooser, aroma_addApkFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
            case "Aroma Add BootAnim Files":
                filter = new FileNameExtensionFilter(".zip", "zip");
                fileChooser.addChoosableFileFilter(filter);
                this.filterFile(fileChooser, aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
            case "Aroma Add Ringtone Files":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(new AudioFilter());
                this.filterFile(fileChooser, aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
            case "Aroma Add Notif Files":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                fileChooser.addChoosableFileFilter(new AudioFilter());
                this.filterFile(fileChooser, aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
            case "Aroma Add Kernel Files":
                filter = new FileNameExtensionFilter(".img", "img");
                fileChooser.addChoosableFileFilter(filter);
                this.filterFile(fileChooser, aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
            case "Aroma Add Other Files":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                //this.filterFile(fileChooser, "zip", aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, aroma_map);
                System.out.println("Aroma Map contains : " + aroma_map);
                break;
        }
    }
    
    public void listGroup(ArrayList<String> list, DefaultListModel model){
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selected Group does not exist..!!");
        }
        else{
            model.removeAllElements();
            for(String groupList : list){
                model.addElement(groupList);
            }
        }
    }
    
    public void removeGroup(String groupName){
        if(this.aroma_groupArrayList.contains(groupName)){
            this.aroma_groupArrayList.remove(groupName);
            Boolean flag = this.aroma_systemList.contains(groupName)?this.aroma_systemList.remove(groupName):this.aroma_dataList.contains(groupName)?this.aroma_dataList.remove(groupName):false;
            flag = (!flag)?this.aroma_ringtoneList.contains(groupName)?this.aroma_ringtoneList.remove(groupName):this.aroma_notifList.contains(groupName)?this.aroma_notifList.remove(groupName):false:false;
            flag = (!flag)?this.aroma_kernelList.contains(groupName)?this.aroma_kernelList.remove(groupName):this.aroma_otherFileList.contains(groupName)?this.aroma_otherFileList.remove(groupName):false:false;
            flag = (!flag)?(this.aroma_deleteApkList.contains(groupName)?this.aroma_deleteApkList.remove(groupName):true):false;
            if(flag){
                JOptionPane.showMessageDialog(null, "Group Removed..");
            }
            this.aromaGroupModel.removeAllElements();
            for(String group: this.aroma_groupArrayList){
                this.aromaGroupModel.addElement(group);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No Group Exists, Add Group First..!!");
        }
    }
    
//    public static void main(String[] args) {
//        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AromaInstallerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AromaInstallerTemp().setVisible(true);
//            }
//        });
//    }
    
    //Declarations Here...
    String lastActionCommand = "";
    String updateBinaryPath = "";
    String zipDestination = "";
    String tempFolderPath = "";
    String selectedDevice = "";
    
    ArrayList<String> CSDArrayList;
    ArrayList<String> aroma_groupArrayList = new ArrayList<>();
    ArrayList<String> aroma_systemList = new ArrayList<>();
    ArrayList<String> aroma_dataList = new ArrayList<>();
    ArrayList<String> aroma_bootAnimList = new ArrayList<>();
    ArrayList<String> aroma_ringtoneList = new ArrayList<>();
    ArrayList<String> aroma_notifList = new ArrayList<>();
    ArrayList<String> aroma_kernelList = new ArrayList<>();
    ArrayList<String> aroma_otherFileList = new ArrayList<>();
    ArrayList<String> aroma_deleteApkList = new ArrayList<>();
    
    MultiValueMap aroma_map = new MultiValueMap();
    MultiValueMap normal_map = new MultiValueMap();
    
    public DefaultListModel aromaGroupModel;
    public DefaultListModel aromaFileModel;
    
    public DefaultListModel normalGroupModel;
    public DefaultListModel normalFileModel;
    
    public JFrame frame;
    
    public JButton aroma_addGroupBtnCancel;
    public JButton aroma_addGroupBtnContinue;
    public JLabel aroma_addGroupNameTitle;
    public JPanel aroma_addGroupPanel;
    
    ButtonGroup groupButton;
    
    public JRadioButton aroma_addApkGroupRadData;
    public JRadioButton aroma_addApkGroupRadSystem;
    public JTextField aroma_groupName;
    public JLabel aroma_addGroupTitle;
    
    public JButton aroma_remove;
    public JButton aroma_removeGroup;
    public JButton aroma_addApkFiles;
    public JButton aroma_addApkGroup;
    public JButton aroma_addApksToDelete;
    public JButton aroma_addBootAnimFiles;
    public JButton aroma_addBootAnimGroup;
    public JButton aroma_addDeleteApkGroup;
    public JButton aroma_addKernelFiles;
    public JButton aroma_addNotifFiles;
    public JButton aroma_addNotifGroup;
    public JButton aroma_addOtherFiles;
    public JButton aroma_addOtherFilesGroup;
    public JButton aroma_addRingtoneFiles;
    public JButton aroma_addRingtoneGroup;
    public JButton aroma_addkernelGroup;
    public JButton aroma_listAllFiles;
    public JButton aroma_listAllGroups;
    public JButton aroma_listApkGroup;
    public JButton aroma_listBootAnimGroup;
    public JButton aroma_listDeleteApkGroup;
    public JButton aroma_listKernelGroup;
    public JButton aroma_listNotifGroup;
    public JButton aroma_listOtherFilesGroup;
    public JButton aroma_listRingtoneGroup;
    public JButton aroma_load;
    public JButton aroma_removeApkFiles;
    public JButton aroma_removeApksToDelete;
    public JButton aroma_removeBootAnimFiles;
    public JButton aroma_removeKernelFiles;
    public JButton aroma_removeNotifFiles;
    public JButton aroma_removeOtherFiles;
    public JButton aroma_removeRingtoneFiles;
    
    public JButton btnBrowseUpdateBinary;
    public JButton btnBrowseZip;
    public JButton btnCheckOkay;
    public JButton btnCreateFlashableZip;
    public JButton btnCurrentlySupportedDevices;
    public JButton btnResetEverything;
    
    public JButton normal_addDataApps;
    public JButton normal_addFilesToDelete;
    public JButton normal_addNotifTones;
    public JButton normal_addOtherFiles;
    public JButton normal_addRingtones;
    public JButton normal_addSystemApps;
    public JButton normal_browseBootAnim;
    public JButton normal_browseKernel;
    public JButton normal_listDataApps;
    public JButton normal_listFilesToDelete;
    public JButton normal_listNotifTones;
    public JButton normal_listOtherFiles;
    public JButton normal_listRingtones;
    public JButton normal_listSystemApps;
    public JButton normal_removeDataApps;
    public JButton normal_removeFilesToDelete;
    public JButton normal_removeNotifTones;
    public JButton normal_removeOtherFiles;
    public JButton normal_removeRingtones;
    public JButton normal_removeSystemApps;
    
    public JList CSDList;
    
    public JList aroma_fileList;
    public JList aroma_groupList;
    
    public JList normal_fileList;
    public JList normal_groupList;
    
    public JScrollPane aroma_groupScrollPane;
    public JScrollPane aroma_filesScrollPane;
    
    public JScrollPane normal_filesScrollPane;
    public JScrollPane normal_groupScrollPane;
    
    public JLabel aroma_lbl_addFiles;
    public JLabel aroma_lbl_addGroup;
    public JLabel aroma_lbl_listAll;
    public JLabel aroma_lbl_removeFiles;
    public JPanel aroma_panel;
    
    public JLabel lblCheckOkay;
    public JLabel lblUpdateBinary;
    
    public JPanel normal_panel;
    public JLabel normal_lbl_clickToAdd;
    public JLabel normal_lbl_clickToRemove;
    public JLabel normal_lbl_files;
    public JLabel normal_lbl_groups;
    public JLabel normal_lbl_listAll;
    
    public JMenuBar menuBar;
    
    public JMenu menuBarFile;
    public JMenu menuBarHelp;
    
    public JMenuItem menuItemAbout;
    public JMenuItem menuItemExit;
    public JMenuItem menuItemFAQ;
    
    public JTabbedPane normal_tabbedPane;
    public JTabbedPane aroma_tabbedPane;
    
    public JTextField txtaromaExistingZip;
    
    public JTextField txtnormalBootAnim;
    public JTextField txtnormalKernel;
    
    public JTextField txtUpdateBinary;
    public JTextField txtZipDestination;
}
