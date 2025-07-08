<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dispensed Medicines</title>
</head>
<body>

    <h2>Dispensed Medicines </h2>

    <h:dataTable value="#{reviewPharmacyController.selectedPharmacy.dispensedMedicines}" var="dm" border="1">
        <h:column>
            <f:facet name="header"><h:outputLabel value="Dispense ID" /></f:facet>
            <h:outputText value="#{dm.dispenseId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Medicine Name" /></f:facet>
            <h:outputText value="#{dm.medicines.medicineName}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Quantity Dispensed" /></f:facet>
            <h:outputText value="#{dm.quantityDispensed}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Dispense Date" /></f:facet>
            <h:outputText value="#{dm.dispenseDate}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Prescription ID" /></f:facet>
            <h:outputText value="#{dm.prescriptionId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Doctor ID" /></f:facet>
            <h:outputText value="#{dm.doctorId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Patient H-ID" /></f:facet>
            <h:outputText value="#{dm.hId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputLabel value="Pharmacist Name" /></f:facet>
            <h:outputText value="#{dm.pharmacistName}" />
        </h:column>
    </h:dataTable>

    <h:form>
        <h:commandButton value="Back" action="showpharmacyforreview?faces-redirect=true" />
    </h:form>

</body>
</html>
</f:view>
