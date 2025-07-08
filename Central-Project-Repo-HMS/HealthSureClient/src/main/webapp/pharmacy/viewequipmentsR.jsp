<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Equipments</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        .back-button {
            margin-top: 20px;
        }

        .action-button {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 6px 14px;
            font-size: 14px;
            border-radius: 4px;
            cursor: pointer;
        }

        .action-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h2>Equipment List for Pharmacy: 
    
    <h:dataTable value="#{reviewPharmacyController.selectedPharmacy.equipment}" var="equip" border="1">
        <h:column>
            <f:facet name="header"><h:outputLabel value="Equipment ID" /></f:facet>
            <h:outputText value="#{equip.equipmentId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Name" /></f:facet>
            <h:outputText value="#{equip.equipmentName}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Description" /></f:facet>
            <h:outputText value="#{equip.description}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Quantity" /></f:facet>
            <h:outputText value="#{equip.quantity}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Unit Price" /></f:facet>
            <h:outputText value="#{equip.unitPrice}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Purpose" /></f:facet>
            <h:outputText value="#{equip.purpose}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Purchase Date" /></f:facet>
            <h:outputText value="#{equip.purchaseDate}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Status" /></f:facet>
            <h:outputText value="#{equip.status}" />
        </h:column>
    </h:dataTable>

    <h:form styleClass="back-button">
    <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
    
    </h:form>

</body>
</html>
</f:view>
