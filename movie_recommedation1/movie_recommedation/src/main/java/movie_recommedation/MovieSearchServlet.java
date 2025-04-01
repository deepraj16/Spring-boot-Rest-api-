package movie_recommedation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movie/*")
public class MovieSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String URL = "jdbc:mysql://localhost:3306/movie";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    // Fetch all movies (GET Request)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM movies");
             ResultSet rs = stmt.executeQuery()) {

            StringBuilder json = new StringBuilder("[");
            while (rs.next()) {
                json.append("{")
                    .append("\"id\":").append(rs.getInt("id")).append(",")
                    .append("\"title\":\"").append(rs.getString("title")).append("\",")
                    .append("\"genre\":\"").append(rs.getString("genre")).append("\",")
                    .append("\"price\":").append(rs.getDouble("price")).append(",")
                    .append("\"booking_date\":\"").append(rs.getDate("booking_date")).append("\",")
                    .append("\"booking_time\":\"").append(rs.getTime("booking_time")).append("\"")
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

    // Add a new movie (POST Request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String priceStr = request.getParameter("price");
        String bookingDate = request.getParameter("booking_date");
        String bookingTime = request.getParameter("booking_time");

        try {
            double price = Double.parseDouble(priceStr);

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "INSERT INTO movies (title, genre, price, booking_date, booking_time) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, title);
                    stmt.setString(2, genre);
                    stmt.setDouble(3, price);
                    stmt.setString(4, bookingDate);
                    stmt.setString(5, bookingTime);
                    stmt.executeUpdate();

                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        out.print("{\"message\":\"Movie added successfully\", \"id\":" + rs.getInt(1) + "}");
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
