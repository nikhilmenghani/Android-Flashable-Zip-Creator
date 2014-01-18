/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

/**
 *
 * @author Nikhil
 */
import java.io.File;
import javax.swing.ImageIcon;


public class Utils {
    public final static String acc = "acc";
    public final static String mp3 = "mp3";
    public final static String m4a = "m4a";
    public final static String ogg = "ogg";
    public final static String wav = "wav";
    

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
