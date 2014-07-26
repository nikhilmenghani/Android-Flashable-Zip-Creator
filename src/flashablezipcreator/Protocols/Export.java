/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.DiskOperations.WriteZip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nikhil
 */
public class Export {

    public void protocol1(ArrayList<ProjectItemNode> fileNode) throws IOException {
        ArrayList<String> filePath = new ArrayList<>();
        WriteZip wz = new WriteZip("demo.zip");
        for (ProjectItemNode node : fileNode) {
            filePath.add(((FileNode)node).fileSourcePath);
        }
        for (String path : filePath) {
            File F = new File(path);
            System.out.println(F.getAbsolutePath());
            wz.writeFileToZip(path, path);
        }
        wz.close();
        
        
    }

    public void protocol2() {

    }
}
