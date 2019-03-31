<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "es_CO"/>
<html>
    <head>
    </head>
    <body>
        <style>
            td,th {
                padding: 20px;
            }
        </style>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Contract Type Name</th>
                    <th>Role ID</th>
                    <th>Role Name</th>
                    <th>Role Description</th>
                    <th>Hourly Salary</th>
                    <th>Monthly Salary</th>
                    <th>Annual Salary</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    <%@ include file="employee-info.jspf" %>
                </c:forEach>
            </tbody>
        </table>
    </body>
    <%@ include file="employee-form.jspf" %>
</html>