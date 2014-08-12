/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.DiskOperations.WriteZip;
import flashablezipcreator.Operations.JarOperations;
import flashablezipcreator.Operations.TreeOperations;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikhil
 */
public class Export {

    static WriteZip wz;
    static TreeOperations to;

    public static void createZip(ArrayList<ProjectItemNode> fileNode) throws IOException {
        wz = new WriteZip(Project.outputPath);
        for (ProjectItemNode node : fileNode) {
            //this will simply take each file from source and create the same file in zip at specified destination path.
            wz.writeFileToZip(((FileNode) node).fileSourcePath, ((FileNode) node).fileZipPath);
            //wz.writeByteToFile(to.getProjectNode(projectName, projectType).update_binary,"Temp" + File.separator + projectName + File.separator + "update-binary");
        }
        wz.close();
    }

    public static void zip(ProjectItemNode rootNode) throws IOException {
        wz = new WriteZip(Project.outputPath);
        to = new TreeOperations(rootNode);
        for (ProjectItemNode project : to.getProjectsSorted(rootNode)) {
            if (((ProjectNode) project).projectType != ProjectNode.PROJECT_THEMES) {
                for (ProjectItemNode groupNode : ((ProjectNode) project).children) {
                    for (ProjectItemNode node : ((GroupNode) groupNode).children) {
                        if (node.type == ProjectItemNode.NODE_SUBGROUP) {
                            for (ProjectItemNode fileNode : ((SubGroupNode) node).children) {
                                wz.writeFileToZip(((FileNode) fileNode).fileSourcePath, ((FileNode) fileNode).fileZipPath);
                            }
                        } else if (node.type == ProjectItemNode.NODE_FILE) {
                            wz.writeFileToZip(((FileNode) node).fileSourcePath, ((FileNode) node).fileZipPath);
                        }
                    }
                }
            }else{
                for (ProjectItemNode groupNode : ((ProjectNode) project).children) {
                    for (ProjectItemNode node : ((GroupNode) groupNode).children) {
                        wz.writeFileToZip(JarOperations.getInputStream(((FileNode) node).fileSourcePath), ((FileNode) node).fileZipPath);
                    }
                }
            }
        }
        wz.writeStringToZip(AromaConfig.build(rootNode), AromaConfig.aromaConfigPath);
        wz.writeStringToZip(UpdaterScript.build(rootNode), UpdaterScript.updaterScriptPath);
        wz.writeByteToFile(Binary.getInstallerBinary(rootNode), Binary.updateBinaryInstallerPath);
        wz.writeByteToFile(Binary.getUpdateBinary(rootNode), Binary.updateBinaryPath);
        for(String file : Jar.getOtherFileList()){
            wz.writeFileToZip(JarOperations.getInputStream(file), file);
        }
        wz.close();
        JOptionPane.showMessageDialog(null, "Zip Created Successfully..!!");
    }
}
