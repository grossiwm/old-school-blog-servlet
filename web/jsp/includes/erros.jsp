<%-- 
    Document   : alertaDeErros
    Created on : 10/11/2020, 18:14:45
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test = "${erros.size() > 0}">
    <div class="alert alert-danger" role="alert">
        <c:forEach items="${erros}" var="erro">
            <p><c:out value="${erro}"/></p>
        </c:forEach>
    </div>
</c:if>
