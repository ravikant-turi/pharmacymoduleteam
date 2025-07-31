<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Pharmacy Review Table</title>
<style>
/* --- Fresh CSS for Responsive Design --- */

/* Base Body Styles */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #f0f4f8 0%, #d9e2ec 100%);
    padding: 40px;
    margin: 0;
    color: #2c3e50;
    box-sizing: border-box; /* Ensures padding doesn't add to total width */
}

/* Responsive Body Padding */
@media (max-width: 768px) {
    body {
        padding: 15px; /* Smaller padding on mobile */
    }
}

/* Spacing below Navbar */
.navbar-spacing {
    margin-top: 100px; /* Default spacing */
}
@media (max-width: 768px) {
    .navbar-spacing {
        margin-top: 70px; /* Reduced spacing for smaller screens */
    }
}

/* Table Container Styles */
.table-container {
    display: flex;
    flex-direction: column;
    align-items: center; /* Center content horizontally */
    margin: 40px auto;
    width: 95%;
    max-width: 1240px;
    background-color: #ffffff;
    border-radius: 16px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    padding: 50px;
    border: 2px solid #e0e0e0;
    box-sizing: border-box; /* Ensures padding doesn't add to total width */
}

/* Responsive Table Container Padding and Margin */
@media (max-width: 768px) {
    .table-container {
        padding: 20px; /* Reduce padding on smaller screens */
        margin: 20px auto; /* Adjust margin */
    }
}

.table-container:hover {
    box-shadow: 0 12px 22px rgba(46, 61, 73, 0.25);
}

/* Table Responsive Wrapper - Key for Horizontal Scroll */
.table-responsive-wrapper {
    width: 100%; /* Take full width of parent */
    overflow-x: auto; /* Enable horizontal scrolling */
    -webkit-overflow-scrolling: touch; /* Smooth scrolling on iOS */
    border-radius: 8px;
    padding-bottom: 10px; /* Space for scrollbar */
}

/* Table Heading */
.table-responsive-wrapper h2 {
    text-align: center;
    margin-bottom: 20px; /* Space between heading and table */
    font-size: 2em; /* Default font size for h2 */
    color: #2c3e50;
    padding: 10px 0;
}
@media (max-width: 600px) {
    .table-responsive-wrapper h2 {
        font-size: 1.5em; /* Smaller font size on mobile */
    }
}

/* h:dataTable rendered as <table> */
table[border="1"] {
    width: 100%; /* Ensure table takes full width of its wrapper */
    border-collapse: separate;
    border-spacing: 0 12px; /* Vertical space between rows */
    margin-top: 0; /* Adjusted margin as heading is now inside wrapper */
    min-width: 800px; /* Minimum width to trigger horizontal scroll on small screens */
    border-radius: 8px; /* Rounded corners for the entire table */
}

/* Table Header (th) and Data Cells (td) */
th, td {
    padding: 16px 20px;
    text-align: center;
    font-size: 15px;
    vertical-align: middle;
    white-space: nowrap; /* Prevent text wrapping in cells */
}

/* Table Header Specific Styles */
th {
    background-color: #ffffff; /* White background for headers */
    color: black; /* Black text for headers */
    font-weight: 500;
    text-transform: uppercase;
    letter-spacing: 1px;
    border: none;
    border-radius: 8px; /* Rounded corners for header cells */
    user-select: none;
    cursor: default;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.08); /* Subtle shadow for headers */
}

/* Table Data Cell Specific Styles */
td {
    background-color: #f7f9fb; /* Very light blue-gray */
    color: #34495e; /* Darker text */
    border-radius: 6px; /* Rounded corners for data cells */
    border: none;
    box-shadow: 0 1px 3px rgba(149, 157, 165, 0.2);
    transition: background-color 0.15s ease;
}

/* Table Row Hover Effect */
table[border="1"] tr:hover td {
    background-color: #e1e8f0;
    color: #1f2937;
}

/* Header Panel Group for Text and Sort Icons */
.h-panelgroup {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 6px;
}

/* Sort Icons Container */
.sort-icons-container {
    display: flex;
    flex-direction: row;
    margin-left: 6px;
    gap: 6px;
}

/* Sort Icons (Links) */
.sort-icons {
    cursor: pointer;
    display: inline-block;
    margin: 0;
    transition: filter 0.25s ease;
}
.sort-icons:hover {
    filter: brightness(0.75);
}

/* Sort Arrow Images */
.sort-arrow { /* This class is not directly used in your HTML, but keeping it for completeness */
    width: 14px;
    height: 14px;
    vertical-align: middle;
    background-color: transparent;
    mix-blend-mode: multiply;
    filter: drop-shadow(0 0 1px rgba(0, 0, 0, 0.15));
}

/* Action Button Styles (Validate Button) */
.action-button {
    background-color: #0052cc;
    border: none;
    color: white;
    padding: 12px 28px;
    font-size: 15px;
    border-radius: 10px;
    font-weight: 600;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.15s ease;
    box-shadow: 0 4px 10px rgba(0, 82, 204, 0.35);
    user-select: none;
    min-width: 100px; /* Ensure button has a minimum width */
}

.action-button:hover:not(:disabled) {
    background-color: #003d99;
    transform: scale(1.07);
    box-shadow: 0 6px 15px rgba(0, 61, 153, 0.5);
}

.action-button:disabled {
    background-color: #a1a6b0;
    cursor: not-allowed;
    box-shadow: none;
    transform: none;
}

