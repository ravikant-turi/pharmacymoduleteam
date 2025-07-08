<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Pharmacy Review Table</title>
</head>
<body>

<h:dataTable value="#{reviewPharmacyController.selectedPharmacy.medicines}" var="med" border="1">
    <h:column>
        <f:facet name="header"><h:outputLabel value="Medicine ID" /></f:facet>
        <h:outputText value="#{med.medicineId}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Name" /></f:facet>
        <h:outputText value="#{med.medicineName}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Purpose" /></f:facet>
        <h:outputText value="#{med.purpose}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Batch No" /></f:facet>
        <h:outputText value="#{med.batchNo}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Qty In Stock" /></f:facet>
        <h:outputText value="#{med.quantityInStock}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Unit Price" /></f:facet>
        <h:outputText value="#{med.unitPrice}" />
    </h:column>

    <h:column>
        <f:facet name="header"><h:outputLabel value="Expiry Date" /></f:facet>
        <h:outputText value="#{med.expiryDate}" />
    </h:column>
</h:dataTable>
<h:form>
    <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
</h:form>

</body>
</html>
</f:view>