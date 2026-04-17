<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }

    body {
        background: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
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
        background: #fff;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 400px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 6px;
        transition: 0.3s;
    }

    input:focus {
        border-color: #007bff;
        outline: none;
    }

    button {
        width: 100%;
        padding: 10px;
        background: #007bff;
        color: #fff;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #0056b3;
    }

    /* Responsive */
    @media (max-width: 480px) {
        .container {
            margin: 10px;
            padding: 20px;
        }
    }
</style>

</head>
<body>
<div class="navbar">

    <a href="index.html" class="home-btn">
        <!-- Back/Home Icon -->
        <svg viewBox="0 0 24 24">
            <path d="M15 6l-6 6 6 6" stroke="currentColor" stroke-width="2" fill="none"/>
        </svg>
        <span>Home</span>
    </a>

    <div class="title">Employee Registration Form</div>

</div>

<%@include file="message.jsp" %>

<div class="container">
    <h2>Add Employee</h2>

    <form action="addEmployee" method="post">
        
        <div class="form-group">
            <label>Employee Name</label>
            <input type="text" name="ename" required>
        </div>

        <div class="form-group">
            <label>Address</label>
            <input type="text" name="address" required>
        </div>

        <div class="form-group">
            <label>Employee Age</label>
            <input type="number" name="age" required>
        </div>

        <div class="form-group">
            <label>Employee Salary</label>
            <input type="number" name="salary" required>
        </div>

        <button type="submit">Submit</button>

    </form>
</div>

</body>
</html>