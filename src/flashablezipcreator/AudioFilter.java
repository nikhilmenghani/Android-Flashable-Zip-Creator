/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator;

/**
 *
 * @author Nikhil
 */
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class AudioFilter extends FileFilter {

    //Accept all directories and all acc, mp3, m4a, ogg, or wav files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.acc) ||
                extension.equals(Utils.mp3) ||
                extension.equals(Utils.m4a) ||
                extension.equals(Utils.ogg) ||
                extension.equals(Utils.wav)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Audio Files";
    }
}
