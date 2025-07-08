<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dispensed Equipments</title>
</head>
<body>

    <h2>Dispensed Equipments </h2>

    <h:dataTable value="#{reviewPharmacyController.selectedPharmacy.dispensedEquipments}" var="de" border="1">
        <h:column>
            <f:facet name="header"><h:outputLabel value="Dispensed Equipment ID" /></f:facet>
            <h:outputText value="#{de.dispensedEquipId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Equipment Name" /></f:facet>
            <h:outputText value="#{de.equipment.equipmentName}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Quantity Dispensed" /></f:facet>
            <h:outputText value="#{de.quantityDispensed}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Dispense Date" /></f:facet>
            <h:outputText value="#{de.dispenseDate}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Prescription ID" /></f:facet>
            <h:outputText value="#{de.prescriptionId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Doctor ID" /></f:facet>
            <h:outputText value="#{de.doctorId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Patient H-ID" /></f:facet>
            <h:outputText value="#{de.hId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Pharmacist Name" /></f:facet>
            <h:outputText value="#{de.pharmacistName}" />
        </h:column>
    </h:dataTable>

    <h:form>
        <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
    </h:form>

</body>
</html>
</f:view>