/* Message Box (globalMessages) */
#globalMessages {
    position: fixed;
    top: 70px;
    left: 50%;
    transform: translateX(-50%);
    background-color: #e3f2fd;
    color: #0d47a1;
    padding: 12px 24px;
    border: 1px solid #90caf9;
    border-radius: 8px;
    font-size: 15px;
    z-index: 9999;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: auto;
    max-width: 90%; /* Responsive width */
    box-sizing: border-box;
}

/* Loader Message */
#loader {
    display: none;
    position: fixed;
    top: 20px;
    left: 50%;
    transform: translateX(-50%);
    background-color: #0052cc;
    color: white;
    padding: 14px 28px;
    border-radius: 10px;
    font-size: 17px;
    font-weight: 600;
    box-shadow: 0 6px 20px rgba(0, 82, 204, 0.4);
    z-index: 9999;
    user-select: none;
    max-width: 90%; /* Responsive width */
    box-sizing: border-box;
}

/* Corrected color for links inside table headers */
th a, th a:visited {
    color: black !important; /* Ensure links are visible */
    text-decoration: none;
}

/* Pagination Controls */
.pagination-controls {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap; /* Allow items to wrap on smaller screens */
    margin-top: 30px;
    gap: 15px; /* Spacing between pagination elements */
    width: 100%; /* Take full width of parent */
}

.pagination-text {
    font-weight: 600;
    color: #2c3e50;
    text-align: center;
    flex-basis: 100%; /* Take full width on small screens */
    margin-bottom: 10px; /* Space below text when buttons wrap */
}

@media (min-width: 600px) { /* On larger screens, text and buttons can be on one line */
    .pagination-text {
        flex-basis: auto; /* Allow text to shrink */
        margin-right: 20px; /* Original margin */
        margin-bottom: 0; /* Remove bottom margin */
    }
}

/* --- End of Fresh CSS --- */
</style>
</head>
<body>

	<!-- Include Fixed Navbar -->
	<jsp:include page="/navbar/NavPharmacy.jsp" />

	<!-- Spacing below navbar - now using a responsive class -->
	<div class="navbar-spacing"></div>

	<!-- Loader Message -->
	<div id="loader">
		Validating, please wait...</div>


	<h:messages id="globalMessages" globalOnly="true" />

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

	<!-- Pharmacy Table -->
	<div class="table-container">
		<h:form>
            <!-- New responsive wrapper for the dataTable and heading -->
            <div class="table-responsive-wrapper">
                <h2 style="text-align: center;">PHARMACY REVIEW AND APPROVAL</h2>
                <h:dataTable value="#{reviewPharmacyController.paginatedPharmacies}"
                    var="pharmacy" border="1">

                    <!-- Pharmacy ID Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="Pharmacy ID" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('pharmacyId')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('pharmacyId')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.pharmacyId}" />
                    </h:column>

                    <!-- Pharmacy Name Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="Name" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('pharmacyName')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('pharmacyName')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.pharmacyName}" />
                    </h:column>

                    <!-- Email Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="Email" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('email')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('email')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.email}" />
                    </h:column>

                    <!-- Aadhar Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="Aadhar" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('aadhar')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('aadhar')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.aadhar}" />
                    </h:column>

                    <!-- License No Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="License No" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('licenseNo')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('licenseNo')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.licenseNo}" />
                    </h:column>

                    <!-- GST Number Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="GST Number" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('gstNo')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('gstNo')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.gstNo}" />
                    </h:column>

                    <!-- Validation Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Validation" />
                        </f:facet>
                        <h:commandButton value="Validate"
                            action="#{reviewPharmacyController.validatePharmacy(pharmacy)}"
                            disabled="#{pharmacy.status eq 'ACCEPTED' or pharmacy.status eq 'REJECTED'}"
                            onclick="showLoader()" styleClass="action-button" />
                    </h:column>

                    <!-- Status Column -->
                    <h:column>
                        <f:facet name="header">
                            <h:panelGroup styleClass="h-panelgroup" layout="block">
                                <h:outputText value="Status" />
                                <h:panelGroup layout="block" styleClass="sort-icons-container">
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByAsc('status')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/up-arrow.png"
                                            width="14" height="14" title="Sort Ascending" />
                                    </h:commandLink>
                                    <h:commandLink
                                        action="#{reviewPharmacyController.sortByDesc('status')}"
                                        styleClass="sort-icons">
                                        <h:graphicImage value="/resources/media/images/down-arrow.png"
                                            width="14" height="14" title="Sort Descending" />
                                    </h:commandLink>
                                </h:panelGroup>
                            </h:panelGroup>
                        </f:facet>
                        <h:outputText value="#{pharmacy.status}" />
                    </h:column>

                </h:dataTable>
            </div> <!-- End of table-responsive-wrapper -->

			<!-- Pagination Controls - now using a responsive class -->
			<div class="pagination-controls">
				<h:outputText
					value="Page #{reviewPharmacyController.page + 1} of #{reviewPharmacyController.totalPages}"
					styleClass="pagination-text" />

				<h:commandButton value="Previous"
					action="#{reviewPharmacyController.previousPage}"
					disabled="#{reviewPharmacyController.page eq 0}"
					styleClass="action-button" />

				<h:commandButton value="Next"
					action="#{reviewPharmacyController.nextPage}"
					disabled="#{reviewPharmacyController.page + 1 ge reviewPharmacyController.totalPages}"
					styleClass="action-button" />
			</div>

		</h:form>
	</div>

</body>
	</html>
</f:view>
           