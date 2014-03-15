/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;
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
public final class Operations {

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
    String descriptionConfigList = "";
    String appConfigPath = "customize/Config-Files/app-config";
    String descConfigPath = "customize/Config-Files/desc-config";
    //String themeConfigPath = "customize/Config-Files/theme-config";
    String themesPath = "";
    String splashPath = "";
    String kernelMountPoint = "";
    String projectPath = "";
    String projectData = "";
    String buildPropPath = "";
    String buildPropData = "";
    String hostsFilePath = "";
    String hostsFileData = "";
    String lastModified = "";
    Boolean isUpdaterScriptModified = false;
    Boolean isAromaConfigModified = false;
    Boolean isBuildPropModified = false;
    Boolean isHostsFileModified = false;
    Boolean checkDalvikCache = false;

    double progress = 0.0;

    ArrayList<String> groupArrayList = new ArrayList<>();
    ArrayList<String> systemList = new ArrayList<>();
    ArrayList<String> dataList = new ArrayList<>();
    ArrayList<String> privAppList = new ArrayList();
    ArrayList<String> bootAnimList = new ArrayList<>();
    ArrayList<String> ringtoneList = new ArrayList<>();
    ArrayList<String> notifList = new ArrayList<>();
    ArrayList<String> kernelList = new ArrayList<>();
    ArrayList<String> advancedList = new ArrayList<>();
    ArrayList<String> fontsList = new ArrayList<>();
    ArrayList<String> deleteApkList = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> jarFileList = new ArrayList<>();

    ArrayList<String> descriptionList = new ArrayList<>();
    ArrayList<String> themesList = new ArrayList<>();
    ArrayList<String> customThemeList = new ArrayList<>();
    ArrayList<String> nonNeonList = new ArrayList<>();
    ArrayList<String> otherFileList = new ArrayList<>();

    Map<String, String> CSDmap;

    MultiValueMap map = new MultiValueMap();

