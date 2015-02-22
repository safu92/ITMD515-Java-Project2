<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/header.jspf" %>
        <sql:setDataSource var="mydata" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/employees"
     user="smatches"  password="itmd4515"/>
        
        
        <c:if test="${param.id==null}">
            <center>
                <form name="updateDepartment1" method="post">
                    <table><tr><td>Enter Department No.:</td><td><input type="text" name="id"/></td></tr></table>
            <input type="submit" class="button" value="Submit">
            
            </form>
            </center>         
        </c:if>
        
         <sql:update dataSource="${mydata}" var="updateresult">
        UPDATE departments set dept_name=? where dept_no=?;
        
            <sql:param value="${param.deptname}" />
            
        <sql:param value="${param.deptno}" />
         </sql:update>
        
         <c:if test="${updateresult>=1}">
            <center><h1> <c:out value="Department updated successfully."></c:out></h1></center>
        </c:if>
        
        <sql:query dataSource="${mydata}" var="result">
        select * from departments where dept_no='${param.id}';
        </sql:query>
        
      
                  <c:forEach var="row" items="${result.rows}">
                      <center>
                      <table>
            <form method="post">
                <tr><td>Department No.: </td><td><input type="text" name="deptno" value="${row.dept_no}" readonly/></td></tr>
                <tr><td>Department Name: </td><td><input type="text" name="deptname" value="${row.dept_name}"/></td></tr>
                
               </table>
                <input type="submit" class="button" value="Submit">
            </form>
                  </center>
                  </c:forEach>
         
        
<%@include file="/footer.jspf" %>