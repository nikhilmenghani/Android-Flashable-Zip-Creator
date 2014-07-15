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
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Nikhil
 */
public class Read {
    BufferedReader br;
    public String getFileString(String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                String str = "";
                while ((br.ready())) {
                    str += (char) br.read();
                }
                return str;
            } catch (IOException ioe) {
                System.out.println("Exception caught while reading from File.." + ioe);
            }
        }
        return "";
    }
}