/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Rajat
 */
public class ZipReader {
    public static void extractZip (String source) throws IOException{
        byte[] buffer = new byte[1024];
        //HashMap<String, String> groupAndItemNames = new HashMap<>();
        MultiValueMap mvm = new MultiValueMap();
        //ArrayList<String> groupNames = new ArrayList<>();
        //ArrayList<String> itemsNames  = new ArrayList<>();
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
                //System.out.println("file unzip : "+ newFile.getAbsoluteFile());
                String filePath = ze.getName();
                System.out.println(filePath);
                if(filePath.startsWith("customize")){
                    String temp = filePath.replace("customize/", "");
                    String splitName[] = temp.split("/");
                    //groupAndItemNames.put(splitName[2], splitName[0]);
                    mvm.put(splitName[0], splitName[2]);
                    //groupNames.add(splitName[0]);
                    //itemsNames.add(splitName[2]);
                }
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);             
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();   
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        }catch(IOException ex){
            ex.printStackTrace(); 
        }
        //displayMap(groupAndItemNames);
        //System.out.println();
        displayMVM(mvm);
    }
    
    public static ArrayList removeDuplicates(ArrayList a){
        HashSet hs = new HashSet();
        hs.addAll(a);
        a.clear();
        a.addAll(hs);
        return a;
    }
    
    public static void displayMap(HashMap map){
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {  
            String key = iterator.next().toString();  
            String value = map.get(key).toString();  
            System.out.println(key + " " + value);  
        }  
    }
    
    public static void displayMVM(MultiValueMap mvm){
        Iterator it = mvm.keySet().iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            String value = mvm.get(key).toString();
            System.out.println(key+" "+value);
        }
    }
    
    public static void main (String[] args){
        try {
            extractZip("C:\\Users\\Rajat\\Desktop\\test.zip");
        } catch (IOException ex) {
            Logger.getLogger(ZipReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
