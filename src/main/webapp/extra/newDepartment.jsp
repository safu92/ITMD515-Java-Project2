<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>


<sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        <br/><br/><br/>
        
        
        
       <c:if test="${pageContext.request.method=='POST'}">

           
        
                <c:catch var ="catchException">

        <sql:update dataSource="${mydata}" var="result">
        INSERT into departments values(?,?);
        <sql:param value="${param.deptNo}" />
            <sql:param value="${param.deptName}" />
            
        </sql:update>
        </c:catch>

<c:if test = "${catchException != null}">
   <p>The exception is : ${catchException} <br />
   There exception message: ${catchException.message}</p>
</c:if>
        
        <c:if test="${result>=1}">
            <center> <h1><c:out value="Department added successfully."></c:out></h1></center>
        </c:if>
       </c:if>
        <form method="post">
            <center>
                <table> <tr><td>Department No.
                </td> <td><input type="text" placeholder="Department Number" id="deptNo" name="deptNo"/>
                </td></tr>
            <tr><td>
                Department Name
                </td><td>    <input type="text" placeholder="Department Name" id="deptName" name="deptName" /></td>
            </tr>
        </table> 
  <input type="submit" class="button" value="Submit">
  </center>
  
        </form>

<%@include file="/footer.jspf" %>

