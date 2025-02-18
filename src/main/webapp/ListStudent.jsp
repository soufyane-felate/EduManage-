<%--
  Created by IntelliJ IDEA.
  User: oucht
  Date: 2/18/2025
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 900px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .table th, .table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        .table th {
            background-color: #4CAF50;
            color: white;
        }

        .table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .table tbody tr:hover {
            background-color: #f1f1f1;
        }

        .btn {
            padding: 8px 12px;
            border-radius: 5px;
            font-size: 14px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            transition: 0.3s ease;
            border: none;
            cursor: pointer;
        }
        .btn-success {
            background-color: #28a745;
            color: white;
            display: block;
            width: fit-content;
            margin: auto;
        }

        .btn-success:hover {
            background-color: #1e7e34;
        }

        form {
            display: inline;
        }
    </style>
</head>
<body>
<div class="container mt-6">
<h1>Student List</h1>
<table class="table table-student">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Date_naissance</th>

    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${student.id}</td>
            <td>${student.nom}</td>
            <td>${student.prenom}</td>
            <td>${student.email}</td>
            <td>${student.date_naissance}</td>
        </tr>
    </tbody>
</table>
<a href="student" class="btn btn-success">Add New Student</a>
</div>
</body>
</html>