package movie_recommedation;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect("index.html?message=Account created successfully!");
            } else {
                response.sendRedirect("register.jsp?error=Failed to create account.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            response.sendRedirect("register.jsp?error=Username already exists.");
        } catch (Exception e) {
            response.sendRedirect("register.jsp?error=Internal server error.");
            e.printStackTrace();
        }
    }
}
