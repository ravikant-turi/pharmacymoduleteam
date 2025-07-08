<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Subscribed Family Members</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8fcff;
            margin: 0;
            padding: 20px;
            color: #003366;
        }
        h2 {
            text-align: center;
            color: #0077b6;
            margin-bottom: 25px;
        }
        .data-table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            margin-top: 20px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }
        .data-table th, .data-table td {
            padding: 10px;
            border: 1px solid #cce0ff;
            text-align: left;
        }
        .data-table th {
            background-color: #d0f0f3;
            color: #003c58;
        }
        .data-table tr:nth-child(even) {
            background-color: #f1faff;
        }
        .data-table tr:hover {
            background-color: #e0f7ff;
        }
    </style>
</head>
<body>

<h2>Subscribed Family Members</h2>

<h:form>
    <h:dataTable value="#{recipientController.loadSubscribedMembers().subscribedMembers}" var="member"
                 rendered="#{not empty recipientController.loadSubscribedMembers().subscribedMembers}"
                 styleClass="data-table">

        <h:column>
            <f:facet name="header"><h:outputText value="Member ID" /></f:facet>
            <h:outputText value="#{member.memberId}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Full Name" /></f:facet>
            <h:outputText value="#{member.fullName}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Age" /></f:facet>
            <h:outputText value="#{member.age}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Gender" /></f:facet>
            <h:outputText value="#{member.gender}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Relation" /></f:facet>
            <h:outputText value="#{member.relationWithProposer}" />
        </h:column>

        <h:column>
            <f:facet name="header"><h:outputText value="Aadhar No" /></f:facet>
            <h:outputText value="#{member.aadharNo}" />
        </h:column>
    </h:dataTable>
</h:form>

</body>
</html>
</f:view>
