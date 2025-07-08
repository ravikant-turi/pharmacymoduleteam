<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Validate Temporary Password</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ValidatePass.css">
   
</head>
<body>
<jsp:include page="/navbar/NavAuthentication.jsp" />
<div class ="top">
    <h:form>
        <div class="form-container">

            <h2>Validate Temporary Password</h2>

            <!-- Email input -->
            <div class="form-group">
                <h:outputLabel for="email" value="Email Id:" styleClass="form-label" />
                <h:inputText id="email" value="#{controller.pharmacy.email}" required="true" styleClass="form-input" />
            </div>

            <!-- Temp Password input -->
            <div class="form-group">
                <h:outputLabel for="password" value="Temporary Password:" styleClass="form-label" />
                <h:inputSecret id="password" value="#{controller.pharmacy.password}" required="true" styleClass="form-input" />
            </div>

            <!-- Submit button -->
            <div class="form-group">
                <h:commandButton value="Validate Password" action="#{controller.validateTempPassword}" styleClass="submit-button" />
            </div>

            <!-- Faces message output -->
            <h:messages globalOnly="true" style="color:red;" />  

        </div>
    </h:form>
    </div>
    <jsp:include page="/footer/Footer.jsp" />
</body>
</html>
</f:view>
