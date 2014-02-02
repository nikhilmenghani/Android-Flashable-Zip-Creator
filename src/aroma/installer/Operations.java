/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.apache.commons.collections4.map.MultiValueMap;
/**
 *
 * @author Nikhil
 * @author Rajat
 */
public class Operations {
    
    int setProgress = 0;
    
    String lastActionCommand = "";
    String updateBinaryPath = "";
    String zipDestination = "";
    String tempFolderPath = "";
    String selectedDevice = "";
    String selectedDeviceName = "";
    String aroma_config = "";
    String updater_script = "";
    String flashableZipType = "";
    String jarFileName = "";
    String existingZipPath = "";
    String deleteApkConfigList = "";
    String appConfigPath = "customize/DeleteSystemApps/app-config";
    String kernelMountPoint = "";
    
    double progress = 0.0;
    
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
    
    public String getKernelMountPoint(){
        try {
            InputStream is;
            BufferedReader br;
            is = this.getClass().getResourceAsStream("META-INF/com/google/android/mount-points/" + this.selectedDevice );//+ "_mountpoint");
            br = new BufferedReader(new InputStreamReader(is));
            String mp = br.readLine();
            br.close();
            is.close();
            System.out.println("Returning mount point : " + mp);
            return mp;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String removeExtension(String str){
        String tempString[] = str.split("\\.");
        for(int i = 1; i < tempString.length - 1 ; i++){
            tempString[0] = tempString[0] + "." + tempString[i];
        }
        return tempString[0];
    }
    
//    public double addProgressFraction(){
//        try{
//            progress += 0.01*(90/this.map.totalSize());
//            return progress;
//        }
//        catch(NullPointerException npe){
//            return 0;
//        }
//    }
    
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
                this.aroma_config += "" + listType + "(\" " + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                this.aroma_config += ",\n\"" + "Delete System Apks" + "\", \"\", 2";
                for(String list : arrayList){
                        this.aroma_config += ",\n\"" + list + "\", \"\", 0";
                }
                this.aroma_config += ");\n";
            }
            else{
                this.aroma_config += "" + listType + "(\" " + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                for(String list : arrayList){
                    if(map.containsKey(list)){
                        this.aroma_config += ",\n\"" + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\", \"\", 2";
                        for(String list_files : this.returnPathArray(list, map)){
                            this.aroma_config += ",\n\"" + this.removeExtension(getNameFromPath(list_files)) + "\", \"\", 0";
                        }
                    }
                }
                this.aroma_config += ");\n";
            }            
        }else if(listType.equals("selectbox")&&!arrayList.isEmpty()){
            this.aroma_config += "" + listType + "(\" " + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
            switch (propFile) {
                case "boot_anim_choices.prop":
                    this.aroma_config += ",\n\"" + "Select one Boot Animation" + "\", \"\", 2";
                    break;
                case "kernel_choices.prop":
                    this.aroma_config += ",\n\"" + "Select one kernel" + "\", \"\", 2";
                    break;
            }
            for(String list : arrayList){
                this.aroma_config += ",\n\"" + list.substring(list.lastIndexOf("_")+1,list.length()) + "\", \"\", 0";
            }
            this.aroma_config += ");\n";
        }
    }
    
    public void createAromaConfigFile(){
        this.aroma_config = "fontresload(\"0\", \"ttf/Roboto-Regular.ttf\", \"12\");\n" +
                "fontresload(\"1\", \"ttf/Roboto-Regular.ttf\", \"18\");\n" +
                "theme(\"miui4\");\n";
        
        this.aroma_config += "agreebox(\"Important notes!\", \"Terms & Conditions\", \"@alert\",resread(\"Terms and Conditions.txt\"), \"I agree with these Terms of Use...\", \"You need to agree with the Terms of Use...\");\n";
        
        displayListInAroma("checkbox", "App List" , "Choose the apps to be installed to data", "personalize", "app_choices.prop", this.dataList);
        
        displayListInAroma("checkbox", "System App List" , "Choose the apps to be installed to system", "personalize", "system_app_choices.prop", this.systemList);
        
        displayListInAroma("selectbox", "Boot Animations List" , "Select Boot Animation to be used in current ROM", "personalize", "boot_anim_choices.prop", this.bootAnimList);
        
        displayListInAroma("selectbox", "Kernel List" , "Select Kernel to be flashed", "personalize", "kernel_choices.prop", this.kernelList);
        
        displayListInAroma("checkbox", "Ringtone List" , "Choose Ringtones to include in Rom", "personalize", "ringtone_choices.prop", this.ringtoneList);
        
        displayListInAroma("checkbox", "Notification List" , "Choose Notification Tones to include in Rom", "personalize", "notification_choices.prop", this.notifList);
        
        displayListInAroma("checkbox", "Remove System Apps List", "Choose Apps To Remove", "personalize", "delete_choices.prop", this.deleteApkList);
        
        if(!dataList.isEmpty())
        this.aroma_config += "writetmpfile(\"app_choices.prop\",readtmpfile(\"app_choices.prop\"));\n";
        if(!systemList.isEmpty())
        this.aroma_config += "writetmpfile(\"system_app_choices.prop\",readtmpfile(\"system_app_choices.prop\"));\n";
        if(!bootAnimList.isEmpty())
        this.aroma_config += "writetmpfile(\"boot_anim_choices.prop\",readtmpfile(\"boot_anim_choices.prop\"));\n";
        if(!kernelList.isEmpty())
        this.aroma_config += "writetmpfile(\"kernel_choices.prop\",readtmpfile(\"kernel_choices.prop\"));\n";
        if(!ringtoneList.isEmpty())
        this.aroma_config += "writetmpfile(\"ringtone_choices.prop\",readtmpfile(\"ringtone_choices.prop\"));\n";
        if(!notifList.isEmpty())
        this.aroma_config += "writetmpfile(\"notification_choices.prop\",readtmpfile(\"notification_choices.prop\"));\n";
        if(!deleteApkList.isEmpty())
        this.aroma_config += "writetmpfile(\"delete_choices.prop\",readtmpfile(\"delete_choices.prop\"));\n";
        
        this.aroma_config += "writetmpfile(\"dalvik_choices.prop\",\"init=no\\n\");\n";
        this.aroma_config += "checkviewbox(\n"+"\"Ready to Install\",\n" +
                "    \"The wizard is ready to begin installation.\\n\\n\"+\n" +
                "	\"Press <b>Next</b> to begin the installation.\\n\\n\"+\n" +
                "	\"If you want to review or change any of your installation settings, press <b>Back</b>. Press Left Hard Button -> Quit Installation to exit the wizard.\\n\\n\\n\\n\\n\\n\\n\",\n" +
                "    \"@install\",\n" +
                "\"<b>Clear Dalvik Cache</b> After Installation.\",\n" +
                "\"0\",\n" +
                "\"clear_it\"" +
                ");\n";
        
        this.aroma_config += "if\n" +
                "  getvar(\"clear_it\")==\"1\"\n" +
                "then\n" +
                "  writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n" +
                "endif;";
        
        //this.aroma_config += "if confirm(\"Wipe cache partition\",\"Do you want to clear dalvik cache after installation?\", \"@confirm\")==\"yes\" then writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n\nendif;\n";
        //this.aroma_config += "if confirm(\"Installing\",getvar(\"installer_title\") + \"\\n\\nStart Installation?\", \"@confirm\")==\"no\" then back(1);\nendif;\n";
        this.aroma_config += "install(\"Installing\", \"Your selected files are being installed. Please Wait...\", \"@install\");\n";
        
    }
    
    public void extractFilesUpdaterScript(ArrayList<String> arrayList, String title, String propFile, String location){
        if(!arrayList.isEmpty()){
            this.updater_script += "ui_print(\"@" + title + "\");\n";
            int s = 1;
            for(String list : arrayList){
                if(map.containsKey(list)){
                    int i = 1;
                    for(String system_list_files : this.returnPathArray(list, map)){
                        switch(this.flashableZipType){
                            case "Create Flashable Zip With Aroma Installer":
                            switch (propFile) {
                                case "kernel_choices.prop":
                                    this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then ui_print(\"Flashing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                    //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                    this.updater_script += "assert(package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\"));\n";
                                    break;
                                case "boot_anim_choices.prop":
                                    this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then ui_print(\"Installing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                    //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                    this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                    break;
                                default:
                                    this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"item." + s + "." + i + "\")==\"1\") then ui_print(\"Installing " + this.removeExtension(getNameFromPath(system_list_files)) + "\");\n";
                                    //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                    this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                    break;
                            }
                            this.updater_script += "endif;\n";
                            i++;
                            break;
                            case "Create Normal Flashable Zip":
                                if(i == 1 && s == 1){
                                    switch (propFile) {
                                        case "kernel_choices.prop":
                                            this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                            //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                            break;
                                        case "boot_anim_choices.prop":
                                            this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                            //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                            break;
                                        default:
                                            this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                            //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                            break;
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
                //"package_extract_file(\"utils/mount\", \"/tmp/mount\");\n" +
                //"set_perm(0, 0, 0755, \"/tmp/mount\");\n" +
                "ui_print(\"Mounting Partitions...\");\n" +
                "ui_print(\" \");\n" +
                "run_program(\"/sbin/busybox\",\"mount\", \"/system\");\n" +
                "run_program(\"/sbin/busybox\",\"mount\", \"/data\");\n";
        //this.progress = 0.0;
        extractFilesUpdaterScript(this.systemList, "Installing System Apps", "system_app_choices.prop", "/system/app");
        this.updater_script += "\nset_progress(0.3);\n";
        extractFilesUpdaterScript(this.dataList, "Installing Apps", "app_choices.prop", "/data/app");
        this.updater_script += "\nset_progress(0.5);\n";
        extractFilesUpdaterScript(this.bootAnimList, "Installing Boot Animation", "boot_anim_choices.prop", "/data/local/bootanimation.zip");
        this.updater_script += "\nset_progress(0.6);\n";
        extractFilesUpdaterScript(this.kernelList, "Flashing Kernel", "kernel_choices.prop", this.kernelMountPoint);// + "/boot.img");
        this.updater_script += "\nset_progress(0.7);\n";
        extractFilesUpdaterScript(this.ringtoneList, "Adding Ringtones", "ringtone_choices.prop", "/system/media/audio/ringtones");
        this.updater_script += "\nset_progress(0.8);\n";
        extractFilesUpdaterScript(this.notifList, "Adding Notification Tones", "notification_choices.prop", "/system/media/audio/notifications");
        this.updater_script += "\nset_progress(0.9);\n";
        if(!deleteApkList.isEmpty()){
            int j = 1;
            this.updater_script += "ui_print(\"@" + "Deleting System Apps" + "\");\n";
            for(String appName : deleteApkList){
                this.updater_script += "if (file_getprop(\"/tmp/aroma/" + "delete_choices.prop" + "\", \"item.1." + j + "\")==\"1\") then ui_print(\"Deleting " + appName + "\");\n";
                this.updater_script += " \n" + "delete(\"/system/app/" + appName + "\");\n";
                this.updater_script += "endif;\n";
                j++;
            }
        }
        
        if(!systemList.isEmpty()){
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/app\");\n";
        }
        
        if(!dataList.isEmpty()){
            this.updater_script += "set_perm_recursive(1000, 1000, 0771, 0644, \"/data/app\");\n";
        }
        
        if(!bootAnimList.isEmpty()){
            this.updater_script += "set_perm_recursive(1000, 1000, 0751, 0664, \"/data/local\");\n";
        }
        
        if(!ringtoneList.isEmpty()||!notifList.isEmpty()){
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/media\");\n";
        }
        
        if(this.flashableZipType.equals("Create Flashable Zip With Aroma Installer")){
            this.updater_script += "\nif(file_getprop(\"/tmp/aroma/dalvik_choices.prop\", \"true\")==\"yes\") then\n" +
                    "ui_print(\"@Wiping dalvik-cache\");\n" +
                    "delete_recursive(\"/data/dalvik-cache\");\n" +
                    "endif;\n";
        }
        
        this.updater_script += "unmount(\"/data\");\n";
        this.updater_script += "unmount(\"/system\");\n";
        this.updater_script += "ui_print(\"@Finished Install\");\n";
        this.updater_script += "set_progress(1);\n";
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
        ArrayList<String> list = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            if(key.equals(mapEntry.getKey())){
                list = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for(String path: list){
                    if(path.contains(name)){
                        return path;
                    }
                }
            }
        }
        return "";
    }
    
    public void updateFileListWithSelectedGroupList(String str, DefaultListModel model, MultiValueMap mvm){
        if(this.groupArrayList.contains(str)){
            model.removeAllElements();
        }
        ArrayList<String> list = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            if(str.equals(mapEntry.getKey())){
                list = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("Testing.. "+getNameFromPath(list.get(j)));
                    System.out.println("\t" + mapEntry.getKey() + "\t  " + getNameFromPath(list.get(j)));
                    model.addElement(getNameFromPath(list.get(j)));
                }
            }
        }
    }
    
    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList, DefaultListModel fileModel, String type){        
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] file = fileChooser.getSelectedFiles();
            for (File fileName : file) {
                if (this.map.containsValue(type + "_" + groupList.getSelectedValue(),fileName.getAbsolutePath())||fileModel.contains(fileName.getName())) {
                    JOptionPane.showMessageDialog(null, "File with the same name already exists\nPlease rename the file before importing or make another group and import it.");
                } else {
                    this.map.put(type+"_"+groupList.getSelectedValue(), fileName.getAbsolutePath());
                    System.out.println(fileName.getAbsolutePath());
                }
            }
            fileModel.removeAllElements();
            updateFileListWithSelectedGroupList(type+"_"+groupList.getSelectedValue().toString(), fileModel, this.map);
        } else {
        System.out.println("File access cancelled by user.");
        }
    }
    
    
    public void deleteDirectories(String location){
        File directory = new File(location);
        if(!directory.exists()){
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
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("META-INF/com/google/android/aroma/Terms and Conditions.txt");
        tempArray.add("META-INF/com/google/android/aroma/fonts/big.png");
        tempArray.add("META-INF/com/google/android/aroma/fonts/small.png");
        
        tempArray.add("META-INF/com/google/android/aroma/icons/agreement.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/alert.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/apps.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/confirm.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/customize.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/default.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/info.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/install.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/license.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/personalize.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/update.png");
        tempArray.add("META-INF/com/google/android/aroma/icons/welcome.png");
        
        tempArray.add("META-INF/com/google/android/aroma/langs/ar.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/cn.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/de.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/en.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/fr.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/he.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/id.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/it.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/ru.lang");
        tempArray.add("META-INF/com/google/android/aroma/langs/es.lang");
        
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/bg.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/button.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/button_focus.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/button_press.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb_focus.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb_on.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_focus.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_press.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/cb_press.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/dialog.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/dialog_titlebar.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.big.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.small.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.agreement.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.alert.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.apps.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.confirm.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.customize.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.default.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.info.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.install.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.license.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.personalize.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.update.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/icon.welcome.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/list.9.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/navbar.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio_focus.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio_on.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_focus.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_press.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/radio_press.png");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/theme.prop");
        tempArray.add("META-INF/com/google/android/aroma/themes/miui4/titlebar.9.png");
        
        tempArray.add("META-INF/com/google/android/aroma/ttf/DroidSans.ttf");
        tempArray.add("META-INF/com/google/android/aroma/ttf/DroidSansArabic.ttf");
        tempArray.add("META-INF/com/google/android/aroma/ttf/DroidSansFallback.ttf");
        tempArray.add("META-INF/com/google/android/aroma/ttf/Roboto-Regular.ttf");
        return tempArray;
    }
}
