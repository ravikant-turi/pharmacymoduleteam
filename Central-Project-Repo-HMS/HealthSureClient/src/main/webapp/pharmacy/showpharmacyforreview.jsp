<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pharmacy Review Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h\\:dataTable {
            border-collapse: collapse;
            width: 100%;
        }

        h\\:column, th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        .action-button {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 6px 14px;
            text-align: center;
            text-decoration: none;
            font-size: 13px;
            border-radius: 4px;
            cursor: pointer;
        }

        .action-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h:dataTable value="#{reviewPharmacyController.showPharmacyAllForReview()}" var="pharmacy" border="1">
    
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="Pharmacy ID" />
        </f:facet>
        <h:outputText value="#{pharmacy.pharmacyId}" />
    </h:column>

    <h:column>
        <f:facet name="header">
            <h:outputLabel value="Pharmacy Name" />
        </f:facet>
        <h:outputText value="#{pharmacy.pharmacyName}" />
    </h:column>

    
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="Owner Name" />
        </f:facet>
        <h:outputText value="#{pharmacy.firstName} #{pharmacy.lastName}" />
    </h:column>

    <h:column>
        <f:facet name="header">
            <h:outputLabel value="Contact Number" />
        </f:facet>
        <h:outputText value="#{pharmacy.contactNo}" />
    </h:column>
    
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="ADHAR" />
        </f:facet>
        <h:outputText value="#{pharmacy.aadhar}" />
    </h:column>
    
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="LicenseNo" />
        </f:facet>
        <h:outputText value="#{pharmacy.licenseNo}" />
    </h:column>
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="Gst Number"/>
        </f:facet>
        <h:outputText value="#{pharmacy.gstNo}" />
    </h:column>

    <!-- Medicines Button -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Medicines" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewMedicines(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>

    <!-- Equipment Button -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Equipment" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewEquipments(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>

    <!-- Pharmacists Button -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Pharmacists" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewPharmacists(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>

    <!-- Dispensed Medicines -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Dispensed Medicines" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewDispensedMedicines(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>

    <!-- Dispensed Equipments -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Dispensed Equipments" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewDispensedEquipments(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>

    <!-- Passwords -->
    <h:column>
        <f:facet name="header"><h:outputLabel value="Passwords" /></f:facet>
        <h:form>
            <h:commandButton value="View" action="#{reviewPharmacyController.viewPasswords(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>
    
    <h:column>
        <f:facet name="header"><h:outputLabel value="VALIDATION" /></f:facet>
        <h:form>
            <h:commandButton value="validate" action="#{reviewPharmacyController.validatePharmacy(pharmacy)}" styleClass="action-button" />
        </h:form>
    </h:column>
    
    <h:column>
        <f:facet name="header">
            <h:outputLabel value="STATUS"/>
        </f:facet>
        <h:outputText value="#{pharmacy.status}" />
    </h:column>

</h:dataTable>

</body>
</html>
</f:view>
