/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashablezipcreator.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikhil
 */
public class QueryDB extends CreateDB {
    public QueryDB(String DbName) throws ClassNotFoundException, SQLException{
        super(DbName);
        Class.forName(DRIVER);
    }
        
    public void createTable(String tableQry) throws SQLException{
        Connection con = DriverManager.getConnection(JDBC_URL);
        con.createStatement().execute(tableQry);
        con.close();
    }
    
    public void insert(String table, String values) throws SQLException{
        Connection con = DriverManager.getConnection(JDBC_URL);
        String qry = "insert into " + table + 
                " values" + "(" + values + ")";
        con.createStatement().executeUpdate(qry);
        sopln("inserted");
        con.close();
    }
    
    public void update(String table, String values, String condition) throws SQLException{
        Connection con = DriverManager.getConnection(JDBC_URL);
        String qry = "update " + table + 
                " set " + values +
                " where " + condition + "";
        con.createStatement().executeUpdate(qry);
        sopln("updated");
        con.close();
    }
    
    public void delete(String table, String condition) throws SQLException{
        Connection con = DriverManager.getConnection(JDBC_URL);
        String qry = "delete from " + table + 
                " where " + condition + "";
        con.createStatement().executeUpdate(qry);
        sopln("deleted");
        con.close();
    }
    
    public ResultSet select(String columns, String table, String condition) throws SQLException{
        Connection con = DriverManager.getConnection(JDBC_URL);
        String qry = "select " + columns + 
                " from " + table +
                " where " + condition + "";
        return con.createStatement().executeQuery(qry);
        //con.close();
    }
}
