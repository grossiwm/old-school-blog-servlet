<%-- 
    Document   : mensagens
    Created on : 10/11/2020, 21:11:36
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test = "${mensagens.size() > 0}">
    <div class="alert alert-danger" role="alert">
        <c:forEach items="${mensagem}" var="mensagem">
            <p><c:out value="${mensagem}"/></p>
        </c:forEach>
    </div>
</c:if>
