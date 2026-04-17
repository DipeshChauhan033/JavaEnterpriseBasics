<%@page import="java.util.ArrayList" %>
<%@page import="com.dto.EmployeeDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>

<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto;
        background-color: #f2f2f7;
        margin: 0;
        padding: 20px;
        padding-top: 70px;
    }

    /* iOS Navbar */
    .navbar {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 55px;
        background: rgba(255,255,255,0.9);
        backdrop-filter: blur(10px);
        display: flex;
        align-items: center;
        justify-content: center;
        border-bottom: 1px solid #ddd;
    }

    .navbar .title {
        font-weight: 600;
        font-size: 17px;
        color: #000;
    }

    .home-btn {
        position: absolute;
        left: 15px;
        display: flex;
        align-items: center;
        gap: 5px;
        text-decoration: none;
        color: #007aff;
        font-size: 16px;
    }

    .home-btn svg {
        width: 18px;
        height: 18px;
    }

    .container {
        width: 100%;
        max-width: 600px;   /* reduced width for iOS look */
        margin: auto;
    }

    /* 🔥 FIXED: vertical layout */
    .grid {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }

    .card {
        width: 100%;   /* full width */
        background: #ffffff;
        border-radius: 12px;
        padding: 15px;
        box-shadow: 0 3px 8px rgba(0,0,0,0.08);
        transition: 0.2s;
    }

    .card:hover {
        transform: scale(1.01);
    }

    .title {
        font-size: 16px;
        font-weight: 600;
        margin-bottom: 8px;
        color: #1c1c1e;
    }

    /* Form fields */
    .card .field {
        display: flex;
        flex-direction: column;
        margin-bottom: 10px;
    }

    .card label {
        font-size: 13px;
        color: #8e8e93;
        margin-bottom: 3px;
    }

    .card input {
        padding: 10px;
        border-radius: 10px;
        border: 1px solid #ddd;
        font-size: 14px;
        outline: none;
    }

    .card input:focus {
        border-color: #007aff;
    }

    /* Update button */
    .update-btn {
        margin-top: 10px;
        padding: 12px;
        border: none;
        border-radius: 12px;
        background: #007aff;
        color: #fff;
        font-weight: 600;
        cursor: pointer;
        transition: 0.2s;
    }

    .update-btn:active {
        transform: scale(0.97);
    }

</style>

</head>
<body>

<div class="navbar">
    <a href="index.html" class="home-btn">
        <svg viewBox="0 0 24 24">
            <path d="M15 6l-6 6 6 6" stroke="currentColor" stroke-width="2" fill="none"/>
        </svg>
        <span>Home</span>
    </a>
    <div class="title">Update Employee Details</div>
</div>

<div class="container">

<div class="grid">

<%
    ArrayList<EmployeeDTO> arrlist=(ArrayList<EmployeeDTO>)request.getAttribute("SelectedData");
    int i = 1;
    for(EmployeeDTO employeeDTO : arrlist){
%>

<form action="setEmployeeUpdates" method="post" class="card">

    <div class="title">Employee ID-NO: <%= i %></div>

    <!-- Use real ID if available -->
    <input type="hidden" name="id" value="<%= i %>">

    <div class="field">
        <label>Name</label>
        <input type="text" name="ename" value="<%=employeeDTO.getEname()%>" required>
    </div>

    <div class="field">
        <label>Address</label>
        <input type="text" name="address" value="<%=employeeDTO.getAddress()%>" required>
    </div>

    <div class="field">
        <label>Age</label>
        <input type="number" name="age" value="<%=employeeDTO.getAge()%>" required>
    </div>

    <div class="field">
        <label>Salary</label>
        <input type="number" name="salary" value="<%=employeeDTO.getSalary()%>" required>
    </div>

    <button type="submit" class="update-btn">Update</button>

</form>

<% i++; } %>

</div>

</div>

</body>
</html>