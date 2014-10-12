package com.wishpal.donate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class ModifyData {
    // PostgreSQL connection to the database
    private Connection conn;
    // A raw SQL query used without parameters
    private Statement stmt;
 
    public ModifyData() {
        // The account names setup from the command line interface
        String user = "root";
        String passwd = "root";
        String dbName = "WishPalDB";
        // DB connection on localhost via JDBC
        String uri = "jdbc:mysql://localhost:8889/" + dbName;
 
 
        // Create the article table within sparkledb and close resources if an exception is thrown
        try {
            conn = DriverManager.getConnection(uri, user, passwd);
//            stmt = conn.createStatement();
         
            System.out.println("Connecting to MySQL database");
        } catch(Exception e) {
            System.out.println(e.getMessage());
 
            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    
 
    }
    
    
    public List<Item> readAll(int id) {
        try {
        	List<Item> result = new ArrayList<Item>();
            String selectQuery = "SELECT * FROM Wish where Status = ?";
 
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);
 
            pstmt.executeQuery();
 
            // A ResultSet is Class which represents a table returned by a SQL query
            ResultSet resultSet = pstmt.getResultSet();
 
            while(resultSet.next()) {
                Item entity = new Item(
                        // You must know both the column name and the type to extract the row
                        resultSet.getInt("WishCard"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("CardGender"),
                        resultSet.getString("CardAge"),
                        resultSet.getString("Preamble"),
                        resultSet.getString("GiftDescription"),
                        resultSet.getString("Gift2Description")
                		);
                result.add(entity);
                }
 
                pstmt.close();
 
                return result;
         
        } catch(Exception e) {
            System.out.println(e.getMessage());
 
            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
 
        return null;
    }
    public Item readOne(int id) {
        try {
            String selectQuery = "SELECT * FROM Wish where WishCard = ?";
 
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, id);
 
            pstmt.executeQuery();
 
            // A ResultSet is Class which represents a table returned by a SQL query
            ResultSet resultSet = pstmt.getResultSet();
 
            if(resultSet.next()) {
            	Item entity = new Item(
                        // You must know both the column name and the type to extract the row
                        resultSet.getInt("WishCard"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("CardGender"),
                        resultSet.getString("CardAge"),
                        resultSet.getString("Preamble"),
                        resultSet.getString("GiftDescription"),
                        resultSet.getString("Gift2Description")
                		);
 
                pstmt.close();
 
                return (Item) entity;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
 
            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
 
        return null;
    }
    
    
    
    public Boolean update(int id) {
        try {
            String updateQuery =
                "UPDATE Wish SET Status = 1  WHERE WishCARD = ?;"
                ;
 
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            
            
            pstmt.setInt(1, id);
 
            pstmt.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
 
            try {
                if(null != stmt) {
                    stmt.close();
                }
                if(null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
 
        return true;
    }
	
    
    
}