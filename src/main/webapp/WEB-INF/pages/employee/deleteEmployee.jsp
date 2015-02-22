<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<br/>   
        <form action="${pageContext.request.contextPath}/employee/del" method="get">
        <div class="row">
            <div class="large-6 columns">
                <label>Employee ID
                   
                    <input type="text" placeholder="Employee ID" id="empId" name="empId"/>
                </label>
            </div>
            
        
        </div>
        

            <div class="row">
                <div class="large-12 columns">
                    <input type="submit" class="button" Value="Delete"/>

                   

                    
                </div>
            </div>
    </form>    


    <%@include file="/WEB-INF/footer.jspf" %>

    
</center>
<%@include file="/WEB-INF/footer.jspf" %>
</html>
