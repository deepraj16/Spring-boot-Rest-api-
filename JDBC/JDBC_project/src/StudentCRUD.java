import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db"; // Change database name
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // Change password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Student Result");
            System.out.println("2. View Results");
            System.out.println("3. Update Result");
            System.out.println("4. Delete Result");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addStudentResult(scanner);
                    break;
                case 2:
                    viewResults();
                    break;
                case 3:
                    updateResult(scanner);
                    break;
                case 4:
                    deleteResult(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    // Add student result
    private static void addStudentResult(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter exam date (YYYY-MM-DD): ");
        String examDate = scanner.nextLine();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO student_results(student_name, roll_number, subject, marks, exam_date) VALUES (?, ?, ?, ?, ?)");) {
            stmt.setString(1, name);
            stmt.setString(2, rollNumber);
            stmt.setString(3, subject);
            stmt.setInt(4, marks);
            stmt.setString(5, examDate);
            stmt.executeUpdate();
            System.out.println("Student result added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // View all student results
    private static void viewResults() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student_results");) {
            
            System.out.println("\nStudent Results:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("student_name") + ", Roll No: " + rs.getString("roll_number") + ", Subject: " + rs.getString("subject") + ", Marks: " + rs.getInt("marks") + ", Exam Date: " + rs.getString("exam_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Update student result
    private static void updateResult(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE student_results SET marks = ? WHERE id = ?")) {
            stmt.setInt(1, marks);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Result updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Delete student result
    private static void deleteResult(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM student_results WHERE id = ?")) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Result deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}