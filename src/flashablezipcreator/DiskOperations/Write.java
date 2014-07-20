/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.DiskOperations;

import flashablezipcreator.AFZC.Protocols;
import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.ProjectItemNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Clock.system;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Nikhil
 */
public class Write extends Protocols {

    static String path = "";

    //this function is used when a file is required to be created with string data in it.
    public void writeStringToFile(String strToWrite, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
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

    public void writeFile(String sourcePath, String destPath) throws FileNotFoundException, IOException {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        if (sourceFile.exists()) {
            FileInputStream fis = new FileInputStream(sourceFile);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            int len;
            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(destPath);
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fis.close();
            fos.close();
        } else {
            System.out.println("Source File Not Found at : " + sourcePath);
        }
    }

    public void createFolder(String name) {
        File file = new File(name);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Folder created at : " + name);
        }
    }
}
