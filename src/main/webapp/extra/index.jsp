<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:out value="Hi"></c:out><br/>
        <a href="<c:url value='/extra/newEmployee.jsp'/>">Add New Employee</a><br/>
        <a href="<c:url value='/extra/viewEmployee.jsp'/>">View Employee</a>
    </body>
</html>
