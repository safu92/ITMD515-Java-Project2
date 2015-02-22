<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Safdar | Welcome to My Application</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/foundation.css" />
        <script src="${pageContext.request.contextPath}/js/vendor/modernizr.js"></script>
    </head>
    <body>

        <nav class="top-bar" data-topbar role="navigation">
            <ul class="title-area">
                <li class="name">
                    <h1><a href="#">Safdar MP2</a></h1>
                </li>
                <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
                <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
            </ul>

            <section class="top-bar-section">
                <!-- Right Nav Section -->
                <ul><li><a href="extra/index.jsp">Safdar MP2 Extra Credit Work</a></li></ul>

                <!-- Left Nav Section -->
               
            </section>
        </nav>     

        <c:if test="${not empty requestScope.messages}">
            <h2>Messages passed back from the controller layer in request scope:</h2>
            <ul>
                <c:forEach items="${requestScope.messages}" var="message">
                    <li>
                        <strong><c:out value="${message.key}"/>: ${message.value}</strong>
                    </li>
                </c:forEach>
            </ul>
            
            
        </c:if>
        <c:if test="${not empty requestScope.violations}">
            <h2>Violations passed back from the controller layer in request scope:</h2>
            <ul>
                <c:forEach items="${requestScope.violations}" var="violation">
                    <li>
                        <strong><c:out value="${violation.propertyPath}"/>: ${violation.message}</strong>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    <center>
            <h1>Welcome to my MP2 Project!</h1>
            <table><tr><td style="text-align:center">
                        <a href="./employees"><button class="button">View Employees</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./employee"><button class="button">Add Employee</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./employees"><button class="button">Update Employee</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./employee/delete"><button class="button">Delete Employee</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./departments"><button class="button">View Department</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./department"><button class="button">Add Department</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./departments"><button class="button">Update Department</button></a></td></tr>
            <tr><td style="text-align:center"><a href="./department/delete"><button class="button">Delete Department</button></a></td></tr>
            </table>
    </center>
<%-- any content can be specified here e.g.: --%>
    <script src="${pageContext.request.contextPath}/js/vendor/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
