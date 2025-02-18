package com.brief.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

        public class AddCours extends HttpServlet {


            public void init() {

            }
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("/AddCours.jsp").forward(request, response);
            }

            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String name = request.getParameter("name");
                String description = request.getParameter("description");

            }
        }






