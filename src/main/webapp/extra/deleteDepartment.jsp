<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>

        
         <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        <sql:update dataSource="${mydata}" var="result">
        Delete from departments where dept_no='${param.id}';
        </sql:update>
        
        <c:if test="${result>=1}">
            <center><h1>    <c:out value="Department deleted successfully"></c:out></h1></center>
        </c:if>
         <form name="deleteEmployee" method="post">
             <center><table><tr><td>
                         Enter Department No.:</td><td><input type="text" name="id"/></td></tr></table>
            <input type="submit" class="button" value="Delete"><br/>
             </center>
         </form>

<%@include file="/footer.jspf" %>
