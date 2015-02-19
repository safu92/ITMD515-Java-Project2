<%-- 
    Document   : error
    Created on : Feb 2, 2015, 4:12:50 PM
    Author     : spyrisos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<%@include file="/WEB-INF/header.jspf" %>

<h1>There has been an issue.</h1>
<h2>Your status code is ${pageContext.errorData.statusCode}</h2>

<p>We have dispatched a team of highly trained monkeys to investigate the problem.  Yes, I actually read that on YouTube!</p>

<c:choose>
    <c:when test="${pageContext.errorData.statusCode eq 404}">
        <p>Sorry, we cannot find the page you were looking for.  Please check out sitemap for:</p>
        <p>${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.errorData.requestURI}</p>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty pageContext.exception}">
            <h2>${pageContext.exception}</h2>
        </c:if>
    </c:otherwise>
</c:choose>

<%@include file="/WEB-INF/footer.jspf" %>