    Operations() {
        try {
            jarFileList = jarFileList();
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveProject() {
        if (!groupArrayList.isEmpty()) {
            projectData += "groupArrayList(=)" + groupArrayList + "\n";
        }
        if (!systemList.isEmpty()) {
            projectData += "systemList(=)" + systemList + "\n";
        }
        if (!dataList.isEmpty()) {
            projectData += "dataList(=)" + dataList + "\n";
        }
        if (!privAppList.isEmpty()) {
            projectData += "privAppList(=)" + privAppList + "\n";
        }
        if (!bootAnimList.isEmpty()) {
            projectData += "bootAnimList(=)" + bootAnimList + "\n";
        }
        if (!ringtoneList.isEmpty()) {
            projectData += "ringtoneList(=)" + ringtoneList + "\n";
        }
        if (!notifList.isEmpty()) {
            projectData += "notifList(=)" + notifList + "\n";
        }
        if (!kernelList.isEmpty()) {
            projectData += "kernelList(=)" + kernelList + "\n";
        }
        if (!fontsList.isEmpty()) {
            projectData += "fontsList(=)" + fontsList + "\n";
        }
        if (!deleteApkList.isEmpty()) {
            projectData += "deleteApkList(=)" + deleteApkList + "\n";
        }
        if (!descriptionList.isEmpty()) {
            projectData += "descriptionList(=)" + descriptionList;
        }
        if (!map.isEmpty()) {
            projectData += "(?)" + map;
        }
        if (!themesPath.equals("")) {
            projectData += "(?)" + "themesPath" + ", " + themesPath + "\n";
        }
        if (!splashPath.equals("")) {
            projectData += "splashPath" + ", " + splashPath;
        }
    }

    public void loadProject(String path) throws FileNotFoundException {
        String data = getStringFromFile(path);
        if (data.contains("?")) {
            String tempStringArray[] = data.split("\\(\\?\\)");
            for (int k = 0; k < tempStringArray.length; k++) {
                switch (k) {
                    case 0:
                        loadArrayLists(tempStringArray[k]);
                        break;
                    case 1:
                        loadMAP(tempStringArray[k]);
                        break;
                    case 2:
                        loadStrings(tempStringArray[k]);
                    default:
                        System.out.println("Something Went Wrong..!!");
                }
            }
            JOptionPane.showMessageDialog(null, "Loading of Project completed..!!");
        } else {
            JOptionPane.showMessageDialog(null, "Project Empty..!!");
        }
    }

    public void loadArrayLists(String arrayListString) {
        String arrayLists[] = arrayListString.split("\n");
        try {
            for (int i = 0; i < arrayLists.length; i++) {
                if (arrayLists[i].contains("=")) {
                    String group[] = arrayLists[i].split("\\(\\=\\)");
                    group[1] = group[1].substring(1, group[1].length() - 1);
                    System.out.println("Temp is : " + group[1]);
                    for (String str : group[1].split(", ")) {
                        switch (group[0]) {
                            case "groupArrayList":
                                groupArrayList.add(str);
                                break;
                            case "systemList":
                                systemList.add(str);
                                break;
                            case "dataList":
                                dataList.add(str);
                                break;
                            case "privAppList":
                                privAppList.add(str);
                                break;
                            case "bootAnimList":
                                bootAnimList.add(str);
                                break;
                            case "ringtoneList":
                                ringtoneList.add(str);
                                break;
                            case "notifList":
                                notifList.add(str);
                                break;
                            case "kernelList":
                                kernelList.add(str);
                                break;
                            case "fontsList":
                                fontsList.add(str);
                                break;
                            case "deleteApkList":
                                deleteApkList.add(str);
                                break;
                            case "descriptionList":
                                descriptionList.add(str);
                                break;
                            default:
                                System.out.println("Something Went Wrong..!!");
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundException caught..!!");
            e.printStackTrace();
        }

    }

    public void loadMAP(String mapString) {
        mapString = mapString.substring(1, mapString.length() - 1);
        String groupsWithPaths[] = mapString.split("\\], ");
        for (int i = 0; i < groupsWithPaths.length; i++) {
            if (groupsWithPaths[i].contains("=")) {
                String groups[] = groupsWithPaths[i].split("\\=");
                groups[1] = groups[1].replace("[", "").replace("]", "");
                String filePaths[] = groups[1].split(", ");
                for (int j = 0; j < filePaths.length; j++) {
                    map.put(groups[0], filePaths[j]);
                }
            }
        }
    }

    public void loadStrings(String strng) {
        String path[] = strng.split("\n");
        for (int i = 0; i < path.length; i++) {
            String variable[] = path[i].split(", ");
            switch (variable[0]) {
                case "themesPath":
                    themesPath = variable[1];
                    break;
                case "splashPath":
                    splashPath = variable[1];
                    break;
                default:
                    System.out.println("Something Went Wrong..!!");
            }
        }
    }

    public String getStringFromFile(String filePath) throws FileNotFoundException {
        String str = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            while (br.ready()) {
                str += (char) br.read();
            }
        } catch (IOException ioe) {
            System.out.println("Exception Caught while reading file..!!");
        }
        return str;
    }

    public ArrayList<String> getArrayListFromFileInZip(ZipInputStream zis) throws UnsupportedEncodingException {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(zis, "UTF-8"));
        try {
            while (br.ready()) {
                str += (char) br.read();
            }
            System.out.println("String is " + str);
        } catch (IOException e) {
        }
        String array[] = str.split("\n");
        for (String file : array) {
            list.add(file);
        }
        System.out.println("ArrayList obtained is : " + list);
        return list;
    }

    public void writeStringToFile(String strToWrite, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(strToWrite);

        } catch (IOException e) {
            System.out.println("Exception Caught..!!");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public void generateDeviceList() throws URISyntaxException, IOException {
        InputStream is = this.getClass().getResourceAsStream("META-INF/com/google/android/Supported Devices");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String deviceFullName;
        while ((deviceFullName = br.readLine()) != null) {
            String[] temp = deviceFullName.split("_");
            System.out.println("Device getting added from jar is : " + temp[0]);
            this.CSDmap.put(temp[0], temp[1]);
            try {
                if (temp[2].equals("nonneon")) {
                    nonNeonList.add(temp[1]);
                }
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Array Index Out Of Bound Exception..!!");
            }
        }
        is.close();
    }

    public int getGroupCount(ArrayList<String> groupType) {
        int count = 0;
        for (String temp : groupType) {
            count++;
        }
        return count;
    }

    public String getDescription(String desc, ArrayList<String> descArray) {
        for (String str : descArray) {
            if (str.contains(desc)) {
                return getDescription(str);
            }
        }
        return "";
    }

    public String getDescription(String desc) {
        String str = "";
        try {
            if (desc.contains("?_?")) {
                String temp[] = desc.split("\\?_\\?");
                str = temp[temp.length - 1];
            } else if (desc.contains("??")) {
                String temp[] = desc.split("\\?\\?");
                str = temp[temp.length - 1];
            }
            System.out.println("Splitted from " + desc + " to " + str);
            if (desc.endsWith("??")) {
                return "";
            } else if (desc.endsWith("?_?")) {
                return "";
            } else {
                return str;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "";
        }
    }

    public String getListName(String groupName) {
        if (this.systemList.contains(groupName)) {
            return "APKs-System";
        } else if (this.dataList.contains(groupName)) {
            return "APKs-Data";
        } else if (this.privAppList.contains(groupName)) {
            return "APKs-PrivApp";
        } else if (this.bootAnimList.contains(groupName)) {
            return "BootAnimations";
        } else if (this.kernelList.contains(groupName)) {
            return "Kernels";
        } else if (this.fontsList.contains(groupName)) {
            return "Fonts";
        } else if (this.ringtoneList.contains(groupName)) {
            return "Ringtones";
        } else if (this.notifList.contains(groupName)) {
            return "Notifications";
        }
        return "";
    }

    public String getKernelMountPoint() {

        try {
            InputStream is;
            BufferedReader br;
            is = this.getClass().getResourceAsStream("META-INF/com/google/android/mount-points/" + this.selectedDevice);//+ "_mountpoint");
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

    public String removeExtension(String str) {
        String tempString[] = str.split("\\.");
        for (int i = 1; i < tempString.length - 1; i++) {
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
    public ArrayList<String> returnPathArray(String str, MultiValueMap mvm) {
        System.out.println("ArrayList of file names based on key " + str + " in map is requested..");
        System.out.println("Map values are " + map);
        if (mvm.containsKey(str)) {
            System.out.println("Map contains key : " + str);
            Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) it.next();
                if (str.equals(mapEntry.getKey())) {
                    arrayList = (ArrayList<String>) mvm.get(mapEntry.getKey());
                }
            }
        } else {
            System.out.println("Map doesnt contains key : " + str);
        }
        System.out.println("ArrayList obtained based on key : " + str + " is : " + arrayList);
        return arrayList;
    }

    public void displayListInAroma(String listType, String listGroup, String heading, String themeFormat, String propFile, ArrayList<String> arrayList, ArrayList<String> descArrayList) {
        if (listType.equals("checkbox") && !arrayList.isEmpty()) {
            if (arrayList.equals(deleteApkList)) {
                System.out.println("ArrayList is Delete Apk List");
                this.aroma_config += "" + listType + "(\"" + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                this.aroma_config += ",\n\"" + "Delete System Apks" + "\", \"\", 2";
                for (String list : arrayList) {
                    this.aroma_config += ",\n\"" + list + "\", \"\", 0";
                }
                this.aroma_config += ");\n";
            } else if (arrayList.equals(otherFileList)) {
                System.out.println("ArrayList is Other File List");
                this.aroma_config += "" + listType + "(\"" + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                this.aroma_config += ",\n\"" + "Other Files" + "\", \"\", 2";
                if (!buildPropData.equals("")) {
                    this.aroma_config += ",\n\"" + "build.prop" + "\", \"\", 0";
                }
                if (!hostsFileData.equals("")) {
                    this.aroma_config += ",\n\"" + "hosts" + "\", \"\", 0";
                }
                this.aroma_config += ");\n";
            } else {
                this.aroma_config += "" + listType + "(\"" + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
                for (String list : arrayList) {
                    if (map.containsKey(list)) {
                        this.aroma_config += ",\n\"" + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\", \"\", 2";
                        this.aroma_config += ",\n\"Select All\",\"Check this to Install All.\", 1";
                        for (String list_files : this.returnPathArray(list, map)) {
                            String desc = list.substring(list.lastIndexOf("_") + 1, list.length()) + "??" + getNameFromPath(list_files) + "??";
                            this.aroma_config += ",\n\"" + this.removeExtension(getNameFromPath(list_files)) + "\", \"" + getDescription(desc, descArrayList) + "\", 0";
                        }
                    }
                }
                this.aroma_config += ");\n";
            }
        } else if (listType.equals("selectbox") && !arrayList.isEmpty()) {
            this.aroma_config += "" + listType + "(\"" + listGroup + "\",\"" + heading + "\",\"@" + themeFormat + "\",\"" + propFile + "\"";
            switch (propFile) {
                case "boot_anim_choices.prop":
                    this.aroma_config += ",\n\"" + "Select one Boot Animation" + "\", \"\", 2";
                    break;
                case "kernel_choices.prop":
                    this.aroma_config += ",\n\"" + "Select one Kernel" + "\", \"\", 2";
                    break;
                case "fonts_choices.prop":
                    this.aroma_config += ",\n\"" + "Select one Font" + "\", \"\", 2";
                    break;
            }
            this.aroma_config += ",\n\"None\",\"Select this if you dont want to select anything else.\", 1";
            for (String list : arrayList) {
                String desc = list.substring(list.lastIndexOf("_") + 1, list.length()) + "?_?";
                this.aroma_config += ",\n\"" + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\", \"" + getDescription(desc, descArrayList) + "\", 0";
            }
            this.aroma_config += ");\n";
        }
    }

    public boolean isExecutingJarFile() {
        return this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().contains("!");
    }

    public void configAromaThemes() {
        int i = 1;
        ArrayList<String> themes = new ArrayList<>();
        if (isExecutingJarFile()) {
            themes = themesList;
        } else {
            themes = getThemesList("src/flashablezipcreator/META-INF/com/google/android/aroma/themes");
        }
        if (!customThemeList.isEmpty()) {
            for (String theme : customThemeList) {
                themes.add(toNormalCase(new File(theme).getName()));
            }
        }
        this.aroma_config += "selectbox(\"Themes\",\"Choose your desired theme from following\",\"@personalize\",\"theme.prop\",\n";
        for (String theme : themes) {
            this.aroma_config += "\"" + theme + " Theme\", \"\", " + i + ",\n";
            if (i == 1) {
                i--;
            }
        }
        this.aroma_config = this.aroma_config.substring(0, this.aroma_config.length() - 2) + "\n";
        this.aroma_config += ");\n\n";
        i = 1;
        for (String theme : themes) {
            this.aroma_config += "if prop(\"theme.prop\", \"selected.0\")==\"" + i++ + "\" then\n"
                    + "theme(\"" + theme.toLowerCase() + "\");\n"
                    + "endif;\n\n";
        }
    }

    public void createAromaConfigFile() {
        this.aroma_config = "anisplash(\n"
                + "4,\n"
                + "\"splash/";
        if (this.splashPath.equals("")) {
            this.aroma_config += "AFZC";
        } else {
            this.aroma_config += "logo";
        }
        this.aroma_config += "\", 1200\n"
                + ");\n";

        this.aroma_config += "fontresload(\"0\", \"ttf/Roboto-Regular.ttf;ttf/DroidSansFallback.ttf;\", \"12\");\n"
                + "fontresload(\"1\", \"ttf/Roboto-Regular.ttf;ttf/DroidSansFallback.ttf;\", \"14\");\n";

        this.configAromaThemes();

        this.aroma_config += "agreebox(\"Important notes!\", \"Terms & Conditions\", \"@alert\",resread(\"Terms and Conditions.txt\"), \"I agree with these Terms of Use...\", \"You need to agree with the Terms of Use...\");\n";

        displayListInAroma("checkbox", "App List", "Choose the apps to be installed to data", "personalize", "app_choices.prop", this.dataList, this.descriptionList);

        displayListInAroma("checkbox", "System App List", "Choose the apps to be installed to system", "personalize", "system_app_choices.prop", this.systemList, this.descriptionList);

        displayListInAroma("checkbox", "Other File List", "Choose the files to be replaced", "personalize", "other_choices.prop", this.otherFileList, this.descriptionList);

        displayListInAroma("checkbox", "Priv App List", "Choose the apps to be installed to priv app", "personalize", "priv_app_choices.prop", this.privAppList, this.descriptionList);

        displayListInAroma("selectbox", "Boot Animations List", "Select Boot Animation to be used in current ROM", "personalize", "boot_anim_choices.prop", this.bootAnimList, this.descriptionList);

        displayListInAroma("selectbox", "Kernel List", "Select Kernel to be flashed", "personalize", "kernel_choices.prop", this.kernelList, this.descriptionList);

        displayListInAroma("selectbox", "Fonts List", "Select Fonts to be flashed", "personalize", "fonts_choices.prop", this.fontsList, this.descriptionList);

        displayListInAroma("checkbox", "Ringtone List", "Choose Ringtones to include in Rom", "personalize", "ringtone_choices.prop", this.ringtoneList, this.descriptionList);

        displayListInAroma("checkbox", "Notification List", "Choose Notification Tones to include in Rom", "personalize", "notification_choices.prop", this.notifList, this.descriptionList);

        displayListInAroma("checkbox", "Remove System Apps List", "Choose Apps To Remove", "personalize", "delete_choices.prop", this.deleteApkList, this.descriptionList);

        if (!dataList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"app_choices.prop\",readtmpfile(\"app_choices.prop\"));\n";
        }

        if (!systemList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"system_app_choices.prop\",readtmpfile(\"system_app_choices.prop\"));\n";
        }

        if (!otherFileList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"other_choices.prop\",readtmpfile(\"other_choices.prop\"));\n";
        }

        if (!privAppList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"priv_app_choices.prop\",readtmpfile(\"priv_app_choices.prop\"));\n";
        }

        if (!bootAnimList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"boot_anim_choices.prop\",readtmpfile(\"boot_anim_choices.prop\"));\n";
        }

        if (!kernelList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"kernel_choices.prop\",readtmpfile(\"kernel_choices.prop\"));\n";
        }

        if (!ringtoneList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"ringtone_choices.prop\",readtmpfile(\"ringtone_choices.prop\"));\n";
        }

        if (!fontsList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"fonts_choices.prop\",readtmpfile(\"fonts_choices.prop\"));\n";
        }

        if (!notifList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"notification_choices.prop\",readtmpfile(\"notification_choices.prop\"));\n";
        }

        if (!deleteApkList.isEmpty()) {
            this.aroma_config += "writetmpfile(\"delete_choices.prop\",readtmpfile(\"delete_choices.prop\"));\n";
        }

        this.aroma_config += "writetmpfile(\"dalvik_choices.prop\",\"init=no\\n\");\n";
        this.aroma_config += "checkviewbox(\n" + "\"Ready to Install\",\n"
                + "    \"The wizard is ready to begin installation.\\n\\n\"+\n"
                + "	\"Press <b>Next</b> to begin the installation.\\n\\n\"+\n"
                + "	\"If you want to review or change any of your installation settings, press <b>Back</b>. Press Left Hard Button -> Quit Installation to exit the wizard.\\n\\n\\n\\n\\n\\n\\n\",\n"
                + "    \"@install\",\n"
                + "\"<b>Clear Dalvik Cache</b> After Installation.\",\n";

        if (checkDalvikCache) {
            this.aroma_config += "\"1\"";
        } else {
            this.aroma_config += "\"0\"";
        }

        this.aroma_config += ",\n"
                + "\"clear_it\""
                + ");\n";

        this.aroma_config += "if\n"
                + "  getvar(\"clear_it\")==\"1\"\n"
                + "then\n"
                + "  writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n"
                + "endif;";

        //this.aroma_config += "if confirm(\"Wipe cache partition\",\"Do you want to clear dalvik cache after installation?\", \"@confirm\")==\"yes\" then writetmpfile(\"dalvik_choices.prop\",\"true=yes\");\n\nendif;\n";
        //this.aroma_config += "if confirm(\"Installing\",getvar(\"installer_title\") + \"\\n\\nStart Installation?\", \"@confirm\")==\"no\" then back(1);\nendif;\n";
        this.aroma_config += "install(\"Installing\", \"Your selected files are being installed. Please Wait...\", \"@install\");\n";

    }

    public void extractFilesUpdaterScript(ArrayList<String> arrayList, String title, String propFile, String location) {
        if (!arrayList.isEmpty()) {
            this.updater_script += "ui_print(\"@" + title + "\");\n";
            int s = 1;
            if (arrayList.equals(otherFileList)) {
                switch (this.flashableZipType) {
                    case "Create Flashable Zip With Aroma Installer":
                        if (!buildPropData.equals("")) {
                            this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then\n"
                                    + "ui_print(\"Replacing " + "Build.prop" + "\");\n";
                            this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "build.prop" + "\", \"" + location + "/build.prop\");\n";
                            this.updater_script += "endif;\n";
                            s++;
                        }
                        if (!hostsFileData.equals("")) {
                            this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + s + "\") then\n"
                                    + "ui_print(\"Replacing " + "Hosts" + "\");\n";
                            this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "hosts" + "\", \"" + location + "/etc/hosts\");\n";
                            this.updater_script += "endif;\n";
                            s++;
                        }
                        break;
                    case "Create Normal Flashable Zip":
                        if (!buildPropData.equals("")) {
                            this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "build.prop" + "\", \"" + location + "/build.prop\");\n";
                        }
                        if (!hostsFileData.equals("")) {
                            this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "hosts" + "\", \"" + location + "/etc/hosts\");\n";
                        }
                        break;
                }
            }
            for (String list : arrayList) {
                if (map.containsKey(list)) {
                    int i = 1;
                    for (String system_list_files : this.returnPathArray(list, map)) {
                        switch (this.flashableZipType) {
                            case "Create Flashable Zip With Aroma Installer":
                                switch (propFile) {
                                    case "kernel_choices.prop":
                                        this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + (s + 1) + "\") then\n"
                                                + "ui_print(\"Flashing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                        this.updater_script += "assert(package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\"));\n";
                                        this.updater_script += "endif;\n";
                                        break;
                                    case "boot_anim_choices.prop":
                                        this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + (s + 1) + "\") then\n"
                                                + "ui_print(\"Installing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                        this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                        this.updater_script += "endif;\n";
                                        break;
                                    case "fonts_choices.prop":
                                        if (i == 1) {
                                            this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"selected.1" + "\")==\"" + (s + 1) + "\") then\n"
                                                    + "ui_print(\"Installing " + list.substring(list.lastIndexOf("_") + 1, list.length()) + "\");\n";
                                            //this.updater_script += "\n\"set_progress(" + addProgressFraction() + ")\"\n";
                                            this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                            this.updater_script += "endif;\n";
                                        }
                                        break;
                                    default:
                                        if (i == 1) {
                                            this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"item." + s + "." + i + "\")==\"1\") then \n";
                                            for (String list_files : this.returnPathArray(list, map)) {
                                                this.updater_script += "ui_print(\"Installing " + this.removeExtension(getNameFromPath(list_files)) + "\");\n";
                                                this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(list_files) + "\", \"" + location + "/" + getNameFromPath(list_files) + "\");\n";
                                            }
                                            this.updater_script += "endif;\n";
                                        }
                                        this.updater_script += "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"item." + s + "." + (i + 1) + "\")==\"1\") then ui_print(\"Installing " + this.removeExtension(getNameFromPath(system_list_files)) + "\");\n";
                                        //this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                        this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "/" + getNameFromPath(system_list_files) + "\");\n";
                                        this.updater_script += "endif;\n";
                                        break;
                                }
                                i++;
                                break;
                            case "Create Normal Flashable Zip":
                                if (i == 1 && s == 1) {
                                    switch (propFile) {
                                        case "kernel_choices.prop":
                                            this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                            break;
                                        case "boot_anim_choices.prop":
                                            this.updater_script += "package_extract_file(\"customize/" + getListName(list) + "/" + list + "/" + getNameFromPath(system_list_files) + "\", \"" + location + "\");\n";
                                            break;
                                        case "fonts_choices.prop":
                                            if (i == 1) {
                                                this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
                                            }
                                            break;
                                        case "other_choices.prop":
                                            if (!buildPropData.equals("")) {
                                                this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "build.prop" + "\", \"" + location + "/build.prop\");\n";
                                            } else if (!hostsFileData.equals("")) {
                                                this.updater_script += "package_extract_file(\"customize/" + "script" + "/" + "hosts" + "\", \"" + location + "/etc/hosts\");\n";
                                            }
                                            break;
                                        default:
                                            this.updater_script += "package_extract_dir(\"customize/" + getListName(list) + "/" + list + "\", \"" + location + "\");\n";
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

    public void createUpdaterScriptFile() throws FileNotFoundException, IOException {
        this.updater_script = "ui_print(\"@Starting the install process\");\n"
                + "ui_print(\"Setting up required tools...\");\n"
                + //"package_extract_file(\"utils/mount\", \"/tmp/mount\");\n" +
                //"set_perm(0, 0, 0755, \"/tmp/mount\");\n" +
                "ui_print(\"Mounting Partitions...\");\n"
                + "ui_print(\" \");\n"
                + "run_program(\"/sbin/busybox\",\"mount\", \"/system\");\n"
                + "run_program(\"/sbin/busybox\",\"mount\", \"/data\");\n";
        //this.progress = 0.0;
        extractFilesUpdaterScript(otherFileList, "Replacing System Files", "other_choices.prop", "/system");
        this.updater_script += "\nset_progress(0.1);\n";
        extractFilesUpdaterScript(this.systemList, "Installing System Apps", "system_app_choices.prop", "/system/app");
        this.updater_script += "\nset_progress(0.2);\n";
        extractFilesUpdaterScript(this.privAppList, "Installing Priv Apps", "prive_app_choices.prop", "/system/priv-app");
        this.updater_script += "\nset_progress(0.3);\n";
        extractFilesUpdaterScript(this.dataList, "Installing Apps", "app_choices.prop", "/data/app");
        this.updater_script += "\nset_progress(0.4);\n";
        extractFilesUpdaterScript(this.bootAnimList, "Installing Boot Animation", "boot_anim_choices.prop", "/data/local/bootanimation.zip");
        this.updater_script += "\nset_progress(0.5);\n";
        extractFilesUpdaterScript(this.fontsList, "Installing Fonts", "fonts_choices.prop", "/system/fonts");
        this.updater_script += "\nset_progress(0.6);\n";
        extractFilesUpdaterScript(this.kernelList, "Flashing Kernel", "kernel_choices.prop", this.kernelMountPoint);// + "/boot.img");
        this.updater_script += "\nset_progress(0.7);\n";
        extractFilesUpdaterScript(this.ringtoneList, "Adding Ringtones", "ringtone_choices.prop", "/system/media/audio/ringtones");
        this.updater_script += "\nset_progress(0.8);\n";
        extractFilesUpdaterScript(this.notifList, "Adding Notification Tones", "notification_choices.prop", "/system/media/audio/notifications");
        this.updater_script += "\nset_progress(0.9);\n";
        if (!deleteApkList.isEmpty()) {
            int j = 1;
            this.updater_script += "ui_print(\"@" + "Deleting System Apps" + "\");\n";
            for (String appName : deleteApkList) {
                this.updater_script += "if (file_getprop(\"/tmp/aroma/" + "delete_choices.prop" + "\", \"item.1." + j + "\")==\"1\") then ui_print(\"Deleting " + appName + "\");\n";
                this.updater_script += " \n" + "delete(\"/system/app/" + appName + "\");\n";
                this.updater_script += "endif;\n";
                j++;
            }
        }

        if (!systemList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/app\");\n";
        }

        if (!privAppList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/priv-app\");\n";
        }

        if (!otherFileList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/etc\");\n";
        }

        if (!dataList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0771, 0644, \"/data/app\");\n";
        }

        if (!bootAnimList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0751, 0664, \"/data/local\");\n";
        }

        if (!ringtoneList.isEmpty() || !notifList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/media\");\n";
        }

        if (!fontsList.isEmpty()) {
            this.updater_script += "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/fonts\");\n";
        }

        if (this.flashableZipType.equals("Create Flashable Zip With Aroma Installer")) {
            this.updater_script += "\nif(file_getprop(\"/tmp/aroma/dalvik_choices.prop\", \"true\")==\"yes\") then\n"
                    + "ui_print(\"@Wiping dalvik-cache\");\n"
                    + "delete_recursive(\"/data/dalvik-cache\");\n"
                    + "endif;\n";
        } else if (checkDalvikCache) {
            this.updater_script += "delete_recursive(\"/data/dalvik-cache\");\n";
        }

        this.updater_script += "unmount(\"/data\");\n";
        this.updater_script += "unmount(\"/system\");\n";
        this.updater_script += "ui_print(\"@Finished Install\");\n";
        this.updater_script += "set_progress(1);\n";
    }

    public void fillListModelWithArrayList(DefaultListModel model, ArrayList<String> list, String listType) {
        System.out.println("Filling List " + model.toString() + " started..");
        for (String temp : list) {
            String finalStr = temp.replace(listType + "_", "");
            if (!model.contains(finalStr)) {
                model.addElement(finalStr);
                System.out.println(finalStr + " added to " + model.toString());
            }
        }
        System.out.println("Filling List " + model.toString() + " completed..");
    }

    public String getNameFromPath(String path) {
        System.out.println("Getting File name from path : " + path);
        String[] tempString;
        if (path.contains("\\")) {
            tempString = path.split("\\\\");
        } else {
            tempString = path.split("/");
        }
        System.out.println("File name : " + tempString[tempString.length - 1] + " returned..");
        return tempString[tempString.length - 1];
    }

    public String getFilePath(String key, String name, MultiValueMap mvm) {
        System.out.println("Getting actual File Path of " + name + "...");
        ArrayList<String> list = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) it.next();
            if (key.equals(mapEntry.getKey())) {
                list = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for (String path : list) {
                    if (path.contains(name)) {
                        System.out.println("Actual path of file : " + name + " is : " + path);
                        return path;
                    }
                }
            }
        }
        return "";
    }

    public void updateFileListWithSelectedGroupList(String key, DefaultListModel model, MultiValueMap mvm) {
        System.out.println("Updating file list of group " + key + "...");
        ArrayList<String> list;
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) it.next();
            if (key.equals(mapEntry.getKey())) {
                list = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(getNameFromPath(list.get(j)) + " added to file list");
                    model.addElement(getNameFromPath(list.get(j)));
                }
            }
        }
        System.out.println("File list updated...");
    }

    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList, DefaultListModel fileModel, String type) {
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] file = fileChooser.getSelectedFiles();
            for (File fileName : file) {
                if (this.map.containsValue(type + "_" + groupList.getSelectedValue(), fileName.getAbsolutePath()) || fileModel.contains(fileName.getName())) {
                    JOptionPane.showMessageDialog(null, "File with the same name already exists\nPlease rename the file before importing or make another group and import it.");
                } else {
                    this.map.put(type + "_" + groupList.getSelectedValue(), fileName.getAbsolutePath());
                    System.out.println(fileName.getAbsolutePath());
                }
            }
            fileModel.removeAllElements();
            updateFileListWithSelectedGroupList(type + "_" + groupList.getSelectedValue().toString(), fileModel, this.map);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    public void deleteDirectories(String location) {
        File directory = new File(location);
        if (!directory.exists()) {
            System.out.println("Directory Doesn't Exist..!!");
        } else {
            this.delete(directory);
        }
    }

    public void delete(File file) {
        if (file.isDirectory()) {
            if (file.list().length == 0) {
                file.delete();
                System.out.println("Directory Deleted.. " + file.getAbsolutePath());
            } else {
                String files[] = file.list();

                for (String temp : files) {
                    File fileDelete = new File(file, temp);
                    delete(fileDelete);
                }

                if (file.list().length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted : " + file.getAbsolutePath());
                }
            }
        } else {
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

    public ArrayList<String> getThemeFilesList(String path) {
        File f = new File(path);
        ArrayList<String> themesList = new ArrayList<>();
        if (f.isDirectory()) {
            for (String temp : f.list()) {
                themesList.add(path + File.separator + temp);
            }
        }
        return themesList;
    }

    public String toNormalCase(String str) {
        char c = (char) (str.charAt(0) - 32);
        str = c + str.substring(1);
        return str;
    }

    public ArrayList<String> getThemesList(String path) {
        ArrayList<String> tempArray = new ArrayList<>();
        File themes = new File(path);
        for (String theme : themes.list()) {
            theme = theme.substring(theme.indexOf("themes") + 1, theme.length());
            System.out.println("Theme : " + toNormalCase(theme));
            tempArray.add(toNormalCase(theme));
        }
        //JOptionPane.showMessageDialog(null, tempArray);
        return tempArray;
    }

    public String getJarFileName() {
        String path[] = this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().split("!");
        String fileName = path[0].substring(path[0].lastIndexOf("/") + 1, path[0].length());
        //JOptionPane.showMessageDialog(null, fileName);
        return fileName;
    }

    //This function will not be needed once final product is ready.
    public ArrayList<String> jarFileList() throws IOException {
        ArrayList<String> tempArray = new ArrayList<>();
        if (isExecutingJarFile()) {
            //op.jarFileList = this.getJarFileList();
            System.out.println("Executing Through Jar..!!");
            try {
                try (JarFile jarFile = new JarFile(getJarFileName())) {
                    for (Enumeration em = jarFile.entries(); em.hasMoreElements();) {
                        String s = em.nextElement().toString();
                        if (s.startsWith("flashablezipcreator/META-INF/")) {
                            s = s.substring("flashablezipcreator/".length(), s.length());
                            if (s.endsWith(".ttf") || s.endsWith(".png") || s.endsWith(".prop") || s.endsWith(".lang") || s.endsWith(".txt") || s.endsWith(".edify") || s.endsWith(".sh") || s.contains("displaycapture") || s.contains("sleep") || s.endsWith(".db")) {
                                tempArray.add(s);
                            }
                            String theme = "META-INF/com/google/android/aroma/themes";
                            if (s.startsWith(theme) && s.endsWith(".prop")) {
                                //JOptionPane.showMessageDialog(null, "String with theme path is : " + s);
                                theme = s.substring(theme.length() + 1, s.length());
                                theme = theme.substring(0, theme.indexOf("/"));
                                //JOptionPane.showMessageDialog(null, "String with theme name is : " + theme);
                                this.themesList.add(toNormalCase(theme));
                                //JOptionPane.showMessageDialog(null, "Entered.. " + themesList);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            //op.jarFileList = this.jarFileList();
            System.out.println("Executing Through Netbeans..!!");
            System.out.println("Adding of aroma files in list started..");
            this.addFilePathInArrayList("src/flashablezipcreator/META-INF/com/google/android/aroma", tempArray);
            this.themesList = getThemesList("src/flashablezipcreator/META-INF/com/google/android/aroma/themes");
            System.out.println("Adding of aroma files in list finished..");
        }
        return tempArray;
    }

    //This function is used to prepare an array list which contains path of default aroma files that are required to be added in zip file.
    public void addFilePathInArrayList(String path, ArrayList<String> tempArray) {
        File file = new File(path);
        if (file.isDirectory()) {
            for (String temp : file.list()) {
                addFilePathInArrayList(path + File.separator + temp, tempArray);
            }
        } else if (file.isFile()) {
            String s = file.getAbsolutePath();
            s = s.substring(s.indexOf("META-INF"), s.length());
            if (s.endsWith(".ttf") || s.endsWith(".png") || s.endsWith(".prop") || s.endsWith(".lang") || s.endsWith(".txt") || s.endsWith(".edify") || s.endsWith(".sh") || s.contains("displaycapture") || s.contains("sleep") || s.endsWith(".db")) {
                s = s.replace("\\", "/");
                tempArray.add(s);
                System.out.println("File Added to List is : " + s);
            }
        }
    }
}
