package com.simplecrud.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.simplecrud.dao.StudentDAO;
import com.simplecrud.model.Student;

@WebServlet("/deleteStudent")
public class DeleteStu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		Student stu = new Student();
		stu.setId(id);
		
		StudentDAO sd = new StudentDAO();
		
		if(sd.Delete(stu)) {
		response.sendRedirect("Welcome.jsp");
		}else {
		response.sendRedirect("Error.jsp");
		}

	}

}
