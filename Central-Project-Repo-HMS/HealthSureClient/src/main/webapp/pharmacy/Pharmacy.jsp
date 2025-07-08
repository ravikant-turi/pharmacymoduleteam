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
    <jsp:include page="/navbar/NavPharmacy.jsp" />

    <!-- ✅ Main Content -->
    <div class="max-w-4xl mx-auto pt-28 px-4 text-center mb-20">

       

        <!-- ✅ Action Buttons -->
        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
		    <h:form>
		        <h:commandButton value="View Medicines Stocks" action="#{viewController.ViewMedicineStocks}"
		            styleClass="w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-xl font-semibold shadow-lg transition-all duration-300 transform hover:-translate-y-1 hover:scale-105" />
		    </h:form>
		    <h:form>
		        <h:commandButton value="View Equipments Stocks" action="#{viewEquipmentController.ViewPharmacyStocks}"
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
