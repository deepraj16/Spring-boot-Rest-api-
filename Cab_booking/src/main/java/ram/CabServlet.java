package ram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cabs/*")   
public class CabServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3306/demo22";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cab");
             ResultSet rs = stmt.executeQuery()) {

            StringBuilder json = new StringBuilder("[");
            while (rs.next()) {
                json.append("{")
                    .append("\"id\":").append(rs.getInt("id")).append(",")
                    .append("\"city\":\"").append(rs.getString("city")).append("\",")
                    .append("\"nameof_dirver\":\"").append(rs.getString("nameof_dirver")).append("\",")
                    .append("\"price\":").append(rs.getInt("price"))      
                    .append("},");
            }
            if (json.length() > 1) json.deleteCharAt(json.length() - 1);
            json.append("]");

            out.print(json.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String city = request.getParameter("city");
        String nameofDriver = request.getParameter("nameof_dirver");
        String priceStr = request.getParameter("price");

        try {
            int price = Integer.parseInt(priceStr);

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "INSERT INTO cab (city, nameof_dirver, price) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, city);
                    stmt.setString(2, nameofDriver);
                    stmt.setInt(3, price);
                    stmt.executeUpdate();

                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        out.print("{\"message\":\"Cab added successfully\", \"id\":" + rs.getInt(1) + "}");
                    }
                }
            }
        } catch (NumberFormatException e) {
            out.print("{\"error\":\"Invalid price format\"}");
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
