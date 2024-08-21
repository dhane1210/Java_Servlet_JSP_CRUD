package com.simplecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplecrud.model.Student;

public class StudentDAO {
	
	private String url = "jdbc:postgresql://localhost:5432/studentdb";
	private String username = "postgres";
	private String password = "dhane";
	
	
	public boolean Add(Student stu) throws SQLException {
		
		String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, stu.getName());
			st.setString(2, stu.getEmail());
			st.setString(3, stu.getCourse());
			
			int rowsInserted = st.executeUpdate();
			if(rowsInserted >0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Update(Student stu) {
		 String sql ="UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, stu.getName());
			st.setString(2, stu.getEmail());
			st.setString(3, stu.getCourse());
			st.setInt(4, stu.getId());

			
			int rowsInserted = st.executeUpdate();
			if(rowsInserted >0) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Delete(Student stu) {
		String sql = "DELETE FROM students WHERE id = ?";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1, stu.getId());

			
			int rowsInserted = st.executeUpdate();
			if(rowsInserted >0) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Student> getAllStudents() {
	    List<Student> students = new ArrayList<>();
	    String sql = "SELECT * FROM students";
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(url, username, password);
	        PreparedStatement st = con.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            Student student = new Student();
	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setEmail(rs.getString("email"));
	            student.setCourse(rs.getString("course"));
	            students.add(student);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return students;
	}

}
