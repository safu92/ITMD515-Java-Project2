<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<center>
<br/>
<c:if test="${requestScope.updateEmp}">
    <h1>Data Updated Successfuly!</h1>
</c:if>
    
       <c:if test="${requestScope.newEmp}">
    <h1>Data Inserted Successfuly!</h1>
</c:if>
    
    
    <c:if test="${requestScope.deleteEmp}">
    <h1>Data Deleted Successfuly!</h1>
</c:if>
</center>
<table role="grid">
    <thead>
        <tr>
            <th width="100">Employee ID</th>
            <th width="200">First Name</th>
            <th width="300">Last Name</th>
            <th width="300">Gender</th>
            <th width="300">Birth Date</th>
            <th width="300">Hire Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><a href="${pageContext.request.contextPath}/employee?id=${employee.empId}">${employee.empId}</a></td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.gender}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.hireDate}</td>
            </tr>
        </c:forEach>
    </tbody>
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

<%@include file="/WEB-INF/footer.jspf" %>