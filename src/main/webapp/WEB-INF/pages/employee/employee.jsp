<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>
<center>

<h1>I am employee.jsp</h1>
<c:if test="${not empty requestScope.employee}">
    <h2>${requestScope.employee.firstName} ${requestScope.employee.lastName}</h2>
</c:if>

 <c:if test="${not empty requestScope.employee}">
        <form action="${pageContext.request.contextPath}/employee/update" method="get">
    </c:if>
    <c:if test="${requestScope.employee==null}">
        <form action="${pageContext.request.contextPath}/employee/new" method="get">
    </c:if>
            
            </center>
        <div class="row">
            <div class="large-2 columns">
                <label>Employee ID<br/><br/>
                     <c:if test="${not empty requestScope.employee}">
                    <input type="text" placeholder="Employee ID" id="empId" name="empId" value="${employee.empId}" readonly/>
                    </c:if>
                    <c:if test="${requestScope.employee==null}">
                    <input type="text" placeholder="Employee ID" id="empId" name="empId" value="${employee.empId}"/>
                    </c:if>

                </label>
            </div>
            <div class="large-2 columns">
                <label>First Name<br/><br/>
                    <input type="text" placeholder="First Name" id="firstName" name="firstName" value="${employee.firstName}"/>
                </label>
            </div>
            <div class="large-2 columns">
                <label>Last Name<br/><br/>
                    <input type="text" placeholder="Last Name" id="lastName" name="lastName" value="${employee.lastName}"/>
                </label>
            </div>
                
                <div class="large-2 columns">
                <label>Gender<br/><br/>
                    <c:if test="${employee.gender!=null}">
                    <c:if test="${employee.gender =='M'}">
                    <input type="radio" name="gender" value="M" checked />M
                    </c:if>
                    <c:if test="${employee.gender !='M'}">
                    <input type="radio" name="gender" value="M" />M
                    </c:if>
                    
                    <c:if test="${employee.gender =='F'}">
                    <input type="radio" name="gender" value="F" checked />F
                    </c:if>
                    <c:if test="${employee.gender !='F'}">
                    <input type="radio" name="gender" value="F" />F
                    </c:if>
                    </c:if>
                 <c:if test="${employee.gender==null}">
                    <input type="radio" name="gender" value="M" />M

                     <input type="radio" name="gender" value="F" />F

                 </c:if>

                    
                </label>
            </div>
                
                <div class="large-2 columns">
                    <label>Birth Date<br/>(yyyy-mm-dd)
                    <input type="date" placeholder="Birth Date" id="birthDate" name="birthDate" value="${employee.birthDate}"/>
                </label>
            </div>
                
                <div class="large-2 columns">
                    <label>Hire Date<br/>(yyyy-mm-dd)
                    <input type="date" placeholder="Hire Date" id="hireDate" name="hireDate" value="${employee.hireDate}"/>
                </label>
            </div>
        </div>
        
        
        
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Save</button>
                </div>
            </div>
    </form>    


    <%@include file="/WEB-INF/footer.jspf" %>