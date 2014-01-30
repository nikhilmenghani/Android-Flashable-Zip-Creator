/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.apache.commons.collections4.map.MultiValueMap;
/**
 *
 * @author Nikhil
 */
public class Operations {
    
    int setProgress = 0;
    
    String lastActionCommand = "";
    String updateBinaryPath = "";
    String zipDestination = "";
    String tempFolderPath = "";
    String selectedDevice = "";
    String aroma_config = "";
    String updater_script = "";
    String flashableZipType = "";
    String jarFileName = "";
    String existingZipPath = "";
    String deleteApkConfigList = "";
    String appConfigPath = "customize/DeleteSystemApps/app-config";
    String kernelMountPoint = "";
    
    ArrayList<String> groupArrayList = new ArrayList<>();
    ArrayList<String> systemList = new ArrayList<>();
    ArrayList<String> dataList = new ArrayList<>();
    ArrayList<String> bootAnimList = new ArrayList<>();
    ArrayList<String> ringtoneList = new ArrayList<>();
    ArrayList<String> notifList = new ArrayList<>();
    ArrayList<String> kernelList = new ArrayList<>();
    ArrayList<String> advancedList = new ArrayList<>();
    ArrayList<String> deleteApkList = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> jarFileList = new ArrayList<>();
    
    Map<String, String> CSDmap;
    
    MultiValueMap map = new MultiValueMap();
    
    Operations(){
        
    }
        
    public int getGroupCount(ArrayList<String> groupType){
        int count = 0;
        for(String temp : groupType){
            count++;
        }
        return count;
    }
    
