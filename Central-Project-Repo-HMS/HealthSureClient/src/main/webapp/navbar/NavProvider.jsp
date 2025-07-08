<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<link rel="stylesheet" href="/HealthSureClient/resources/css/navProvider.css" />
<nav id="navbar" class="navbar navbar-scrolled"> <!-- Removed navbar-transparent -->
    <div class="navbar-container">

        <!-- LOGO + NAME -->
        <div class="navbar-logo">
        	<a href="/HealthSureClient/home/Home.jsf" class="logo-link">
            <h:graphicImage library="media" name="images/Logo.jpg" alt="HealthSure Logo" styleClass="logo-img" />
            </a>
            <span class="brand-name">HealthSure</span>
        </div>

        <!-- PROVIDER NAV LINKS -->
        <ul class="nav-links">
            <li><a href="providerDashboard.jsf" class="nav-link">Dashboard</a></li>
            <li><a href="appointments.jsf" class="nav-link">Appointments</a></li>
            <li><a href="patients.jsf" class="nav-link">Patients</a></li>
            <li><a href="services.jsf" class="nav-link">Services</a></li>
            <li><a href="reports.jsf" class="nav-link">Reports</a></li>
        </ul>

        <!-- LOGOUT BUTTON -->
        <div class="auth-buttons">
            <h:form>
                <h:commandButton value="Logout" action="#{authBean.logout}" styleClass="logout-btn" />
            </h:form>
        </div>
    </div>
</nav>
