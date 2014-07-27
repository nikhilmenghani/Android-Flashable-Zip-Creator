/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.DiskOperations.WriteZip;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nikhil
 */
public class Export {

    public void createZip(ArrayList<ProjectItemNode> fileNode) throws IOException {
        WriteZip wz = new WriteZip("demo.zip");
        for (ProjectItemNode node : fileNode) {
            //this will simply take each file from source and create the same file in zip at specified destination path.
            wz.writeFileToZip(((FileNode)node).fileSourcePath, ((FileNode)node).getZipPath());
        }
        wz.close();
    }

    public void protocol2() {

    }
}