    public String getListName(String groupName){
        if(this.systemList.contains(groupName)){
            return "APKs-System";
        }
        else if(this.dataList.contains(groupName)){
            return "APKs-Data";
        }
        else if(this.bootAnimList.contains(groupName)){
            return "BootAnimations";
        }
        else if(this.kernelList.contains(groupName)){
            return "Kernels";
        }
        else if(this.ringtoneList.contains(groupName)){
            return "Ringtones";
        }
        else if(this.notifList.contains(groupName)){
            return "Notifications";
        }
        return "";
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
                    if(s.endsWith(".ttf")||s.endsWith(".png")||s.endsWith(".prop")||s.endsWith(".lang"))
                        this.jarFileList.add(s);
                    }
            }
            jarFile.close();
        }catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return this.jarFileList;
    }
    
    public String getKernelMountPoint(){
        try {
            InputStream is = null;
            BufferedReader br;
            is = this.getClass().getResourceAsStream("META-INF/com/google/android/binary files/" + this.selectedDevice + "_mountpoint");
            br = new BufferedReader(new InputStreamReader(is));
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void writeFileToZip(InputStream in, ZipOutputStream zos, String writeAt) throws IOException{
        byte[] buffer = new byte[1024];
        ZipEntry ze = new ZipEntry(writeAt);
        zos.putNextEntry(ze);
        int len;
        while ((len = in.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        in.close();
    }
    
    public String removeExtension(String str){
        String tempString[] = str.split("\\.");
        for(int i = 1; i < tempString.length - 1 ; i++){
            tempString[0] = tempString[0] + "." + tempString[i];
        }
        return tempString[0];
    }
    
    public ArrayList<String> returnPathArray(String str, MultiValueMap mvm){
        if(mvm.containsKey(str)){
            System.out.println("Yes, map contains : " + str + " and proof is : " + mvm);
            Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry mapEntry = (Map.Entry) it.next();
                if(str.equals(mapEntry.getKey())){
                arrayList = (ArrayList<String>) mvm.get(mapEntry.getKey());
                }
            }
        }
        return arrayList;
    }
    
    public void displayListInAroma(String listType, String listGroup, String heading, String themeFormat, String propFile , ArrayList<String> arrayList){
        if(listType.equals("checkbox")&&!arrayList.isEmpty()){
            if(arrayList.equals(deleteApkList)){
                System.out.println("ArrayList is Delete Apk List");
                this.aroma_config = this.aroma_config + "\" " + listType + "(\" " + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                this.aroma_config = this.aroma_config + ",\n\"" + "Delete System Apks" + "\", \"\", 2";
                for(String list : arrayList){
                        this.aroma_config = this.aroma_config + ",\n\"" + list + "\", \"\", 0";
                }
                this.aroma_config = this.aroma_config + ");\n";
            }
            else{
                this.aroma_config = this.aroma_config + heading;
                for(String list : arrayList){
                    if(map.containsKey(list)){
                        this.aroma_config = this.aroma_config + ",\n\"" + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\", \"\", 2";
                        for(String list_files : this.returnPathArray(list, map)){
                            this.aroma_config = this.aroma_config + ",\n\"" + this.removeExtension(getNameFromPath(list_files)) + "\", \"\", 0";
                        }
                    }
                }
                this.aroma_config = this.aroma_config + ");\n";
            }            
        }else if(listType.equals("selectbox")&&!arrayList.isEmpty()){
            this.aroma_config = this.aroma_config + "" + listType + "(\" " + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
            if(propFile.equals("boot_anim_choices.prop")){
                this.aroma_config = this.aroma_config + ",\n\"" + "Select one Boot Animation" + "\", \"\", 2";
            }else if(propFile.equals("kernel_choices.prop")){
                this.aroma_config = this.aroma_config + ",\n\"" + "Select one kernel" + "\", \"\", 2";
            }
            for(String list : arrayList){
                this.aroma_config = this.aroma_config + ",\n\"" + list.substring(list.lastIndexOf("_")+1,list.length()) + "\", \"\", 0";
            }
            this.aroma_config = this.aroma_config + ");\n";
        }

    }
    
    public int listFilesInAromaConfig(ArrayList<String> groupType, String groupName, String propFile, int count, MultiValueMap mvm, String type){
        if(type.equals("selectbox")&&count == 1){
            int i = 1;
            if(groupType.contains(groupName)){
                    for(String file_list: groupType){
                        this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"" + propFile + "\",\"selected.1" + "\")==\""+ i +"\",\"" + file_list.substring(file_list.lastIndexOf("_")+1,file_list.length()) + "\",\"\"));\n";
                        i++;
                    }
                    count++;
                }
        }else if(type.equals("checkbox")){
            int i = 1;
            if(groupType.equals(deleteApkList)&&count == 1){
                for(String file_list: deleteApkList){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"" + propFile + "\",\"item." + count + "." + i + "\")==\"1\",\"" + file_list + "\",\"\"));\n";
                    i++;
                }
                count++;
            }else if(groupType.contains(groupName)){
                    for(String file_list: this.returnPathArray(groupName, mvm)){
                        this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"" + propFile + "\",\"item." + count + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(file_list)) + "\",\"\"));\n";
                        i++;
                    }
                    count++;
            }            
        }
        return count;
    }
    
    public void createAromaConfigFile(){
        this.aroma_config = "fontresload(\"0\", \"ttf/Roboto-Regular.ttf\", \"12\");\n" +
                "fontresload(\"1\", \"ttf/Roboto-Regular.ttf\", \"18\");\n" +
                "theme(\"miui4\");\n";
        
        displayListInAroma("checkbox", "App List" , "Choose the apps to be installed to data", "personalize", "app_choices.prop", this.dataList);
        
        displayListInAroma("checkbox", "System App List" , "Choose the apps to be installed to system", "personalize", "system_app_choices.prop", this.systemList);
        
        displayListInAroma("selectbox", "Boot Animations List" , "Select Boot Animation to be used in current ROM", "personalize", "boot_anim_choices.prop", this.bootAnimList);
        
        displayListInAroma("selectbox", "Kernel List" , "Select Kernel to be flashed", "default", "kernel_choices.prop", this.kernelList);
        
        displayListInAroma("checkbox", "Ringtone List" , "Choose Ringtones to include in Rom", "personalize", "ringtone_choices.prop", this.ringtoneList);
        
        displayListInAroma("checkbox", "Notification List" , "Choose Notification Tones to include in Rom", "personalize", "notification_choices.prop", this.notifList);
        
        displayListInAroma("checkbox", "Remove System Apps List", "Choose Apps To Remove", "personalize", "delete_choices.prop", this.deleteApkList);
        
        this.aroma_config = this.aroma_config + "setvar(\"installer_title\",\"You are about to install the following:\");\n" +
                "appendvar(\"installer_title\",\"\\n\\n\");\n";
        
        int s = 1, d = 1, k = 1, ba = 1, r = 1, n = 1, da = 1;
        
        for(String grouplist : groupArrayList){
            if(map.containsKey(grouplist)){
                s = listFilesInAromaConfig(systemList, grouplist, "system_app_choices.prop", s, map, "checkbox");

                d = listFilesInAromaConfig(dataList, grouplist, "app_choices.prop", d, map, "checkbox");

                ba = listFilesInAromaConfig(bootAnimList, grouplist, "boot_anim_choices.prop", ba, map, "selectbox");

                k = listFilesInAromaConfig(kernelList, grouplist, "kernel_choices.prop", k, map, "selectbox");

                r = listFilesInAromaConfig(ringtoneList, grouplist, "ringtone_choices.prop", r, map, "checkbox");

                n = listFilesInAromaConfig(notifList, grouplist, "notification_choices.prop", n, map, "checkbox");    
            }
            da = listFilesInAromaConfig(deleteApkList, grouplist, "delete_choices.prop", da, map, "checkbox");
        }
        
        if(!dataList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"app_choices.prop\",readtmpfile(\"app_choices.prop\"));\n";
        if(!systemList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"system_app_choices.prop\",readtmpfile(\"system_app_choices.prop\"));\n";
        if(!bootAnimList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"boot_anim_choices.prop\",readtmpfile(\"boot_anim_choices.prop\"));\n";
        if(!kernelList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"kernel_choices.prop\",readtmpfile(\"kernel_choices.prop\"));\n";
        if(!ringtoneList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"ringtone_choices.prop\",readtmpfile(\"ringtone_choices.prop\"));\n";
        if(!notifList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"notification_choices.prop\",readtmpfile(\"notification_choices.prop\"));\n";
        if(!deleteApkList.isEmpty())
        this.aroma_config = this.aroma_config + "writetmpfile(\"delete_choices.prop\",readtmpfile(\"delete_choices.prop\"));\n";
        
        this.aroma_config = this.aroma_config + "writetmpfile(\"dalvik_choices.prop\",\"init=no\\n\");\n";
        this.aroma_config = this.aroma_config + "if confirm(\"Installing\",getvar(\"installer_title\") + \"\\n\\nStart Installation?\", \"@confirm\")==\"no\" then back(1);\nendif;\n";
        this.aroma_config = this.aroma_config + "if confirm(\"Wipe cache partition\",\"Do you want to clear dalvik cache after installation?\", \"@confirm\")==\"yes\" then writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n\nendif;\n";
        this.aroma_config = this.aroma_config + "install(\"Installing\", \"Your selected files are being installed. Please Wait...\", \"@install\");";
    }
    
    public void extractFilesUpdaterScript(ArrayList<String> arrayList, String title, String propFile, String location){
        if(!arrayList.isEmpty()){
            this.updater_script = this.updater_script + "ui_print(\"@" + title + "\");\n";
            int s = 1;
            for(String list : arrayList){
                if(map.containsKey(list)){
                    int i = 1;
                    for(String system_list_files : this.returnPathArray(list, map)){
                        switch(this.flashableZipType){
                            case "Create Flashable Zip With Aroma Installer":
                                if(propFile == "kernel_choices.prop"){
                                    this.updater_script = this.updater_script + "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then ui_print(\"Flashing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                    this.updater_script = this.updater_script + "assert(package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\"));\n";
                                }else if(propFile == "boot_anim_choices.prop"){
                                    this.updater_script = this.updater_script + "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then ui_print(\"Installing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                    this.updater_script = this.updater_script + "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                } else{
                                    this.updater_script = this.updater_script + "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"item." + s + "." + i + "\")==\"1\") then ui_print(\"Installing " + this.removeExtension(getNameFromPath(system_list_files)) + "\");\n";
                                    this.updater_script = this.updater_script + "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                }
                                this.updater_script = this.updater_script + "endif;\n";
                                i++;
                                break;
                            case "Create Normal Flashable Zip":
                                if(i == 1 && s == 1){
                                    if(propFile == "kernel_choices.prop"){
                                        this.updater_script = this.updater_script + "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                    }else if(propFile == "boot_anim_choices.prop"){
                                        this.updater_script = this.updater_script + "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                    } else{
                                        this.updater_script = this.updater_script + "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                    }
                                }
                                i++;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Something Went Wrong..!! Restart Tool and Try Again..");
                        }
                    }
                    s++;
                }
            }
        }
    }
    
    public void createUpdaterScriptFile() throws FileNotFoundException, IOException{
        this.updater_script = "ui_print(\"@Starting the install process\");\n" +
                "ui_print(\"Setting up required tools...\");\n" +
                "package_extract_file(\"utils/mount\", \"/tmp/mount\");\n" +
                "set_perm(0, 0, 0755, \"/tmp/mount\");\n" +
                "ui_print(\"Mounting...\");\n" +
                "ui_print(\" \");\n" +
                "run_program(\"/tmp/mount\", \"/data\");\n" +
                "run_program(\"/tmp/mount\", \"/system\");\n";
        
        extractFilesUpdaterScript(this.systemList, "Installing System Apps", "system_app_choices.prop", "/system/app");
        
        extractFilesUpdaterScript(this.dataList, "Installing Apps", "app_choices.prop", "/data/app");
        
        extractFilesUpdaterScript(this.bootAnimList, "Installing Boot Animation", "boot_anim_choices.prop", "/data/local/bootanimation.zip");
        
        extractFilesUpdaterScript(this.kernelList, "Flashing Kernel", "kernel_choices.prop", this.kernelMountPoint);// + "/boot.img");
        
        extractFilesUpdaterScript(this.ringtoneList, "Adding Ringtones", "ringtone_choices.prop", "/system/media/audio/ringtones");
        
        extractFilesUpdaterScript(this.notifList, "Adding Notification Tones", "notification_choices.prop", "/system/media/audio/notifications");
        
        if(!deleteApkList.isEmpty()){
            for(String appName : deleteApkList){
                this.updater_script = this.updater_script + " \n" + "delete(\"/system/app/" + appName + "\");\n";
            }
        }
        
        if(!systemList.isEmpty()){
            this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/app\");\n";
        }
        
        if(!dataList.isEmpty()){
            this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0771, 0644, \"/data/app\");\n";
        }
        
        if(!bootAnimList.isEmpty()){
            this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0751, 0664, \"/data/local\");\n";
        }
        
        if(!ringtoneList.isEmpty()||!notifList.isEmpty()){
            this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/media\");\n";
        }
        
        if(this.flashableZipType.equals("Create Flashable Zip With Aroma Installer")){
            this.updater_script = this.updater_script + "\nif(file_getprop(\"/tmp/aroma/dalvik_choices.prop\", \"true\")==\"yes\") then\n" +
                "ui_print(\"@Wiping dalvik-cache\");" +
                "delete_recursive(\"/data/dalvik-cache\");\nendif;\n";
        }
        
        this.updater_script = this.updater_script + "unmount(\"/data\");\n";
        this.updater_script = this.updater_script + "unmount(\"/system\");\n";
        this.updater_script = this.updater_script + "ui_print(\"@Finished Install\");\n";
        this.updater_script = this.updater_script + "set_progress(1);\n";
    }
   
    public void fillListModelWithArrayList(DefaultListModel model, ArrayList<String> list, String listType){
        for(String temp : list){
            String finalStr = temp.replace(listType+"_", "");
            if(!model.contains(finalStr)){
                model.addElement(finalStr);
            }
        }
    }
    
    public String getNameFromPath(String str){
        String[] tempString;
        if(str.contains("\\")){
            tempString = str.split("\\\\");
        }else{
            tempString = str.split("/");
        }
        System.out.println("Successfully Splitted from " + str + " to " + tempString[tempString.length-1]);
        return tempString[tempString.length-1];
    }
    
    public String getFilePath(String key, String name, MultiValueMap mvm){
        ArrayList<String> arrayList = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            if(key.equals(mapEntry.getKey())){
                arrayList = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for(String path: arrayList){
                    if(path.contains(name)){
                        return path;
                    }
                }
            }
        }
        return "";
    }
    
    public void updateFileListWithSelectedGroupList(String str, DefaultListModel model, MultiValueMap mvm){
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
    
    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList, DefaultListModel fileModel, String type){        
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] file = fileChooser.getSelectedFiles();
            for(int i=0; i<file.length; i++){
                if(this.map.containsValue(file[i].getAbsolutePath())){
                    JOptionPane.showMessageDialog(null, "File with the same name already exists\nPlease rename the file before importing or make another group and import it.");
                }else{
                    this.map.put(type+"_"+groupList.getSelectedValue(), file[i].getAbsolutePath());
                    System.out.println(file[i].getAbsolutePath());
                }
            }
            fileModel.removeAllElements();
            updateFileListWithSelectedGroupList(type+"_"+groupList.getSelectedValue().toString(), fileModel, this.map);
        } else {
        System.out.println("File access cancelled by user.");
        }
    }
    
    public ArrayList<String> getArrayListFromFileInZip(ZipInputStream zis) throws UnsupportedEncodingException{
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(zis, "UTF-8"));
        try {
            while (br.ready()) {
            str += (char) br.read();
            }
            System.out.println("String is " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String array[] = str.split("\n");
        for(int i =0;i < array.length ; i++){
            list.add(array[i]);
        }
        System.out.println("ArrayList obtained is : " + list);
        return list;
    }
    
    //The following function will extract the whole zip file and return a multivaluemap which contains Group Name as a key and file name as its values
    public MultiValueMap extractTheZip (String source) throws IOException{ 
        byte[] buffer = new byte[1024];
        MultiValueMap mvm = new MultiValueMap();
        try{
            File folder = new File("Temp");
            if(!folder.exists()){
                folder.mkdir();
            }
            ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
            ZipEntry ze = zis.getNextEntry();
            while(ze!=null){
                String fileName = ze.getName();
                File newFile = new File("Temp" + File.separator + fileName);
                String filePath = ze.getName();
                System.out.println(filePath);
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
                    }
                }
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        }catch(IOException ex){
            ex.printStackTrace(); 
        }
        return mvm;
    }
    
    public ArrayList<String> getGroupListFromMVM(MultiValueMap mvm){
        ArrayList<String> arrayList = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            arrayList.add(mapEntry.getKey().toString());
        }
        return arrayList;
    }
    
    public void deleteDirectories(String location){
        File directory = new File(location);
        if(!directory.exists()){
            //JOptionPane.showMessageDialog(null, "Directory does not exist!!");
            System.out.println("Directory Doesn't Exist..!!");
        }
        else{
            this.delete(directory);
        }
    }
    
    public void delete(File file){
        if(file.isDirectory()){
            if(file.list().length == 0){
                file.delete();
                System.out.println("Directory Deleted.. " + file.getAbsolutePath());
            }
            else{
                String files[] = file.list();
                
                for(String temp : files){
                    File fileDelete = new File(file, temp);
                    delete(fileDelete);
                }
                
                if(file.list().length == 0){
                    file.delete();
                    System.out.println("Directory is deleted : " + file.getAbsolutePath());
                }
            }
        }
        else{
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }
    //This function will not be needed once final product is ready.
    
    public ArrayList<String> jarFileList() throws IOException{
        this.jarFileList.add("META-INF/com/google/android/aroma/fonts/big.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/fonts/small.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/agreement.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/alert.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/apps.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/confirm.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/customize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/default.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/info.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/install.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/license.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/personalize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/update.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/welcome.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/ar.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/cn.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/de.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/en.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/fr.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/he.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/id.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/it.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/ru.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/es.lang");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/bg.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button_focus.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button_press.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/dialog.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/dialog_titlebar.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.big.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.small.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.agreement.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.alert.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.apps.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.confirm.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.customize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.default.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.info.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.install.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.license.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.personalize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.update.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.welcome.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/list.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/navbar.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/theme.prop");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/titlebar.9.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSans.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSansArabic.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSansFallback.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/Roboto-Regular.ttf");
        return this.jarFileList;
    }
}
