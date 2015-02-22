<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>

<sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        
        
       <c:if test="${pageContext.request.method=='POST'}">

           
       
        
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
            <center><h1> <c:out value="Employee added successfully."></c:out></h1></center>
        </c:if>
       </c:if>
        <form method="post">
            <center>
            <table><tr><td>
                        Employee Number: </td><td><input type="number" name="empno"/><br/></td></tr>
                <tr><td>
                        First Name: </td><td><input type="text" name="firstname" /><br/></td></tr>
                <tr><td>
                        Last Name:  </td><td><input type="text" name="lastname" /><br/></td></tr>
                <tr><td>
                        Birth Date (yyyy-mm-dd): </td><td><input type="date" name="birthdate" /><br/></td></tr>
                <tr><td>
                        Gender: </td><td><input type="radio" name="gender" value="M"> M <input type="radio" name="gender" value="F"> F<br/></td></tr>
                <tr> <td> Hire Date (yyyy-mm-dd): </td> <td><input type="date" name="hiredate" /><br/></td></tr>
            </table>
  <input type="submit" class="button" value="Submit">
  </center>
        </form>
   
        
        <%@include file="/footer.jspf" %>
