<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Recepient Profile</title>
    <link rel="stylesheet" href="/HealthSureClient/resources/css/profile.css" />
</head>

<body>

<f:view>
    <jsp:include page="/navbar/NavRecepient.jsp" />
    <div class="container">
        <h1 class="heading-primary">
            Welcome, <h:outputText value="#{sessionScope.provider_name}" />
        </h1>

        <div class="details-box">
            <p><strong>Provider ID:</strong> <h:outputText value="#{sessionScope.provider_id}" /></p>
            <p><strong>Hospital Name:</strong> <h:outputText value="#{sessionScope.hospital_name}" /></p>
            <p><strong>Email:</strong> <h:outputText value="#{sessionScope.email}" /></p>
            <p><strong>Address:</strong> <h:outputText value="#{sessionScope.address}" /></p>
            <p><strong>City:</strong> <h:outputText value="#{sessionScope.city}" /></p>
            <p><strong>State:</strong> <h:outputText value="#{sessionScope.state}" /></p>
            <p><strong>ZIP Code:</strong> <h:outputText value="#{sessionScope.zip_code}" /></p>
        </div>

        <div class="button-group">
            <h:form>
                <h:commandButton value="Logout" action="#{authBean.logout}" styleClass="button-red" />
            </h:form>
            <h:form>
                <h:commandButton value="Reset Password" action="#{authBean.resetPassword}" styleClass="button-yellow" />
            </h:form>
        </div>
    </div>
</f:view>

<jsp:include page="/footer/Footer.jsp" />
</body>
</html>
