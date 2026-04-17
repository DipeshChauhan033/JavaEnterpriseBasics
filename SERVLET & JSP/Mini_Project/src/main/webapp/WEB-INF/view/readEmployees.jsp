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

    <div class="title">Employee Records</div>

</div>

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