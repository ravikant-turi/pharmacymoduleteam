<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<html>
<head>
    <title>Pharmacy Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/PharmacyLogin.css">
</head>
<body>
<jsp:include page="/navbar/NavAuthentication.jsp" />
<div class ="top">
<f:view>
    <h:form>
        <div class="form-container">
            <h2>Login</h2>
      <!--        <h:messages globalOnly="true" />
<h:outputText value="#{flash.message}" />  -->
            
            
            <h:messages globalOnly="true" layout="table" styleClass="error-message" />

            <div class="form-group">
                <h:outputLabel for="email" value="Email:" styleClass="form-label" />
                <h:inputText id="email" value="#{controller.pharmacy.email}" autocomplete ="off"  styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:outputLabel for="password" value="Password:" styleClass="form-label" />
                <h:inputSecret id="password" value="#{controller.pharmacy.password}" required="true" autocomplete ="off" styleClass="form-input" />
            </div>

            <div class="form-group">
                <h:commandButton value="Login" action="#{controller.validateLogin}" styleClass="submit-button" />
            </div>
        </div>
    </h:form>
</f:view>
</div>
    <jsp:include page="/footer/Footer.jsp" />



</script>
</body>
</html>
