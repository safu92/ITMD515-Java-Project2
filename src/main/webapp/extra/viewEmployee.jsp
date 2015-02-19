<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
                     <c:if test="${pageContext.request.method=='POST'}">

        <sql:query dataSource="${mydata}" var="result">
        SELECT * from employees where emp_no='${param.id}';
        </sql:query>
        <h1>Hello World!</h1>
                     <table border="1" width="100%">
<tr>
<th>Emp ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>Birth Date</th>
<th>Hire Date</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.emp_no}"/></td>
<td><c:out value="${row.first_name}"/></td>
<td><c:out value="${row.last_name}"/></td>
<td><c:out value="${row.gender}"/></td>
<td><c:out value="${row.birth_date}"/></td>
<td><c:out value="${row.hire_date}"/></td>
</tr>
</c:forEach>
</table>
             </c:if>
        <form name="viewEmployee" method="post">
            Enter Employee Id:<input type="text" name="id"/><br/>
            <input type="submit" name="Submit"><br/>
            
        </form>
    </body>
</html>
