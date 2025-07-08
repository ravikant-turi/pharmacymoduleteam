<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Owner Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/AddPharmacy.css">
</head>
<body>
<jsp:include page="/navbar/NavAuthentication.jsp" />
<div class ="top">
    <h:form id="form" styleClass="form-container">
        <h2>Owner Details</h2>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">First Name <span style="color: red">*</span></label>
                <h:inputText id="firstName" value="#{pharmacy.firstName}" styleClass="form-input" />
                <h:message for="firstName" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">Middle Name</label>
                <h:inputText id="middleName" value="#{pharmacy.middleName}" styleClass="form-input" />
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">Last Name <span style="color: red">*</span></label>
                <h:inputText id="lastName" value="#{pharmacy.lastName}" styleClass="form-input" />
                <h:message for="lastName" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">Gender <span style="color: red">*</span></label>
                <h:selectOneMenu id="gender" value="#{pharmacy.gender}" styleClass="form-input">
                    <f:selectItem itemLabel="Select" itemValue="" />
                    <f:selectItem itemLabel="Male" itemValue="Male" />
                    <f:selectItem itemLabel="Female" itemValue="Female" />
                    <f:selectItem itemLabel="Other" itemValue="Other" />
                </h:selectOneMenu>
                <h:message for="gender" style="color:red" />
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">Mobile Number <span style="color: red">*</span></label>
                <h:inputText id="ownerMobile" value="#{pharmacy.ownerMobile}" styleClass="form-input" />
                <h:message for="ownerMobile" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">Email <span style="color: red">*</span></label>
                <h:inputText id="ownerEmail" value="#{pharmacy.ownerEmail}" styleClass="form-input" />
                <h:message for="ownerEmail" style="color:red" />
            </div>
            
            
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">Aadhar Number <span style="color: red">*</span></label>
                <h:inputText id="aadharNo" value="#{pharmacy.aadhar}" styleClass="form-input" />
                <h:message for="aadharNo" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">Owner Address <span style="color: red">*</span></label>
                <h:inputText id="ownerAddress" value="#{pharmacy.ownerAddress}" styleClass="form-input" />
                <h:message for="ownerAddress" style="color:red" />
            </div>
        </div>

        <h:commandButton value="Next" 
                     action="#{controller.proceedToPharmacyDetails}" 
                     styleClass="submit-button" />


        <p style="font-size: 12px; color: #777;">
            Fields marked with <span style="color:red">*</span> are mandatory.
        </p>
    </h:form>
  </div>
    <jsp:include page="/footer/Footer.jsp" />

</body>
</html>
</f:view>
