<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.simplecrud.model.Student"%>
<%@ page import="com.simplecrud.dao.StudentDAO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #007bff;
            padding: 15px;
            color: white;
            text-align: center;
        }

        .navbar h1 {
            margin: 0;
            font-size: 24px;
        }

        .container {
            max-width: 900px;
            margin: 30px auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .menu {
            display: flex;
            justify-content: space-around;
            margin-bottom: 40px;
        }

        .menu a {
            text-decoration: none;
            background-color: #28a745;
            color: white;
            padding: 15px 30px;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s;
        }

        .menu a:hover {
            background-color: #218838;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <h1>Student Management System</h1>
    </div>

    <div class="container">
        <h2>Welcome to the Student Management System</h2>
        <p>Select an option below to manage students:</p>

        <div class="menu">
            <a href="AddStu.jsp">Add Student</a>
            <a href="UpdateStu.jsp">Update Student</a>
            <a href="Deletestu.jsp">Delete Student</a>
        </div>

        <h2>All Students</h2>

        <%
            // Fetching the list of students from the database
            StudentDAO studentDAO = new StudentDAO();
            List<Student> studentList = studentDAO.getAllStudents();
        %>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
            </tr>
            <%
                for (Student student : studentList) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getCourse() %></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
