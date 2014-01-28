/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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

    CreateZip(AromaInstaller aThis, Operations op) {
        this.ai = aThis;
        this.op = op;
        progress = 0;
    }

    public void CreateZip(AromaInstaller ai, Operations op){
        
    }

    @Override
    protected Void doInBackground() throws Exception {
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
    
    public void createZipAt(String destination) throws IOException{
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
                for(String fileName : op.jarFileList()){
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
        //setCursor(null); //turn off the wait cursor
        ai.textAreaCZ.append("Done!\n");
        ai.frame.setVisible(false);
        JOptionPane.showMessageDialog(null, "Zip Successfully Created...!!!");
        ai.frame.dispose();
    }     
}
