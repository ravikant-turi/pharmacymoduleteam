<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pharmacy Passwords</title>
</head>
<body>

    <h2>Passwords - </h2>

    <h:dataTable value="#{reviewPharmacyController.selectedPharmacy.passwords}" var="pw" border="1">
        <h:column>
            <f:facet name="header"><h:outputLabel value="Password ID" /></f:facet>
            <h:outputText value="#{pw.passwordId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Password" /></f:facet>
            <h:outputText value="#{pw.password}" />
        </h:column>
    </h:dataTable>

    <h:form>
        <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
    </h:form>

</body>
</html>
</f:view>
