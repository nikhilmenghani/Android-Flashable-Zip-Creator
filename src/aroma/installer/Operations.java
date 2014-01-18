/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author Nikhil
 */
public class Operations {
    
    String lastActionCommand = "";
    String updateBinaryPath = "";
    String zipDestination = "";
    String tempFolderPath = "";
    String selectedDevice = "";
    
    ArrayList<String> CSDArrayList;
    ArrayList<String> groupArrayList = new ArrayList<>();
    ArrayList<String> systemList = new ArrayList<>();
    ArrayList<String> dataList = new ArrayList<>();
    ArrayList<String> bootAnimList = new ArrayList<>();
    ArrayList<String> ringtoneList = new ArrayList<>();
    ArrayList<String> notifList = new ArrayList<>();
    ArrayList<String> kernelList = new ArrayList<>();
    ArrayList<String> advancedList = new ArrayList<>();
    ArrayList<String> deleteApkList = new ArrayList<>();
    
    MultiValueMap map = new MultiValueMap();
    
    
    
    Operations(){
        
    }
    
    public void fillListModelWithArrayList(DefaultListModel model, ArrayList<String> list){
        for(String temp : list){
            model.addElement(temp);
        }
    }
    
    public String getNameFromPath(String str){
        String tempString[] = str.split("\\\\");
        System.out.println("Successfully Splitted from " + str + " to " + tempString[tempString.length-1]);
        return tempString[tempString.length-1];
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
    
    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList,DefaultListModel fileModel){
        
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File[] file = fileChooser.getSelectedFiles();
                for(int i=0; i<file.length; i++){
                    this.map.put(groupList.getSelectedValue(), file[i].getAbsolutePath());
                    System.out.println(file[i].getAbsolutePath());
                }
                fileModel.removeAllElements();
                updateFileListWithSelectedGroupList(groupList.getSelectedValue().toString(), fileModel, this.map);
        } else {
        System.out.println("File access cancelled by user.");
        }
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
    
    public void removeGroup(String groupName){
        if(this.groupArrayList.contains(groupName)){
            this.groupArrayList.remove(groupName);
            Boolean flag = this.systemList.contains(groupName)?this.systemList.remove(groupName):this.dataList.contains(groupName)?this.dataList.remove(groupName):false;
            flag = (!flag)?this.ringtoneList.contains(groupName)?this.ringtoneList.remove(groupName):this.notifList.contains(groupName)?this.notifList.remove(groupName):false:false;
            flag = (!flag)?this.kernelList.contains(groupName)?this.kernelList.remove(groupName):this.advancedList.contains(groupName)?this.advancedList.remove(groupName):false:false;
            flag = (!flag)?(this.deleteApkList.contains(groupName)?this.deleteApkList.remove(groupName):true):false;
            if(flag){
                JOptionPane.showMessageDialog(null, "Group Removed..");
            }
            //this.aromaGroupModel.removeAllElements();
            for(String group: this.groupArrayList){
            //    this.aromaGroupModel.addElement(group);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No Group Exists, Add Group First..!!");
        }
    }
}
