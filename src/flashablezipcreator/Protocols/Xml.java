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
import flashablezipcreator.Operations.XmlOperations;
import static flashablezipcreator.Protocols.Export.to;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Xml {

    static XmlOperations xo;
    static String path = "afzc/custom_data.xml";
    static String originalData = "";
    static String generatedData = "";
    
    public static String getString(ProjectItemNode rootNode) throws ParserConfigurationException, TransformerException {
        xo = new XmlOperations();
        xo.createXML();
        for (ProjectItemNode project : to.getProjectsSorted(rootNode)) {
            if (((ProjectNode) project).projectType != ProjectNode.PROJECT_THEMES) {
                for (ProjectItemNode groupNode : ((ProjectNode) project).children) {
                    for (ProjectItemNode node : ((GroupNode) groupNode).children) {
                        if (node.type == ProjectItemNode.NODE_SUBGROUP) {
                            for (ProjectItemNode fileNode : ((SubGroupNode) node).children) {
                                if(((SubGroupNode)fileNode.parent).subGroupType == SubGroupNode.TYPE_CUSTOM){
                                    xo.addFileNode((FileNode) fileNode, xo.rootSubGroup);
                                }
                                
                            }
                        } else if (node.type == ProjectItemNode.NODE_FILE) {
                            if(((GroupNode)node.parent).groupType == GroupNode.GROUP_CUSTOM){
                                xo.addFileNode((FileNode) node, xo.rootGroup);
                            }
                        }
                    }
                }
            }
        }
        return xo.getXML();
    }
    
    public static void parseXml(ProjectItemNode rootNode) throws ParserConfigurationException, SAXException, IOException{
        xo.parseGeneratedXML(rootNode, generatedData, originalData);
    }
    
    public static void initialize() throws ParserConfigurationException{
        xo = new XmlOperations();
        xo.createXML();
    }
    
    public static void addFileDataToGroup(FileNode file){
        xo.addFileNode(file, xo.rootGroup);
    }
    
    public static void addFileDataToSubGroup(FileNode file){
        xo.addFileNode(file, xo.rootSubGroup);
    }
    
    public static void terminate() throws TransformerException{
        generatedData = xo.getXML();
    }
}
