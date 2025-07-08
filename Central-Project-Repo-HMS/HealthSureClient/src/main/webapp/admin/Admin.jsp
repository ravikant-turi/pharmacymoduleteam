<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Provider Home</title>
    <!-- Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">

<f:view>
    <!-- ✅ Include Fixed Navbar -->
    <jsp:include page="/navbar/NavProvider.jsp" />

    <!-- ✅ Main Content -->
    <div class="max-w-4xl mx-auto pt-28 px-4 text-center mb-20">

        <!-- ✅ Welcome Message -->
        <h1 class="text-4xl font-bold text-blue-700 mb-4">
            Welcome, <h:outputText value="#{sessionScope.provider_name}" />
        </h1>

        <!-- ✅ Provider Details Section -->
        <div class="bg-white p-6 rounded-xl shadow-md text-left text-gray-800 mb-8 space-y-1">
            <p><strong>Provider ID:</strong> <h:outputText value="#{sessionScope.provider_id}" /></p>
            <p><strong>Hospital Name:</strong> <h:outputText value="#{sessionScope.hospital_name}" /></p>
            <p><strong>Email:</strong> <h:outputText value="#{sessionScope.email}" /></p>
            <p><strong>Address:</strong> <h:outputText value="#{sessionScope.address}" /></p>
            <p><strong>City:</strong> <h:outputText value="#{sessionScope.city}" /></p>
            <p><strong>State:</strong> <h:outputText value="#{sessionScope.state}" /></p>
            <p><strong>ZIP Code:</strong> <h:outputText value="#{sessionScope.zip_code}" /></p>
        </div>

        <!-- ✅ Action Buttons -->
        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
		    <h:form>
		        <h:commandButton value="Manage Appointments" action="#{providerBean.manageAppointments}"
		            styleClass="w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold shadow-lg transition-all duration-300 transform hover:-translate-y-1 hover:scale-105" />
		    </h:form>
		    <h:form>
		        <h:commandButton value="View Medical History" action="#{providerBean.viewHistory}"
		            styleClass="w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold shadow-lg transition-all duration-300 transform hover:-translate-y-1 hover:scale-105" />
		    </h:form>
		    <h:form>
		        <h:commandButton value="Create Claim" action="#{providerBean.createClaim}"
		            styleClass="w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold shadow-lg transition-all duration-300 transform hover:-translate-y-1 hover:scale-105" />
		    </h:form>
		    <h:form>
		        <h:commandButton value="Search Payments" action="#{providerBean.searchPayments}"
		            styleClass="w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold shadow-lg transition-all duration-300 transform hover:-translate-y-1 hover:scale-105" />
		    </h:form>
		</div>
    </div>
</f:view>

<!-- ✅ Footer -->
<jsp:include page="/footer/Footer.jsp" />
</body>
</html>
