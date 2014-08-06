/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator.DiskOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Nikhil
 */
public final class ReadZip {
    public ZipInputStream zis = null;
    public ZipEntry ze = null;
    public ReadZip(String filePath) throws FileNotFoundException, IOException{
        this.zis = getZip(filePath);
        this.ze = this.zis.getNextEntry();
    }
    
    public ZipInputStream getZip(String filePath) throws FileNotFoundException{
        return new ZipInputStream(new FileInputStream(new File(filePath)));
    }
    
    public String getStringFromFile(ZipInputStream zis) throws UnsupportedEncodingException {
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(zis, "UTF-8"));
        try {
            while (br.ready()) {
                str += (char) br.read();
            }
        } catch (IOException ioe) {
            System.out.println("Exception Caught while reading file in zip..!!");
        }
        return str;
    }
    
    public void writeFileFromZip(ZipInputStream zis, String outputPath) throws IOException{
        writeFileFromZip(zis, new File(outputPath));
    }
    
    public void writeFileFromZip(ZipInputStream zis, File outFile) throws FileNotFoundException, IOException {
        File file = new File(outFile.getParent());
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("Path of file to be written from is : " + outFile.getAbsolutePath());
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            System.out.println("File Written..!!");
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(outFile.getName() + " File not found..!!");
        }
    }
    
    public void close() throws IOException{
        this.zis.closeEntry();
        this.zis.close();
    }
}
