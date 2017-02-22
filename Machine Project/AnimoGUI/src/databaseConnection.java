/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kurt
 */
import java.sql.*;

public class databaseConnection {
	
	String connectionName;
	String dbUrl;
	Statement s;
	Connection con;
        
	public databaseConnection(){
		connectionName = "sqldb";
		dbUrl = "jdbc:odbc:" + connectionName;
		s = null;	
	}
        
	public Connection connectDB(){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                con = DriverManager.getConnection(dbUrl,"root","11337974");

                return con;
            }catch(Exception e){
                System.out.println(e);
            }

            return null;    
        }
        
	public Statement getStatement(){
            try{
                return con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            }catch(Exception e){
		System.out.println(e);	
            }
                
            return null;
	}
        
	public int returnInt(ResultSet rs, String columnName){
            try{
		return rs.getInt(columnName);
            }catch(Exception e){
		System.out.println(e);
            }
            
            return 0;
	}
	
	public String returnString(ResultSet rs, String columnName){
            try{
		return rs.getString(columnName);
            }catch(Exception e){
		System.out.println(e);
            }
            
            return null;
	}
        
	public ResultSet getResultSet(String statement,Statement s){
            try{
		return s.executeQuery(statement);
            }catch(Exception e){
		System.out.println(e);
            }
            
            return null;
	}
        
	public void next(ResultSet rs){
            try{
		rs.next();
            }catch(Exception e){
                System.out.println(e);
            }
	}
        
	public float returnFloat(ResultSet rs, String columnName){
            try{
                return rs.getFloat(columnName);
            }catch(Exception e){
                System.out.println(e);
            }
            
            return 0;
	}
        
	public void closeConnection(){
            try{
                con.close();
            }catch (SQLException e){
                System.out.println("error!");
            }
	}
}


