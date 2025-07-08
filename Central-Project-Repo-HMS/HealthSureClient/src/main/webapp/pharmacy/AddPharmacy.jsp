<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pharmacy Registration</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/AddPharmacy.css">

    <script>
        function validateTermsOnly(event) {
            const checkbox = document.getElementById('form:termsCheckbox');
            if (!checkbox.checked) {
                alert("Please accept the Terms and Conditions to register.");
                event.preventDefault();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<jsp:include page="/navbar/NavAuthentication.jsp" />
<div class ="top">

<f:view>
    <h:form id="form" styleClass="form-container">
    
        <h2>Pharmacy Details</h2>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">Pharmacy Name <span style="color: red">*</span></label>
                <h:inputText id="pharmacyName" value="#{pharmacy.pharmacyName}" styleClass="form-input" />
                <h:message for="pharmacyName" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">License Number <span style="color: red">*</span></label>
                <h:inputText id="licenseNo" value="#{pharmacy.licenseNo}" styleClass="form-input" />
                <h:message for="licenseNo" style="color:red" />
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">GST Number <span style="color: red">*</span></label>
                <h:inputText id="gstNo" value="#{pharmacy.gstNo}" styleClass="form-input" />
                <h:message for="gstNo" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">Email <span style="color: red">*</span></label>
                <h:inputText id="email" value="#{pharmacy.email}" styleClass="form-input" />
                <h:message for="email" style="color:red" />
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">Contact Number <span style="color: red">*</span></label>
                <h:inputText id="contactNo" value="#{pharmacy.contactNo}" styleClass="form-input" />
                <h:message for="contactNo" style="color:red" />
            </div>
         <div class="form-group">
                <label class="form-label">PIN Code <span style="color: red">*</span></label>
                <h:inputText id="pinCode" value="#{pharmacy.pinCode}" styleClass="form-input" />
                <h:message for="pinCode" style="color:red" />
            </div>
         
        </div>

        <div class="form-row">
            <div class="form-group">
                <label class="form-label">City <span style="color: red">*</span></label>
                <h:inputText id="city" value="#{pharmacy.city}" styleClass="form-input" />
                <h:message for="city" style="color:red" />
            </div>
            <div class="form-group">
                <label class="form-label">State <span style="color: red">*</span></label>
                <h:inputText id="state" value="#{pharmacy.state}" styleClass="form-input" />
                <h:message for="state" style="color:red" />
            </div>
        </div>

        

        <div class="form-row">
        
           <div class="form-group">
                <label class="form-label">Address Line 1 <span style="color: red">*</span></label>
                <h:inputText id="addressLine1" value="#{pharmacy.addressLine1}" styleClass="form-input" />
                <h:message for="addressLine1" style="color:red" />
            </div>
            
        </div>

        <!-- Terms and Conditions Checkbox -->
        <div class="form" style="margin-top: 20px; display: flex; align-items: center;">
       
            <h:selectBooleanCheckbox id="termsCheckbox"  />
            <h:outputText value=" I accept all " style="margin-left: 3px;"  /> 
          <h:outputLink value="TermsCondition.jsp" target="_blank" style="margin-left: 5%; text-decoration: none; font-size: 14px; color:blue">terms&conditions</h:outputLink>
          
        </div>

        <!-- Submit Button -->
        <h:commandButton id="submitBtn"
                         value="Register"
                         action="#{controller.registerPharmacy}"
                         styleClass="submit-button"
                         style="margin-top: 15px;"
                         onclick="return validateTermsOnly(event);" />

        <p style="font-size: 12px; color: #777;">
            Fields marked with <span style="color:red">*</span> are required.
        </p>
    </h:form>
</f:view>
</div>
    <jsp:include page="/footer/Footer.jsp" />

</body>
</html>
