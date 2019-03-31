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
        <c:choose>
            <c:when test="${employee ne null}">
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
                        <%@ include file="employee-info.jspf" %>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h3>Employee not found</h3>
            </c:otherwise>
        </c:choose>
    </body>
    <%@ include file="employee-form.jspf" %>
</html>