<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>

        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>


        <sql:query dataSource="${mydata}" var="result">
        SELECT * from departments;
        </sql:query>
        
                     <table width="100%">
<tr>
<th>Department No.</th>
<th>Department Name</th>

</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.dept_no}"/></td>
<td><c:out value="${row.dept_name}"/></td>

</tr>
</c:forEach>
</table>
<%@include file="/footer.jspf" %>