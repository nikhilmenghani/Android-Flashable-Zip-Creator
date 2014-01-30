/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

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
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author rajat
 */
public class CreateZip extends SwingWorker<Void,Void>{
    private int progress;
    ProgressBarUpdater ju;
    AromaInstaller ai;
    Operations op;
    boolean close;

    CreateZip(AromaInstaller aThis, Operations op) {
        this.ai = aThis;
        this.op = op;
        progress = 0;
        this.close = false;
    }

    public void CreateZip(AromaInstaller ai, Operations op){
        
    }

    @Override
    protected Void doInBackground() throws Exception {
//        ai.contentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        ju = new ProgressBarUpdater(ai.progressCZ);
        new java.lang.Thread(ju).start();
        createZipAt(op.zipDestination);
        return null;
    }

    
    
    public void removeEmptyGroup(){
        ai.setLog("Checking If Any Group is Empty...", ai.textAreaCZ);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = op.groupArrayList;
        for(String groupName: arrayList){
            System.out.println("Considering " + groupName);
            if(!op.map.containsKey(groupName)){
                this.removeEmptyGroup(groupName);
                System.out.println(groupName + " Removed..!!" + " Now GroupList Contains " + op.groupArrayList);
                //recursion is used here..
                removeEmptyGroup();
                JOptionPane.showMessageDialog(ai, "Removed Empty Group : " + groupName);
                ai.setLog("Removing Empty group " + groupName, ai.textAreaCZ);
            }
            else{
                System.out.println("Nothing to remove..!!");
                continue;
            }
        }
    }
    
    public void removeEmptyGroup(String groupName){
        String str = groupName.substring(0,groupName.indexOf("_"));
        //JOptionPane.showMessageDialog(null, "String is " + str);
        switch(str){
                case "APKs-System":
                    op.systemList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                case "APKs-Data":
                    op.dataList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                case "BootAnimations":
                    op.bootAnimList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                case "Ringtones":
                    op.ringtoneList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                case "Notifications":
                    op.notifList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                case "Kernel":
                    op.kernelList.remove(groupName);
                    op.groupArrayList.remove(groupName);
                    break;
                default:
                System.out.println("Something Went Wrong..!!");
        }
    }
    
    public void createDeleteApkConfigList(){
        for(String temp : op.deleteApkList){
            op.deleteApkConfigList = op.deleteApkConfigList + temp + "\n";
            System.out.println(op.deleteApkConfigList);
        }
    }
    
    public String getJarFileName(){
        String path[] = this.getClass().getResource("utils/mount").getPath().split("!");
        String fileName = path[0].substring(path[0].lastIndexOf("/") + 1, path[0].length());
        //JOptionPane.showMessageDialog(null, fileName);
        return fileName;
    }
    
    public ArrayList<String> getJarFileList(){
        try{
            JarFile jarFile = new JarFile(getJarFileName());
            for(Enumeration em = jarFile.entries(); em.hasMoreElements();) {
                String s= em.nextElement().toString();
                if(s.startsWith("aroma/installer/META-INF/")){
                    s = s.substring("aroma/installer/".length(), s.length());
                    if(s.endsWith(".ttf")||s.endsWith(".png")||s.endsWith(".prop")||s.endsWith(".lang")||s.endsWith(".txt"))
                        op.jarFileList.add(s);
                    }
            }
            jarFile.close();
        }catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return op.jarFileList;
    }
    public boolean isExecutingJarFile(){
        return this.getClass().getResource("utils/mount").getPath().contains("!");
    }
    
