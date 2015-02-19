<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<h1>I am employees.jsp</h1>

<table role="grid">
    <thead>
        <tr>
            <th width="100">Customer ID</th>
            <th width="200">First Name</th>
            <th width="300">Last Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${requestScope.employees}" var="employee">
            <tr>
                <td>${employee.empId}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="/WEB-INF/footer.jspf" %>