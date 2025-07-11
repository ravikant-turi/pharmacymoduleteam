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
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(to right, #fdfbfb, #ebedee);
	padding: 40px;
	margin: 0;
}

.table-container {
	display: flex;
	justify-content: center; column;
	margin: 40px auto;
	width: 95%;
	max-width: 1200px;
	background-color: #ffffff;
	border-radius: 16px;
	box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
	padding: 40px;
	border: 2px solid #e0e0e0;
}

h\\:dataTable {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

h\\:column, th, td {
	padding: 16px;
	border: 1px solid #ddd;
	text-align: center;
	font-size: 15px;
}

th {
	background-color: #1976d2;
	color: #ffffff;
	font-weight: bold;
	text-transform: uppercase;
	letter-spacing: 0.5px;
}

td {
	background-color: #f5f5f5;
	color: #333;
}

.action-button {
	background-color: #0288d1;
	border: none;
	color: white;
	padding: 10px 20px;
	font-size: 14px;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

.action-button:hover {
	background-color: #01579b;
	transform: scale(1.05);
}

.message-box {
	background-color: #e3f2fd;
	color: #0d47a1;
	padding: 16px;
	border: 1px solid #90caf9;
	border-radius: 8px;
	margin: 20px auto;
	font-size: 15px;
	width: 90%;
	max-width: 1200px;
	text-align: center;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

#loader {
	display: none;
	margin-bottom: 20px;
	text-align: center;
}

#loader p {
	color: #1976d2;
	font-size: 18px;
	font-weight: bold;
	margin: 0;
}
th a, th a:visited {
    color: #ffffff !important;
    text-decoration: none;
}

</style>
</head>
<body>

	<!-- ✅ Include Fixed Navbar -->
	<jsp:include page="/navbar/NavPharmacy.jsp" />

	<!-- ✅ Add spacing below navbar -->
	<div style="margin-top: 100px;"></div>

	<!-- ✅ Loader Message -->
	<div id="loader"
		style="display: none; position: fixed; top: 20px; left: 50%; transform: translateX(-50%); background-color: #1976d2; color: white; padding: 12px 24px; border-radius: 8px; font-size: 16px; font-weight: bold; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); z-index: 9999;">
		Validating, please wait...</div>


	<h:messages id="globalMessages" globalOnly="true"
    style="position: fixed; top: 70px; left: 50%; transform: translateX(-50%);
           background-color: #e3f2fd; color: #0d47a1; padding: 12px 24px;
           border: 1px solid #90caf9; border-radius: 8px; font-size: 15px;
           z-index: 9999; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); text-align: center;
           width: auto; max-width: 90%;" />

	<!-- ✅ JavaScript for loader and message -->
	<Script>
		function showLoader() {
			document.getElementById('loader').style.display = 'block';
		}

		window.onload = function() {
			setTimeout(function() {
				var msgBox = document.getElementById('globalMessages');
				if (msgBox) {
					msgBox.style.display = 'none';
				}
				document.getElementById('loader').style.display = 'none';
			}, 10000); // Hide loader and message after 10 seconds
		};
	</Script>

	<!-- ✅ Pharmacy Table -->
	<div class="table-container">
		<h:form>
			<h:dataTable value="#{reviewPharmacyController.paginatedPharmacies}"
				var="pharmacy" border="1">

				<h:column>
					<f:facet name="header">
						<h:commandLink value="Pharmacy ID"
							action="#{reviewPharmacyController.sort('pharmacyId')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.pharmacyId}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="Pharmacy Name"
							action="#{reviewPharmacyController.sort('pharmacyName')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.pharmacyName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="Email"
							action="#{reviewPharmacyController.sort('email')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.email}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="Aadhar"
							action="#{reviewPharmacyController.sort('aadhar')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.aadhar}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="License No"
							action="#{reviewPharmacyController.sort('licenseNo')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.licenseNo}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="GST Number"
							action="#{reviewPharmacyController.sort('gstNo')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.gstNo}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Validation" />
					</f:facet>
					<h:commandButton value="Validate"
						action="#{reviewPharmacyController.validatePharmacy(pharmacy)}"
                         disabled="#{pharmacy.status eq 'ACCEPTED' or pharmacy.status eq 'REJECTED'}"

                          
						 onclick="showLoader()" styleClass="action-button" />
						
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:commandLink value="Status"
							action="#{reviewPharmacyController.sort('status')}" />
					</f:facet>
					<h:outputText value="#{pharmacy.status}" />
				</h:column>

			</h:dataTable>

			<!-- Pagination Controls -->
			<div style="text-align: center; margin-top: 30px;">
				<h:outputText
					value="Page #{reviewPharmacyController.page + 1} of #{reviewPharmacyController.totalPages}"
					style="margin-right: 20px; font-weight: bold;" />

				<h:commandButton value="Previous"
					action="#{reviewPharmacyController.previousPage}"
					disabled="#{reviewPharmacyController.page eq 0}"
					style="margin-right: 10px;" styleClass="action-button" />

				<h:commandButton value="Next"
					action="#{reviewPharmacyController.nextPage}"
					disabled="#{reviewPharmacyController.page + 1 ge reviewPharmacyController.totalPages}"
					style="margin-left: 10px;" styleClass="action-button" />
			</div>

		</h:form>

	</div>

</body>
	</html>
</f:view>
