<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Employee</title>
    </head>
    <body><sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        
        
       <c:if test="${pageContext.request.method=='POST'}">

           
        <h1>Hello World!</h1>
        
        <sql:update dataSource="${mydata}" var="result">
        INSERT into employees values(?,?,?,?,?,?);
        <sql:param value="${param.empno}" />
            <sql:param value="${param.birthdate}" />
            <sql:param value="${param.firstname}" />
            <sql:param value="${param.lastname}" />
            <sql:param value="${param.gender}" />
            <sql:param value="${param.hiredate}" />
        </sql:update>
        
        <c:if test="${result>=1}">
            <c:out value="Data inserted successfully."></c:out>
        </c:if>
       </c:if>
        <form method="post">
            Employee Number: <input type="number" name="empno"/><br/>
    First Name: <input type="text" name="firstname" /><br/>
  Last Name:  <input type="text" name="lastname" /><br/>
  Birth Date: <input type="date" name="birthdate" /><br/>
  Gender: <input type="radio" name="gender" value="M"> M <input type="radio" name="gender" value="F"> F<br/>
  Hire Date: <input type="date" name="hiredate" /><br/>
  <input type="submit" value="Submit">
        </form>
    </body>
</html>
