package com.brief.Servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.brief.DAO.DbConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);


        String uri = req.getRequestURI();
        if (uri.endsWith("login.jsp") || uri.contains("/resources/") ||
                uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".ico")) {
            chain.doFilter(request, response);
            return;
        }

        // Check if user is logging in
        if (req.getMethod().equals("POST") && uri.endsWith("dashbord.jsp")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (username != null && password != null && checkLogin(username, password)) {
                session = req.getSession(true);
                session.setAttribute("user", username);
                res.sendRedirect(req.getContextPath() + "/StudentServlet?action=list");
                return;
            } else {
                res.sendRedirect(req.getContextPath() + "/login.jsp?error=Invalid username or password");
                return;
            }
        }

        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    private boolean checkLogin(String username, String password) {
        try (Connection con = DbConnection.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM admin WHERE username=?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void destroy() {
    }
}