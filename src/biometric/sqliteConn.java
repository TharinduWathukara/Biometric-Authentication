/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

import java.sql.*;

/**
 *
 * @author tharindu
 */
public class sqliteConn {
    private static Connection con;
    private static boolean hasData = false;
    
    public ResultSet displayUsers() throws ClassNotFoundException,SQLException{
        if(con==null){
            getConnection();
        }
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name, phraseTime FROM user;");
        return res;
        
    }

    private void getConnection() throws ClassNotFoundException,SQLException{
        //To change body of generated methods, choose Tools | Templates.
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:sqliteConn1.db");
        initialise();
    }

    private void initialise() throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        if(!hasData){
            hasData = true;
            
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user';");
            
            if(!res.next()){
                System.out.println("Building the User table with prepopulated values.");
                //build the table
                Statement state2 = con.createStatement();
                state2.execute("CREATE TABLE user(id integer,name varchar(60),phraseTime double(15,10),primary key(id));");
                
                //insert sample data
                PreparedStatement prep=con.prepareStatement("INSERT INTO user values(?,?,?);");
                prep.setString(2,"Tharindu");
                prep.setDouble(3, 120.92308);
                prep.execute();
                
//                PreparedStatement prep1=con.prepareStatement("INSERT INTO user values(?,?,?);");
//                prep1.setString(2, "Mahesh");
//                prep1.setDouble(3, 109.051285);
//                prep1.execute();
            }
        }
    }
    
    public void addUser(String name, double phraseTime) throws SQLException, ClassNotFoundException{
        if(con == null){
            getConnection();
        }
        
        PreparedStatement prep=con.prepareStatement("INSERT INTO user values(?,?,?);");
        prep.setString(2, name);
        prep.setDouble(3,phraseTime);
        prep.execute();
    }
}