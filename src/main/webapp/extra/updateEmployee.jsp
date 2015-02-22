<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>
        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        
        <c:if test="${param.id==null}">
            <center>
                <form name="updateEmployee1" method="post">
                    <table><tr><td>Enter Employee Id:</td><td><input type="text" name="id"/></td></tr></table>
            <input type="submit" class="button" value="Submit">
            
            </form>
            </center>         
        </c:if>
        
         <sql:update dataSource="${mydata}" var="updateresult">
        UPDATE employees set birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? where emp_no=?;
        
            <sql:param value="${param.birthdate}" />
            <sql:param value="${param.firstname}" />
            <sql:param value="${param.lastname}" />
            <sql:param value="${param.gender}" />
            <sql:param value="${param.hiredate}" />
        <sql:param value="${param.empno}" />
         </sql:update>
        
         <c:if test="${updateresult>=1}">
            <center><h1> <c:out value="Employee updated successfully."></c:out></h1></center>
        </c:if>
        
        <sql:query dataSource="${mydata}" var="result">
        select * from employees where emp_no='${param.id}';
        </sql:query>
        
      
                  <c:forEach var="row" items="${result.rows}">
                      <center>
                      <table>
            <form method="post">
                <tr><td>Employee Number: </td><td><input type="number" name="empno" value="${row.emp_no}" readonly/></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" value="${row.first_name}"/></td></tr>
                <tr><td>Last Name:  </td><td><input type="text" name="lastname" value="${row.last_name}"/></td></tr>
                <tr><td>Birth Date: </td><td><input type="date" name="birthdate" value="${row.birth_date}"/></td></tr>
                <tr><td>Gender: </td><td>
                         
                    <c:if test="${row.gender =='M'}">
                    <input type="radio" name="gender" value="M" checked />M
                    </c:if>
                    <c:if test="${row.gender !='M'}">
                    <input type="radio" name="gender" value="M" />M
                    </c:if>
                    
                    <c:if test="${row.gender =='F'}">
                    <input type="radio" name="gender" value="F" checked />F
                    </c:if>
                    <c:if test="${row.gender !='F'}">
                    <input type="radio" name="gender" value="F" />F
                    </c:if>
                    
                    </td></tr>
                <tr><td>Hire Date: </td><td><input type="date" name="hiredate" value="${row.hire_date}"/></td></tr></table>
                <input type="submit" class="button" value="Submit">
            </form>
                  </center>
                  </c:forEach>
         
        
<%@include file="/footer.jspf" %>