    public void createZipAt(String destination) throws IOException{
        if(isExecutingJarFile()){
            op.jarFileList = this.getJarFileList();
        }else{
            op.jarFileList = op.jarFileList();
        }
        this.removeEmptyGroup();
        ai.setLog("All Clear...", ai.textAreaCZ);
        ai.setLog("Creating "+op.flashableZipType+" Zip...", ai.textAreaCZ);
        File fileDest = new File(destination);
        System.out.println("Entered Create Zip");
        if(!fileDest.exists()){
            fileDest.createNewFile();
            System.out.println("File Created");
        }
        InputStream in;
        OutputStream out;
        out = new FileOutputStream(fileDest);
        ZipOutputStream zos = new ZipOutputStream(out);
        System.out.println("Output To : " + destination);
        if(!op.deleteApkList.isEmpty()){
                System.out.println("Delete List Not Empty..!!");
                this.createDeleteApkConfigList();
                in = new ByteArrayInputStream(op.deleteApkConfigList.getBytes());
                op.writeFileToZip(in, zos, "customize/DeleteSystemApps/app-config");
                ai.setLog("Imported System Files To Delete...", ai.textAreaCZ);
            }else{
                System.out.println("Delete List Empty..!!");
            }
        ai.setLog("Writing Zip at specified destination...", ai.textAreaCZ);
        progress += 20;
        //Write Apk, Zip, etc files to ZIP..
        ju.setValue(progress);
        ai.setLog("Opening I/O Streams...", ai.textAreaCZ);
        ai.setLog("Parsing Zip Data...", ai.textAreaCZ);
        
        for(String groupName: op.groupArrayList){
            System.out.println("Now Group under consideration is : " + groupName);
            if(op.map.containsKey(groupName)){
                for(String file: op.returnPathArray(groupName, op.map)){
                    System.out.println("Group Name : " +groupName + " File Name : " + file);
                    in = new FileInputStream(new File(file));
                    file = op.getNameFromPath(file);
                    file = "customize/" + op.getListName(groupName) + "/" + groupName + "/" + file;
                    op.writeFileToZip(in, zos, file);
                    ai.setLog(op.getNameFromPath(file) + " Imported...", ai.textAreaCZ);
                    progress += 1;
                }
                progress += 17;
                ju.setValue(progress);
            }
            else{
                JOptionPane.showMessageDialog(null, "Removed Empty Group : " + groupName);
            }
        }
        if(!op.selectedDevice.equals("")){
            in = this.getClass().getResourceAsStream("META-INF/com/google/android/binary files/" + op.selectedDevice + "_update-binary");
        }
        else{
            in = new FileInputStream(new File(op.updateBinaryPath));
        }
        ai.setLog("Creating Config Files....", ai.textAreaCZ);
        progress = 90;
        ju.setValue(progress);
        switch(op.flashableZipType){
            case "Create Flashable Zip With Aroma Installer":
                op.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary-installer");
                for(String fileName : op.jarFileList){
                    System.out.println("File Name : " + fileName);
                    in = this.getClass().getResourceAsStream(fileName);
                    op.writeFileToZip(in, zos, fileName);
                }
                op.createAromaConfigFile();
                in = new ByteArrayInputStream(op.aroma_config.getBytes());
                op.writeFileToZip(in, zos, "META-INF/com/google/android/aroma-config");
                in = this.getClass().getResourceAsStream("META-INF/com/google/android/update-binary");
                op.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary");
                progress += 1;
                ju.setValue(progress);
                break;
            case "Create Normal Flashable Zip":
                op.writeFileToZip(in, zos, "META-INF/com/google/android/update-binary");
                ju.setValue(90);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Something Went Wrong..!! Restart Tool and Try Again..");
        }
        ai.setLog("Nearing Completion....", ai.textAreaCZ);
        in = this.getClass().getResourceAsStream("utils/mount");
        op.writeFileToZip(in, zos, "utils/mount");
        in = this.getClass().getResourceAsStream("utils/umount");
        op.writeFileToZip(in, zos, "utils/umount");
        op.createUpdaterScriptFile();
        in = new ByteArrayInputStream(op.updater_script.getBytes());
        ju.setValue(100);
        op.writeFileToZip(in, zos, "META-INF/com/google/android/updater-script");
        zos.closeEntry();
        zos.close();
        ai.setLog("Folder Compressed Successfully....", ai.textAreaCZ);
        System.out.println("Folder successfully compressed");
        ai.setLog("Zip Successfully Created....", ai.textAreaCZ);
    }

    @Override
    public void done() {
        Toolkit.getDefaultToolkit().beep();
        ai.CZ_Panel.setCursor(Cursor.getDefaultCursor());
        //setCursor(null); //turn off the wait cursor
        ai.textAreaCZ.append("Done!\n");
        this.close = true;
        ai.frame.setVisible(false);
        JOptionPane.showMessageDialog(null, "Zip Successfully Created...!!!");
        ai.frame.dispose();
    }     
}
