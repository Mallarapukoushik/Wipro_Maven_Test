package Mysql;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class MySQLConnectExample  {
 
    public static void main(String[] args) {
 
        // ✅ JDBC URL (your database name)
        String url = "jdbc:mysql://localhost:3306/ITCdatabase";
        String user = "root";        // change if needed
        String password = "Koushik@2003";    // change if needed
 
        try {
            // ✅ Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // ✅ Create connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to ITCdatabase successfully!");
 
            // ✅ Create statement
            Statement stmt = conn.createStatement();
 
            // ===================================================
            // ✅ 1. Fetch Persons Table
            // ===================================================
            System.out.println("\n--- Persons Table ---");
 
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Persons");
 
            while (rs1.next()) {
                System.out.println(
                        rs1.getInt("PersonID") + " | " +
                        rs1.getString("FirstName") + " | " +
                        rs1.getString("LastName") + " | " +
                        rs1.getInt("Age") + " | " +
                        rs1.getString("City") + " | " +
                        rs1.getString("Email") + " | " +
                        rs1.getString("Address")
                );
            }
 
            // ===================================================
            // ✅ 2. Fetch Orders Table
            // ===================================================
            System.out.println("\n--- Orders Table ---");
 
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Orders");
 
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("OrderID") + " | " +
                        rs2.getInt("OrderNumber") + " | " +
                        rs2.getInt("PersonID") + " | " +
                        rs2.getDouble("Amount")
                );
            }
 
            // ===================================================
            // ✅ 3. JOIN Query (Important for interview/demo)
            // ===================================================
            System.out.println("\n--- Persons with Orders (JOIN) ---");
 
            ResultSet rs3 = stmt.executeQuery(
                    "SELECT p.FirstName, p.LastName, o.OrderNumber, o.Amount " +
                    "FROM Persons p JOIN Orders o ON p.PersonID = o.PersonID"
            );
 
            while (rs3.next()) {
                System.out.println(
                        rs3.getString("FirstName") + " " +
                        rs3.getString("LastName") + " | Order: " +
                        rs3.getInt("OrderNumber") + " | Amount: " +
                        rs3.getDouble("Amount")
                );
            }
 
            // ✅ Close connection
            conn.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 