<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<h1>I am departments.jsp</h1>

<table role="grid">
    <thead>
        <tr>
            <th width="200">Department ID</th>
            <th width="200">Department Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${departments}" var="departments">
            <tr>
                <td>${departments.deptId}</td>
                <td>${departments.deptName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="/WEB-INF/footer.jspf" %>