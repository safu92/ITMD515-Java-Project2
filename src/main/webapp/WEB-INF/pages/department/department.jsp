<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<h1>I am employee.jsp</h1>

<c:if test="${not empty requestScope.employee}">
    <h2>${requestScope.employee.firstName} ${requestScope.employee.lastName}</h2>
</c:if>

<c:choose>
    <c:when test="${requestScope.readonly ne 'readonly'}">
        <form action="${pageContext.request.contextPath}${not empty requestScope.employee ? '/employee/update' : '/employee/new'}" method="post">
        </c:when>
        <c:otherwise>
            <form>
            </c:otherwise>
        </c:choose>
        <div class="row">
            <div class="large-4 columns">
                <label>Employee ID
                    <input type="text" placeholder="Employee ID" id="id" name="id" value="${employee.employeeId}" />
                </label>
            </div>
            <div class="large-4 columns">
                <label>First Name
                    <input type="text" placeholder="First Name" id="firstName" name="firstName" value="${employee.firstName}"/>
                </label>
            </div>
            <div class="large-4 columns">
                <label>Last Name
                    <input type="text" placeholder="Last Name" id="lastName" name="lastName" value="${employee.lastName}"/>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="large-12 columns">
                <label>Email
                    <input type="email" placeholder="Email Address" id="email" name="email" value="${employee.email}"/>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="large-12 columns">
                <label>Company
                    <select id="param5" name="company">
                        <option ${employee.company eq "husker" ? "selected" : "" } value="husker">Husker</option>
                        <option ${employee.company eq "starbuck" ? "selected" : "" } value="starbuck">Starbuck</option>
                        <option ${employee.company eq "hotdog" ? "selected" : "" } value="hotdog">Hot Dog</option>
                        <option ${employee.company eq "apollo" ? "selected" : "" } value="apollo">Apollo</option>
                    </select>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="large-12 columns">
                <label>Address
                    <textarea id="address" name="address" placeholder="Employee Address" value="${employee.address}"></textarea>
                </label>
            </div>
        </div>

        <c:if test="${requestScope.readonly ne 'readonly'}">
            <div class="row">
                <div class="large-12 columns">
                    <button class="button">Save</button>
                </div>
            </div>
        </c:if>
    </form>    


    <%@include file="/WEB-INF/footer.jspf" %>