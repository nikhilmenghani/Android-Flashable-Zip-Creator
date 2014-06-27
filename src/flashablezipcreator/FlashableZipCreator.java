/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator;

import static flashablezipcreator.AFZC.Protocols.sopln;
import flashablezipcreator.Database.QueryDB;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikhil
 */
public class FlashableZipCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        QueryDB qdb = new QueryDB("afzc");
        sopln("qdb initialized");
        QueryDB qdb1 = new QueryDB("afzc");
        sopln("started");
        try{
            qdb.createTable("create table package(group_name varchar(40), location varchar(60), file_name varchar(120))");
        }catch (SQLException sqle){
            sopln("Table Already Exists");
        }
        sopln("table created");
        qdb.insert("package", "'System', 'system/app', 'abc.apk'");
        qdb.insert("package", "'System', 'data/app', 'data.apk'");
        ResultSet results = qdb.select("file_name", "package", "group_name IS NOT NULL");
        while(results.next())
        sopln(results.getString(1));
        qdb.update("package", "location = '/system/app'", "group_name = 'System'");
        results = qdb.select("*", "package", "group_name IS NOT NULL");
        while(results.next()){
            sopln("Column 1");
            sopln(results.getString(1));
            sopln("Column 2");
            sopln(results.getString(2));
            sopln("Column 3");
            sopln(results.getString(3));
        }
        qdb.delete("package", "file_name = 'data.apk'");
        results = qdb.select("file_name", "package", "group_name IS NOT NULL");
        while(results.next())
        sopln(results.getString(1));
        sopln("record successfully updated");
    }
    
}
