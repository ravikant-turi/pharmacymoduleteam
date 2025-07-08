<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<html>
<head>
<title>View Medicines</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/ViewMedicines.css" />
</head>
<body>
	<jsp:include page="/navbar/NavPharmacy.jsp" />

	<div class="top">
		<h2>Medicine Stocks</h2>

		<!-- Search -->
		<h:form id="searchForm">
			<h:panelGrid columns="4" cellpadding="5">
				<h:outputLabel value="Search:" />
				<h:inputText value="#{viewController.searchText}" />
				<h:selectOneRadio value="#{viewController.searchMode}">
					<f:selectItem itemValue="starts" itemLabel="Starts With" />
					<f:selectItem itemValue="contains" itemLabel="Contains" />
				</h:selectOneRadio>
				<h:commandButton value="Search"
					action="#{viewController.searchMedicines}" />

			</h:panelGrid>
		</h:form>

		<!-- Table -->
		<h:form id="tableForm">
			<h:panelGroup rendered="#{not empty viewController.medicinesList}">
				<h:dataTable value="#{viewController.paginatedMedicines}" var="med"
					border="1" styleClass="table">

					<!-- Medicine ID -->
					<h:column>
						<f:facet name="header">
							<h:outputText value="ID" />
						</f:facet>
						<h:outputText value="#{med.medicineId}" />
					</h:column>

					<!-- Medicine Name (Sortable) -->
					<h:column>
						<f:facet name="header">
							<h:commandLink
								value="Name #{viewController.sortBy eq 'medicineName' ? (viewController.ascending ? '↑' : '↓') : ''}"
								action="#{viewController.toggleSort('medicineName')}" />
						</f:facet>
						<h:outputText value="#{med.medicineName}" />
					</h:column>

					<!-- Description -->
					<h:column>
						<f:facet name="header">
							<h:outputText value="Description" />
						</f:facet>
						<h:outputText value="#{med.description}" />
					</h:column>

					<!-- Stock -->
					<h:column>
						<f:facet name="header">
							<h:outputText value="Stock" />
						</f:facet>
						<h:outputText value="#{med.quantityInStock}" />
					</h:column>

					<!-- Price (Sortable) -->
					<h:column>
						<f:facet name="header">
							<h:commandLink
								value="Price #{viewController.sortBy eq 'unitPrice' ? (viewController.ascending ? '↑' : '↓') : ''}"
								action="#{viewController.toggleSort('unitPrice')}" />
						</f:facet>
						<h:outputText value="#{med.unitPrice}" />
					</h:column>

					<!-- Expiry Date (Sortable) -->
					<h:column>
						<f:facet name="header">
							<h:commandLink
								value="Expiry #{viewController.sortBy eq 'expiryDate' ? (viewController.ascending ? '↑' : '↓') : ''}"
								action="#{viewController.toggleSort('expiryDate')}" />
						</f:facet>

						<h:outputText value="#{med.expiryDate}"
							style="#{viewController.getExpiryStyle(med.expiryDate)}">
							<f:convertDateTime pattern="dd-MM-yyyy" timeZone="Asia/Kolkata" />
						</h:outputText>

					</h:column>

				</h:dataTable>

				<!-- Pagination Controls -->
				<div style="text-align: center; margin-top: 20px;">
					<h:commandButton value="<-Prev"
						action="#{viewController.previousPage}"
						disabled="#{viewController.currentPage == 1}" />
					<h:outputText
						value=" Page #{viewController.currentPage} of #{viewController.totalPages} "
						style="margin: 0 10px;" />
					<h:commandButton value="Next ->;"
						action="#{viewController.nextPage}"
						disabled="#{viewController.currentPage == viewController.totalPages}" />
				</div>
			</h:panelGroup>

			<!-- No Results Message -->
			<h:panelGroup rendered="#{empty viewController.medicinesList}">
				<div style="text-align: center; color: red; margin-top: 20px;">
					<h:outputText value="No result found for: " />
					<h:outputText value="#{viewController.searchText}"
						style="font-weight:bold;" />
				</div>
			</h:panelGroup>
		</h:form>
	</div>

	<jsp:include page="/footer/Footer.jsp" />
</body>
	</html>
</f:view>
