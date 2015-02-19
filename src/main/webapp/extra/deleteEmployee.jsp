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
        
        <sql:update dataSource="${mydata}" var="result">
        Delete from employees where emp_no='${param.id}';
        </sql:update>
        <h1>Hello World!</h1>
        <c:if test="${result>=1}">
            <c:out value="Data deleted successfully"></c:out>
        </c:if>
         <form name="viewEmployee" method="post">
            Enter Employee Id:<input type="text" name="id"/><br/>
            <input type="submit" name="Submit"><br/>
         </form>
    </body>
</html>
