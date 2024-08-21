package com.simplecrud.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.simplecrud.dao.StudentDAO;
import com.simplecrud.model.Student;
@WebServlet("/addStudent")
public class AddStuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String course = request.getParameter("course");

		StudentDAO sd = new StudentDAO();
		
		Student stu = new Student();
		stu.setName(name);
		stu.setEmail(email);
		stu.setCourse(course);

		try {
			// Attempt to add the student to the database
			if (sd.Add(stu)) {
				// Redirect to a success page
				response.sendRedirect("Welcome.jsp");
			} else {
				// Redirect to the add student page in case of failure
				response.sendRedirect("Error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Redirect to an error page if there is a SQLException
			response.sendRedirect("Error.jsp");
		}

	}

}
