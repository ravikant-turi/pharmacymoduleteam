<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
<head>
    <title>View Equipment</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ViewMedicines.css" />
</head>
<body>
<jsp:include page="/navbar/NavPharmacy.jsp" />

<div class="top">
    <h2>Equipment Stocks</h2>

    <!-- Search -->
<h:form id="searchForm">
    <h:panelGrid columns="4" cellpadding="5" styleClass="search-grid">
        <h:outputLabel for="searchText" value="Search:" />
        <h:inputText id="searchText" value="#{viewEquipmentController.searchText}" />

        <h:selectOneRadio id="searchMode" value="#{viewEquipmentController.searchMode}" styleClass ="radio-inline">
            <f:selectItem itemValue="starts" itemLabel="Starts With" />
            <f:selectItem itemValue="contains" itemLabel="Contains" />
        </h:selectOneRadio>

        <h:commandButton id="searchBtn" value="Search" action="#{viewEquipmentController.searchEquipment}" />
    </h:panelGrid>
</h:form>


    <!-- Table -->
    <h:form id="tableForm">
        <h:panelGroup rendered="#{not empty viewEquipmentController.equipmentList}">
            <h:dataTable value="#{viewEquipmentController.paginatedEquipment}" var="med" border="1" styleClass="table">

    <!-- ID -->
    <h:column>
        <f:facet name="header"><h:outputText value="ID" /></f:facet>
        <h:outputText value="#{med.equipmentId}" />
    </h:column>

    <!-- Name (Sortable) -->
    <h:column>
        <f:facet name="header">
            <h:commandLink value="Name #{viewEquipmentController.sortBy eq 'equipmentName' ? (viewEquipmentController.ascending ? '↑' : '↓') : ''}"
                           action="#{viewEquipmentController.toggleSort('equipmentName')}" />
        </f:facet>
        <h:outputText value="#{med.equipmentName}" />
    </h:column>

    <!-- Description -->
    <h:column>
        <f:facet name="header"><h:outputText value="Description" /></f:facet>
        <h:outputText value="#{med.description}" styleClass ="desc-column" />
    </h:column>

    <!-- Quantity (Sortable) -->
    <h:column>
        <f:facet name="header">
            <h:commandLink value="Quantity #{viewEquipmentController.sortBy eq 'quantity' ? (viewEquipmentController.ascending ? '↑' : '↓') : ''}"
                           action="#{viewEquipmentController.toggleSort('quantity')}" />
        </f:facet>
        <h:outputText value="#{med.quantity}" />
    </h:column>

    <!-- Unit Price (Sortable) -->
    <h:column>
        <f:facet name="header">
            <h:commandLink value="Unit Price #{viewEquipmentController.sortBy eq 'unitPrice' ? (viewEquipmentController.ascending ? '↑' : '↓') : ''}"
                           action="#{viewEquipmentController.toggleSort('unitPrice')}" />
        </f:facet>
        <h:outputText value="#{med.unitPrice}" />
    </h:column>

    <!-- Purchase Date (Highlight only) -->
    <h:column>
        <f:facet name="header"><h:outputText value="Purchase Date" /></f:facet>
        <h:outputText value="#{med.purchaseDate}" />
                     
           
       
    </h:column>
     <!-- Status  -->
    <h:column>
    <f:facet name="header"><h:outputText value = "Status" /></f:facet>
    <h:outputText value = "#{med.status }" />  
    </h:column>

</h:dataTable>

            <!-- Pagination Controls -->
            <div style="text-align:center; margin-top: 20px;">
                <h:commandButton value="<- Prev" action="#{viewEquipmentController.previousPage}" disabled="#{viewEquipmentController.currentPage == 1}" styleClass="page-button" />
                <h:outputText value=" Page #{viewEquipmentController.currentPage} of #{viewEquipmentController.totalPages} " style="margin: 0 10px;" />
                <h:commandButton value="Next ->;" action="#{viewEquipmentController.nextPage}" disabled="#{viewEquipmentController.currentPage == viewEquipmentController.totalPages}" styleClass="page-button"/>
            </div>
        </h:panelGroup>

        <!-- No Results Message -->
        <h:panelGroup rendered="#{empty viewEquipmentController.equipmentList}">
            <div style="text-align:center; color:red; margin-top:20px;">
                <h:outputText value = "No result found for: " />
                <h:outputText value = "#{viewEquipmentController.searchText}" style = "font-weight:bold;" />
            </div>
        </h:panelGroup>
    </h:form>
</div>

<jsp:include page="/footer/Footer.jsp"/>
</body>
</html>
</f:view>
