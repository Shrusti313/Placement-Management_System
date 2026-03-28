import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database URL, Username, and Password
    private static final String URL = "jdbc:mysql://localhost:3306/PlacementSystem";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "dwd1234"; // Your MySQL password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1. Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connection Successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed! Check credentials.");
            e.printStackTrace();
        }
        return connection;
    }
}