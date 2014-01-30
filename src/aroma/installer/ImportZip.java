/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author rajat
 */
public class ImportZip extends SwingWorker<Void,Void>{
    ProgressBarUpdater ju;
    Operations op;
    AromaInstaller ai;
    boolean close;

    ImportZip(AromaInstaller aThis, Operations op) {
        this.ai = aThis;
        this.op = op;
        this.close = false;
    }
    
    public void ImportZip(AromaInstaller ai, Operations op){
        
    }
    
    @Override
        public Void doInBackground() throws IOException { 
            ju = new ProgressBarUpdater(ai.progressImportZip);
            new java.lang.Thread(ju).start();
            int progress = 0;
            progress += 5;
            ju.setValue(progress);
            ai.textFieldSelectZip.setText(op.existingZipPath);
            MultiValueMap mvm  = this.extractTheZip(op.existingZipPath);
            System.out.println("Map Before : "+op.map);
            ai.groupModel.clear();
            op.map.putAll(mvm);       
            op.groupArrayList.addAll(op.getGroupListFromMVM(mvm));
            System.out.println("Updated GroupList : "+op.groupArrayList);
            System.out.println("Updated Map : "+op.map);
            for(String element : op.groupArrayList){
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
                    case "Kernel":
                        op.kernelList.add(element);
                        break;
                }
            }
            ai.refreshGroupList("APKs Group");
            //ju.setValue(100);
            return null;
        }

        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            ai.btnBrowseZip.setEnabled(true);
            this.close = true;
            //setCursor(null); //turn off the wait cursor
            //setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ai.textAreaImportZipLog.append("Done!\n");
            ai.frame.setVisible(false);
            JOptionPane.showMessageDialog(null, "Zip Import Successful");
            ai.frame.dispose();
        }
        
        public MultiValueMap extractTheZip (String source) throws IOException{ 
            int progressValue = 20;
            ai.setLog("Extracting File from given Location...", ai.textAreaImportZipLog);
            byte[] buffer = new byte[1024];
            MultiValueMap mvm = new MultiValueMap();
            try{
                File folder = new File("Temp");
                if(!folder.exists()){
                    folder.mkdir();
                }
                ju.setValue(progressValue);
                ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry ze = zis.getNextEntry();
                progressValue += 2;
                ai.setLog("Extracting Data...", ai.textAreaImportZipLog);
                ju.setValue(progressValue);
                while(ze!=null){
                    String fileName = ze.getName();
                    if(fileName.equals(op.appConfigPath)){
                        op.deleteApkList = op.getArrayListFromFileInZip(zis);
                    }
                    File newFile = new File("Temp" + File.separator + fileName);
                    String filePath = ze.getName();
                    ai.setLog(filePath, ai.textAreaImportZipLog);
                    new File(newFile.getParent()).mkdirs();
                    FileOutputStream fos = new FileOutputStream(newFile);             
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    if(filePath.startsWith("customize/")){
                        String temp = filePath.replace("customize/", "");
                        String splitName[] = temp.split("/");
                        switch (splitName[0]){
                            case "APKs-System":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                            case "APKs-Data":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                            case "Ringtones":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                            case "Notifications":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                            case "BootAnimations":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                            case "Kernels":
                                mvm.put(splitName[1],newFile.getAbsolutePath());
                                break;
                        }
                    }
                    ze = zis.getNextEntry();
                    progressValue += 1;
                    ju.setValue(progressValue);
                }
                zis.closeEntry();
                zis.close();
                ju.setValue(100);
                ai.setLog("Crunching Data for Application.....Hold Tight ;)", ai.textAreaImportZipLog);
                System.out.println("Done");
                //op.zipDestination = source;
                ju.setValue(100);
            }catch(IOException ex){
                ex.printStackTrace(); 
            }
            return mvm;
        }
}
