<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Employee</title>
    </head>
    <body>
        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        
        <c:if test="${param.id==null}">
                  
                <form name="updateEmployee1" method="post">
            Enter Employee Id:<input type="text" name="id"/><br/>
            <input type="submit" name="Submit"><br/>
            </form>
        </c:if>
        <h1>Hello World!</h1>
        
        <sql:query dataSource="${mydata}" var="result">
        select * from employees where emp_no='${param.id}';
        </sql:query>
        
      
                  <c:forEach var="row" items="${result.rows}">
   
            <form method="post">
                Employee Number: <input type="number" name="empno" value="${row.emp_no}"/><br/>
                First Name: <input type="text" name="firstname" value="${row.first_name}"/><br/>
                Last Name:  <input type="text" name="lastname" value="${row.last_name}"/><br/>
                Birth Date: <input type="date" name="birthdate" value="${row.birth_date}"/><br/>
                Gender: <input type="radio" name="gender" value="M"> M <input type="radio" name="gender" value="F"> F<br/>
                Hire Date: <input type="date" name="hiredate" value="${row.hire_date}"/><br/>
                <input type="submit" value="Submit">
            </form>
                  </c:forEach>
         
                    
       </body>
</html>
