<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pharmacy Pharmacists</title>
</head>
<body>

    <h2>Pharmacists </h2>

    <h:dataTable value="#{reviewPharmacyController.selectedPharmacy.pharmacists}" var="ph" border="1">
        <h:column>
            <f:facet name="header"><h:outputLabel value="Pharmacist ID" /></f:facet>
            <h:outputText value="#{ph.pharmacistId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Name" /></f:facet>
            <h:outputText value="#{ph.pharmacistName}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Phone No" /></f:facet>
            <h:outputText value="#{ph.phoneNo}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Email" /></f:facet>
            <h:outputText value="#{ph.email}" />
        </h:column>
    </h:dataTable>

    <h:form>
        <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
    </h:form>

</body>
</html>
</f:view>
