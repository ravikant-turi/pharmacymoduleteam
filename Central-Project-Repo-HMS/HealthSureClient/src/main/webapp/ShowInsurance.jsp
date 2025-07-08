<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Subscription Plans</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 40px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 5px;
            margin-bottom: 10px;
            width: 200px;
        }

        .button-group h\:commandButton {
            padding: 4px 10px;
            margin-right: 6px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            font-size: 14px;
        }

        th, td {
            border: 1px solid #aaa;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #ddd;
        }

        tr:hover td {
            background-color: #f5f5f5;
        }

        .form-section {
            max-width: 1000px;
            margin: auto;
        }
    </style>
</head>
<body>

<div class="form-section">
    <h:form>
        <h2>Subscription Plans</h2>

        <label>Enter Recipient ID:</label><br/>
        <h:inputText value="#{subscriptionController.recipientId}" /><br/>

        <div class="button-group">
            <h:commandButton value="Show All Plans" action="#{subscriptionController.fetchAllPlansForRecipient}" />
            <h:commandButton value="Show Active Plans" action="#{subscriptionController.fetchActivePlansForRecipient}" />
            <h:commandButton value="Show Expired Plans" action="#{subscriptionController.fetchExpiredPlansForRecipient}" />
        </div>

        <h:dataTable value="#{subscriptionController.subscriptionList}" var="sub">
                   
                
            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Subscription"/>
                </f:facet>
                <h:outputText value="#{sub.subscriptionId}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Recipient ID"/>
                </f:facet>
                <h:outputText value="#{sub.recipient.hId}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Coverage ID"/>
                </f:facet>
                <h:outputText value="#{sub.coverage.coverageId}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Subscribe Date"/>
                </f:facet>
                <h:outputText value="#{sub.subscribeDate}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Expiry Date"/>
                </f:facet>
                <h:outputText value="#{sub.expiryDate}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value= "Status"/>
                </f:facet>
                <h:outputText value="#{sub.status}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Total Premium"/>
                </f:facet>
                <h:outputText value="#{sub.totalPremium}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                <h:outputLabel value = "Amount Paid"/>
                </f:facet>
                <h:outputText value="#{sub.amountPaid}" />
            </h:column>
        </h:dataTable>
    </h:form>
</div>

</body>
</html>
</f:view>
