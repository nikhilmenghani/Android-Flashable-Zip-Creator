/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nikhil
 */
public class UIOperations {
    public String browseZipDestination() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Zip File Destination Location : " + file.getAbsolutePath());
            if (!file.getAbsolutePath().endsWith(".zip")) {
                //textField.setText(file.getAbsolutePath() + ".zip");
                return file.getAbsolutePath() + ".zip";
            } else {
                //textField.setText(file.getAbsolutePath());
                return file.getAbsolutePath();
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        return null;
    }
}
