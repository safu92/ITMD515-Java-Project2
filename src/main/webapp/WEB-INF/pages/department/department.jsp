<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<br/>

<c:if test="${not empty requestScope.department}">
    <h2>${requestScope.department.deptId} ${requestScope.department.deptName}</h2>
</c:if>

    <c:if test="${not empty requestScope.department}">
        <form action="${pageContext.request.contextPath}/department/update" method="get">
    </c:if>
    <c:if test="${requestScope.department==null}">
        <form action="${pageContext.request.contextPath}/department/new" method="get">
    </c:if>
        <div class="row">
            <div class="large-6 columns">
                <label>Department ID
                    <c:if test="${not empty requestScope.department}">
                    <input type="text" placeholder="Department ID" id="deptId" name="deptId" value="${department.deptId}" readonly/>
                    </c:if>
                    <c:if test="${requestScope.department==null}">
                    <input type="text" placeholder="Department ID" id="deptId" name="deptId" value="${department.deptId}"/>
                    </c:if>
                </label>
            </div>
            <div class="large-6 columns">
                <label>Department Name
                    <input type="text" placeholder="Department Name" id="deptName" name="deptName" value="${department.deptName}"/>
                </label>
            </div>
        
        </div>
        

            <div class="row">
                <div class="large-12 columns">
                    <input type="submit" class="button" Value="Save"/>

                   

                    
                </div>
            </div>
    </form>    


    <%@include file="/WEB-INF/footer.jspf" %>