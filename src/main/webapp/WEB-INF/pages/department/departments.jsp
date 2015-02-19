<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<center>
<c:if test="${requestScope.updateDept}">
    <h1>Data Updated Successfuly!</h1>
</c:if>

    
    <c:if test="${requestScope.createDept}">
    <h1>Data Inserted Successfuly!</h1>
</c:if>
    
    <c:if test="${requestScope.deleteDept}">
    <h1>Data Deleted Successfuly!</h1>
</c:if>
    
<h1>All Departments</h1>

<table role="grid">
    <thead>
        <tr>
            <th width="200">Department ID</th>
            <th width="200">Department Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${departments}" var="dept">
            <tr>
                <td><a href="${pageContext.request.contextPath}/department?id=${dept.deptId}">${dept.deptId}</a></td>
                <td>${dept.deptName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</center>
<%@include file="/WEB-INF/footer.jspf" %>