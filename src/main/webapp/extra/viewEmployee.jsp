<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>

        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        <c:if test="${param.page == null || param.page < 0}">
        <c:set var="page" value="0"></c:set>
        </c:if>
        <sql:query dataSource="${mydata}" var="result">
        SELECT * from employees limit ${param.page}0,10;
        </sql:query>
        
                     <table width="100%">
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
        
        
        
         <ul class="pagination" role="menubar" aria-label="Pagination">
       
       
       <c:if test="${(param.page == null) || (param.page==1)}">
       <li class="arrow unavailable" aria-disabled="true"><a href="">&laquo; Previous</a></li>    
       <li class="current"><a href="">1</a></li> 
       <li class="arrow"><a href="?page=2">Next &raquo;</a></li> 
       </c:if>
       
       <c:if test="${(param.page != 1) && (param.page!=null)}">
       <li class="arrow"><a href="?page=${param.page - 1}">&laquo; Previous</a></li>
       <li class="current"><a href="">${param.page}</a></li> 
       <li class="arrow"><a href="?page=${param.page + 1}">Next &raquo;</a></li> 
       </c:if>
       
        
   </ul>
<%@include file="/footer.jspf" %>