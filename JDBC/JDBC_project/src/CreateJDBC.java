import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateJDBC {
    // Database URL, Username, and Password
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");

            // Creating a table for Student Result Management
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student_results ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "student_name VARCHAR(100) NOT NULL, "
                    + "roll_number VARCHAR(20) UNIQUE NOT NULL, "
                    + "subject VARCHAR(50) NOT NULL, "
                    + "marks INT CHECK (marks BETWEEN 0 AND 100), "
                    + "exam_date DATE NOT NULL)";
            
            PreparedStatement stmt = conn.prepareStatement(createTableSQL);
            stmt.executeUpdate();
            System.out.println("Student Result Management table created successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
