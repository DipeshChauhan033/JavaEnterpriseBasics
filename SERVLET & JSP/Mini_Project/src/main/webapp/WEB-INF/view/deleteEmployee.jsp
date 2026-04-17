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
	
	/* Title center */
	.navbar .title {
	    font-weight: 600;
	    font-size: 17px;
	    color: #000;
	}
	
	/* Home button (left side) */
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
	
	/* Icon */
	.home-btn svg {
	    width: 18px;
	    height: 18px;
	}
	
	/* Adjust body so it doesn't hide under navbar */
	body {
	    padding-top: 70px;
	}

    .container {
        max-width: 1000px;
        margin: auto;
    }

    .container {
        max-width: 1000px;
        margin: auto;
    }

    /* GRID LAYOUT */
    .grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
        gap: 15px;
    }

    /* SMALL CARD */
    .card {
        background: #ffffff;
        border-radius: 12px;
        padding: 15px;
        box-shadow: 0 3px 8px rgba(0,0,0,0.08);
        transition: 0.2s;
    }

    .card:hover {
        transform: scale(1.03);
    }

    .title {
        font-size: 16px;
        font-weight: 600;
        margin-bottom: 8px;
        color: #1c1c1e;
    }

    .field {
        font-size: 14px;
        color: #3a3a3c;
        margin: 2px 0;
    }
    
    /* iOS Form */
	.ios-form {
	    margin-bottom: 25px;
	}
	
	/* Input Container */
	.input-group {
	    display: flex;
	    align-items: center;
	    background: #fff;
	    border-radius: 12px;
	    padding: 12px;
	    box-shadow: 0 3px 8px rgba(0,0,0,0.08);
	    margin-bottom: 12px;
	}
	
	/* Icon */
	.input-group .icon {
	    width: 20px;
	    height: 20px;
	    margin-right: 10px;
	    color: #8e8e93;
	}
	
	/* Input Field */
	.input-group input {
	    border: none;
	    outline: none;
	    font-size: 16px;
	    width: 100%;
	    background: transparent;
	}
	
	/* iOS Button */
	.ios-btn {
	    width: 100%;
	    padding: 14px;
	    border: none;
	    border-radius: 12px;
	    background: #ff3b30;
	    color: white;
	    font-size: 16px;
	    font-weight: 600;
	    cursor: pointer;
	    transition: 0.2s;
	}
	
	/* Button Press Effect */
	.ios-btn:active {
	    transform: scale(0.97);
	    opacity: 0.9;
	}
</style>

</head>
<body>

<div class="container">

<div class="navbar">

    <a href="index.html" class="home-btn">
        <!-- Back/Home Icon -->
        <svg viewBox="0 0 24 24">
            <path d="M15 6l-6 6 6 6" stroke="currentColor" stroke-width="2" fill="none"/>
        </svg>
        <span>Home</span>
    </a>

    <div class="title">Delete Employee Records</div>

</div>


<form action="deleteEmployee" method="post" class="ios-form">

    <div class="input-group">
        <!-- ID Icon -->
        <svg class="icon" viewBox="0 0 24 24">
            <path d="M4 7h16v10H4z" stroke="currentColor" stroke-width="2" fill="none"/>
            <path d="M8 11h8M8 15h5" stroke="currentColor" stroke-width="2"/>
        </svg>

        <input type="number" name="no" placeholder="Enter Employee ID To Delete Employee Data" required>
    </div>

    <button type="submit" class="ios-btn">
        Delete Employee
    </button>

</form>

<div class="grid">

<%
    ArrayList<EmployeeDTO> arrlist=(ArrayList<EmployeeDTO>)request.getAttribute("data");
	int i = 1;
    for(EmployeeDTO employeeDTO : arrlist){
%>
	
    <div class="card">
    	<div class="title">Employee ID-NO: <%= i %></div>
        <div class="title"><%=employeeDTO.getEname()%></div>
        <div class="field">Address: <%=employeeDTO.getAddress()%></div>
        <div class="field">Age: <%=employeeDTO.getAge()%></div>
        <div class="field">Salary: <%=employeeDTO.getSalary()%></div>
    </div>

<% i++;} %>

</div>

</div>

</body>
</html>