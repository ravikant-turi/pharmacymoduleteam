<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/HealthSureClient/resources/css/navAuth.css" />

<nav id="navbar" class="navbar navbar-scrolled">
    <div class="navbar-container">

        <!-- LOGO + NAME -->
        <div class="navbar-logo">
        	<a href="/HealthSureClient/home/Home.jsf" class="logo-link">
            <img src="/HealthSureClient/resources/media/images/Logo.jpg" alt="Apollo Logo" class="logo-img"/>
            </a>
            <span class="brand-name">HealthSure</span>
            
        </div>

        <!-- NAV LINKS -->
        <ul class="nav-links">
            <li><a href="#home" class="nav-link">Home</a></li>
            <li><a href="#departments" class="nav-link">Departments</a></li>
            <li><a href="#doctors" class="nav-link">Doctors</a></li>
            <li><a href="#aboutus" class="nav-link">About Us</a></li>
            <li><a href="#contact" class="nav-link">Contact</a></li>
        </ul>

        <!-- LOGIN + SIGNUP -->
        <div class="auth-buttons">

            <!-- LOGIN -->
            <div class="dropdown">
                <button class="dropdown-button login-btn">Login ▾</button>
                <ul class="dropdown-menu">
                    <li><a href="adminLogin.jsp">Admin</a></li>
                    <li><a href="providerLogin.jsp">Provider</a></li>
                    <li><a href="recipientLogin.jsp">Recipient</a></li>
                    <li><a href="/HealthSureClient/pharmacy/Login.jsf">Pharmacy</a></li>
                </ul>
            </div>

            <!-- SIGNUP -->
            <div class="dropdown">
                <button class="dropdown-button signup-btn">Signup ▾</button>
                <ul class="dropdown-menu">
                    <li><a href="adminSignup.jsp">Admin</a></li>
                    <li><a href="providerSignup.jsp">Provider</a></li>
                    <li><a href="recipientSignup.jsp">Recipient</a></li>
                    <li><a href="/HealthSureClient/pharmacy/AddOwner.jsf">Pharmacy</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>