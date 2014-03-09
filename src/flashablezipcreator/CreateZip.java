/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Nikhil
 * @author Rajat
 */
public class CreateZip extends SwingWorker<Void, Void> {

    private int progress;
    ProgressBarUpdater ju;
    MainUI ai;
    Operations op;
    boolean close;
    boolean isZipCreated = false;

    CreateZip(MainUI aThis, Operations op) {
        this.ai = aThis;
        this.op = op;
        progress = 0;
        this.close = false;
    }

    public void CreateZip(MainUI ai, Operations op) {

    }

    @Override
    protected Void doInBackground() throws Exception {
//        ai.contentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ju = new ProgressBarUpdater(ai.progressCZ);
        new java.lang.Thread(ju).start();
        createZipAt(op.zipDestination);
        return null;
    }

//    public void removeEmptyGroup(){
//        ai.setLog("Checking If Any Group is Empty...", ai.runTextAreaCZ);
//        ArrayList<String> arrayList;
//        arrayList = op.groupArrayList;
//        for(String groupName: arrayList){
//            System.out.println("Considering " + groupName);
//            if(!op.map.containsKey(groupName)){
//                this.removeEmptyGroup(groupName);
//                System.out.println(groupName + " Removed..!!" + " Now GroupList Contains " + op.groupArrayList);
//                //recursion is used here..
//                removeEmptyGroup();
//                JOptionPane.showMessageDialog(ai, "Removed Empty Group : " + groupName);
//                ai.setLog("Removing Empty group " + groupName, ai.runTextAreaCZ);
//            }
//            else{
//                System.out.println("Nothing to remove..!!");
//            }
//        }
//    }
//    
//    public void removeEmptyGroup(String groupName){
//        String str = groupName.substring(0,groupName.indexOf("_"));
//        //JOptionPane.showMessageDialog(null, "String is " + str);
//        switch(str){
//                case "APKs-System":
//                    op.systemList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                case "APKs-Data":
//                    op.dataList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                case "BootAnimations":
//                    op.bootAnimList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                case "Ringtones":
//                    op.ringtoneList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                case "Notifications":
//                    op.notifList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                case "Kernel":
//                    op.kernelList.remove(groupName);
//                    op.groupArrayList.remove(groupName);
//                    break;
//                default:
//                System.out.println("Something Went Wrong..!!");
//        }
//    }
    public void writeFileToZip(InputStream in, ZipOutputStream zos, String writeAt) throws IOException {
        System.out.println("File Writing at " + writeAt);
        ai.setLog("File Writing at " + writeAt, ai.debugTextAreaCZ);
        byte[] buffer = new byte[1024];
        ZipEntry ze = new ZipEntry(writeAt);
        zos.putNextEntry(ze);
        int len;
        while ((len = in.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        System.out.println("File Written..");
        ai.setLog("File Written..", ai.debugTextAreaCZ);
        in.close();
    }

    public void createDeleteApkConfigList() {
        for (String temp : op.deleteApkList) {
            op.deleteApkConfigList = op.deleteApkConfigList + temp + "\n";
            System.out.println(op.deleteApkConfigList);
        }
    }

    public void createDescriptionConfigList() {
        for (String temp : op.descriptionList) {
            op.descriptionConfigList = op.descriptionConfigList + temp + "\n";
            System.out.println(op.descriptionConfigList);
        }
    }

    public String getJarFileName() {
        String path[] = this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().split("!");
        String fileName = path[0].substring(path[0].lastIndexOf("/") + 1, path[0].length());
        //JOptionPane.showMessageDialog(null, fileName);
        return fileName;
    }

    public ArrayList<String> getJarFileList() {
        ArrayList<String> tempArray = new ArrayList<>();
        try {
            try (JarFile jarFile = new JarFile(getJarFileName())) {
                for (Enumeration em = jarFile.entries(); em.hasMoreElements();) {
                    String s = em.nextElement().toString();
                    if (s.startsWith("aroma/installer/META-INF/")) {
                        s = s.substring("aroma/installer/".length(), s.length());
                        if (s.endsWith(".ttf") || s.endsWith(".png") || s.endsWith(".prop") || s.endsWith(".lang") || s.endsWith(".txt") || s.endsWith(".edify") || s.endsWith(".sh") || s.contains("displaycapture") || s.contains("sleep") || s.endsWith(".db")) {
                            tempArray.add(s);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return tempArray;
    }

    public boolean isExecutingJarFile() {
        return this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().contains("!");
    }

    public void createZipAt(String destination) throws IOException {
        System.out.println("Creating zip process started...");
        ai.setLog("Creating zip process started...", ai.debugTextAreaCZ);
        if (isExecutingJarFile()) {
            op.jarFileList = this.getJarFileList();
            System.out.println("Executing Through Jar..!!");
        } else {
            op.jarFileList = op.jarFileList();
            System.out.println("Executing Through Netbeans..!!");
        }
        //this.removeEmptyGroup();
        ai.setLog("All Clear...", ai.runTextAreaCZ);
        ai.setLog("Creating " + op.flashableZipType + " Zip...", ai.runTextAreaCZ);
        System.out.println("Output is set to : " + destination);
        ai.setLog("Output is set to : " + destination, ai.debugTextAreaCZ);
        File fileDest = new File(destination);
        System.out.println("Creating Destination zip file..");
        ai.setLog("Creating Destination zip file", ai.debugTextAreaCZ);
        if (!fileDest.exists()) {
            fileDest.createNewFile();
            System.out.println("File Created..");
        } else {
            fileDest.delete();
            System.out.println("Existing File Deleted..!!");
            fileDest.createNewFile();
            System.out.println("File Created..");
        }
        InputStream in;
        OutputStream out;
        out = new FileOutputStream(fileDest);
        try (ZipOutputStream zos = new ZipOutputStream(out)) {
            if (!op.deleteApkList.isEmpty()) {
                System.out.println("Creating Delete System Apk List..!!");
                ai.setLog("Creating Delete System Apk List..!!", ai.debugTextAreaCZ);
                this.createDeleteApkConfigList();
                in = new ByteArrayInputStream(op.deleteApkConfigList.getBytes());
                this.writeFileToZip(in, zos, "customize/DeleteSystemApps/app-config");
                in.close();
                ai.setLog("Imported System Files To Delete...", ai.runTextAreaCZ);
            } else {
                System.out.println("Delete List Empty..!!");
            }
            if (!op.descriptionList.isEmpty()) {
                System.out.println("Creating Description List..!!");
                ai.setLog("Creating Description List..!!", ai.debugTextAreaCZ);
                this.createDescriptionConfigList();
                in = new ByteArrayInputStream(op.descriptionConfigList.getBytes());
                this.writeFileToZip(in, zos, "customize/File Description/desc-config");
                in.close();
                ai.setLog("Imported Description of files...", ai.runTextAreaCZ);
            } else {
                System.out.println("Description List Empty..!!");
            }
            ai.setLog("Writing Zip at specified destination...", ai.runTextAreaCZ);
            progress += 20;
            //Write Apk, Zip, etc files to ZIP..
            ju.setValue(progress);
            ai.setLog("Opening I/O Streams...", ai.runTextAreaCZ);
            ai.setLog("Parsing Zip Data...", ai.runTextAreaCZ);

            for (String groupName : op.groupArrayList) {
                System.out.println("Writing " + groupName + " Group to zip");
                ai.setLog("Writing " + groupName + " Group to zip", ai.debugTextAreaCZ);
                if (op.map.containsKey(groupName)) {
                    for (String file : op.returnPathArray(groupName, op.map)) {
                        System.out.println("Creating Stream.. ");
                        in = new FileInputStream(new File(file));
                        System.out.println("Stream Created.. " + in);
                        file = op.getNameFromPath(file);
                        file = "customize/" + op.getListName(groupName) + "/" + groupName + "/" + file;
                        System.out.println("Adding " + file + " to Group " + groupName);
                        ai.setLog("Adding " + file + " to Group " + groupName, ai.debugTextAreaCZ);
                        this.writeFileToZip(in, zos, file);
                        in.close();
                        ai.setLog(op.getNameFromPath(file) + " Imported...", ai.runTextAreaCZ);
                        progress += 1;
                        ju.setValue(progress);
                    }
                    progress += 17;
                    ju.setValue(progress);
                } else {
                    JOptionPane.showMessageDialog(null, "Removed Empty Group : " + groupName);
                }
            }
            if (!op.selectedDevice.equals("")) {
                in = this.getClass().getResourceAsStream("META-INF/com/google/android/binary files/" + op.selectedDevice);//+ "_update-binary");
            } else {
                in = new FileInputStream(new File(op.updateBinaryPath));
            }
            ai.setLog("Creating Config Files....", ai.runTextAreaCZ);
            progress = 90;
            ju.setValue(progress);
            switch (op.flashableZipType) {
                case "Create Flashable Zip With Aroma Installer":
                    System.out.println("Writing update-binary-installer to zip..");
                    ai.setLog("Writing update-binary-installer to zip", ai.debugTextAreaCZ);
                    this.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary-installer");
                    in.close();
                    System.out.println("Themes Path is : " + op.themesPath);
                    if (!op.themesPath.equals("")) {
                        for (String themeFile : op.getThemeFilesList(op.themesPath)) {
                            System.out.println("ThemeFile is : " + themeFile);
                            in = new FileInputStream(themeFile);
                            this.writeFileToZip(in, zos, "META-INF/com/google/android/aroma/themes/" + new File(op.themesPath).getName() + "/" + new File(themeFile).getName());
                            in.close();
                        }
                    }
                    System.out.println("Adding Aroma files from jar to zip..");
                    ai.setLog("Adding Aroma files from jar to zip..", ai.debugTextAreaCZ);
                    for (String fileName : op.jarFileList) {
                        System.out.println("Currently Adding " + fileName);
                        ai.setLog("Currently Adding", ai.debugTextAreaCZ);
                        in = this.getClass().getResourceAsStream(fileName);
                        this.writeFileToZip(in, zos, fileName);
                        in.close();
                    }
                    if (!op.splashPath.equals("")) {
                        in = new FileInputStream(new File(op.splashPath));
                        this.writeFileToZip(in, zos, "META-INF/com/google/android/aroma/splash/logo.png");
                        System.out.println("Writing Splash Screen to zip..");
                        in.close();
                    }
                    op.createAromaConfigFile();
                    in = new ByteArrayInputStream(op.aroma_config.getBytes());
                    System.out.println("Writing aroma-config to zip..");
                    ai.setLog("Writing aroma-config to zip", ai.debugTextAreaCZ);
                    this.writeFileToZip(in, zos, "META-INF/com/google/android/aroma-config");
                    in.close();
                    System.out.println("Writing update-binary to zip..");
                    ai.setLog("Writing update-binary to zip..", ai.debugTextAreaCZ);
                    in = this.getClass().getResourceAsStream("META-INF/com/google/android/update-binary");
                    this.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary");
                    in.close();
                    progress += 1;
                    ju.setValue(progress);
                    break;
                case "Create Normal Flashable Zip":
                    System.out.println("Writing update-binary to zip..");
                    ai.setLog("Writing update-binary to zip", ai.debugTextAreaCZ);
                    this.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary");
                    in.close();
                    ju.setValue(90);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Something Went Wrong..!! Restart Tool and Try Again..");
            }
            ai.setLog("Nearing Completion....", ai.runTextAreaCZ);
//        in = this.getClass().getResourceAsStream("utils/mount");
//        this.writeFileToZip(in, zos, "utils/mount");
//        in.close();
//        in = this.getClass().getResourceAsStream("utils/umount");
//        this.writeFileToZip(in, zos, "utils/umount");
//        in.close();
            op.createUpdaterScriptFile();
            in = new ByteArrayInputStream(op.updater_script.getBytes());
            ju.setValue(100);
            System.out.println("Writing updater-script to zip..");
            ai.setLog("Writing updater-script to zip..", ai.debugTextAreaCZ);
            this.writeFileToZip(in, zos, "META-INF/com/google/android/updater-script");
            in.close();
            zos.closeEntry();
        }
        out.close();
        ai.setLog("Folder Compressed Successfully....", ai.runTextAreaCZ);
        ai.setLog("Folder Compressed Successfully....", ai.debugTextAreaCZ);
        this.isZipCreated = true;
        System.out.println("Folder successfully compressed");
        ai.setLog("Zip Successfully Created....", ai.runTextAreaCZ);
        ai.setLog("Zip Successfully Created....", ai.debugTextAreaCZ);
    }

    @Override
    public void done() {
        Toolkit.getDefaultToolkit().beep();
        ai.CZPanel.setCursor(Cursor.getDefaultCursor());
        //setCursor(null); //turn off the wait cursor
        if (isZipCreated) {
            ai.runTextAreaCZ.append("Done!\n");
            this.close = true;
            ai.dialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Zip Successfully Created...!!!");
            ai.dialog.dispose();
        }

    }
}
