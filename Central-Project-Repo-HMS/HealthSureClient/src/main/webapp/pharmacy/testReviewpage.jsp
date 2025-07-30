<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
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
  justify-content: center;
  flex-direction: column;
  margin: 40px auto;
  width: 95%;
  max-width: 1240px;
  background-color: #ffffff;
  border-radius: 16px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
  padding: 20px;
  border: 2px solid #e0e0e0;
}

h\:dataTable {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

h\:column, th, td {
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
  justify-content: center;
  align-items: center;
  gap: 8px;
}

td {
  background-color: #f5f5f5;
  color: #333;
}

.h-panelgroup {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 6px; /* spacing between label and arrows */
}

.sort-icons-container {
  display: flex;
  flex-direction: column;
  margin-left: 4px;
}

.sort-icons {
  cursor: pointer;
  display: inline-block;
  margin: 2px 0;
  transition: filter 0.2s ease;
}

.sort-icons:hover {
  filter: brightness(0.7);
}

.sort-arrow {
  width: 14px;
  vertical-align: middle;
  background-color: transparent;
  mix-blend-mode: multiply;
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
  position: fixed;
  top: 20px;
  left: 50%;
  transform: translateX(-50%);
  background-color: #1976d2;
  color: white;
  padding: 12px 24px;
  border-radius: 8px;
  font-size: 16px;
  font-weight: bold;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
  z-index: 9999;
}

th a, th a:visited {
  color: #ffffff !important;
  text-decoration: none;
}
.sort-icons-container {
  display: flex;
  flex-direction: row;  /* vertical se horizontal */
  margin-left: 4px;
  gap: 4px; /* arrows ke beech thodi spacing */
}
.h-panelgroup {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 6px;
}

</style>
</head>
<body>

<!-- Include Fixed Navbar -->
<jsp:include page="/navbar/NavPharmacy.jsp" />

<!-- Spacing below navbar -->
<div style="margin-top: 100px;"></div>

<!-- Loader Message -->
<div id="loader">Validating, please wait...</div>

<!-- Global Messages -->
<h:messages id="globalMessages" globalOnly="true"
            style="position: fixed; top: 70px; left: 50%; transform: translateX(-50%);
                   background-color: #e3f2fd; color: #0d47a1; padding: 12px 24px;
                   border: 1px solid #90caf9; border-radius: 8px; font-size: 15px;
                   z-index: 9999; box-shadow: 0 4px 12px rgba(0,0,0,0.2);
                   text-align: center; width: auto; max-width: 90%;" />

<!-- JavaScript for loader and message -->
<script>
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
  }, 10000);
};
</script>

<!-- Pharmacy Table -->
<div class="table-container">
  <h:form>
    <h:dataTable value="#{reviewPharmacyController.paginatedPharmacies}"
                 var="pharmacy" border="1">

      <!-- Pharmacy ID Column -->
      <h:column>
        <f:facet name="header">
          <h:panelGroup styleClass="h-panelgroup" layout="block">
            <h:outputText value="Pharmacy ID" />
            <h:panelGroup layout="block" styleClass="sort-icons-container">
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('pharmacyId')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('pharmacyId')}" styleClass="sort-icons">
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
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('pharmacyName')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('pharmacyName')}" styleClass="sort-icons">
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
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('email')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('email')}" styleClass="sort-icons">
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
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('aadhar')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('aadhar')}" styleClass="sort-icons">
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
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('licenseNo')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('licenseNo')}" styleClass="sort-icons">
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
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('gstNo')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('gstNo')}" styleClass="sort-icons">
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
                         action="#{reviewPharmacyController.validatePharmacyDetails(pharmacy)}"
                         disabled="#{pharmacy.status eq 'ACCEPTED' or pharmacy.status eq 'REJECTED'}"
                         onclick="showLoader()" styleClass="action-button" />
      </h:column>

      <!-- Status Column -->
      <h:column>
        <f:facet name="header">
          <h:panelGroup styleClass="h-panelgroup" layout="block">
            <h:outputText value="Status" />
            <h:panelGroup layout="block" styleClass="sort-icons-container">
              <h:commandLink action="#{reviewPharmacyController.sortByAsc('status')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/up-arrow.png"
                                width="14" height="14" title="Sort Ascending" />
              </h:commandLink>
              <h:commandLink action="#{reviewPharmacyController.sortByDesc('status')}" styleClass="sort-icons">
                <h:graphicImage value="/resources/media/images/down-arrow.png"
                                width="14" height="14" title="Sort Descending" />
              </h:commandLink>
            </h:panelGroup>
          </h:panelGroup>
        </f:facet>
        <h:outputText value="#{pharmacy.status}" />
      </h:column>

    </h:dataTable>

    <!-- Pagination Controls -->
    <div style="text-align: center; margin-top: 30px;">
      <h:outputText value="Page #{reviewPharmacyController.page + 1} of #{reviewPharmacyController.totalPages}"
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
