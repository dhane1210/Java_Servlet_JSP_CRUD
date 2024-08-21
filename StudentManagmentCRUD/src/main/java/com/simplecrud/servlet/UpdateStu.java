package com.simplecrud.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.simplecrud.dao.StudentDAO;
import com.simplecrud.model.Student;
@WebServlet("/updateStudent")
public class UpdateStu extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setEmail(email);
		stu.setCourse(course);
		
		StudentDAO sd = new StudentDAO();
		if(sd.Update(stu)) {
		response.sendRedirect("Welcome.jsp");
		}else {
		response.sendRedirect("Error.jsp");
		}
		
		
		
	}

}
