<%-- 
    Document   : artigos
    Created on : 14/11/2020, 00:06:02
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <%@include file="includes/head.html" %>
    <body>
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
            <%@include file="includes/nav.jsp" %>
            <c:if test = "${not empty mensagemSucesso}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${mensagemSucesso}"/>
                </div>
            </c:if>
            <c:forEach items="${artigos}" var="artigo">
                <div class="lista-posts">
                    <div class="container container-post">
                        <h2>${artigo.titulo}</h2>
                        <h3>${artigo.autor}</h2>
                        <h3>${artigo.categoria}</h2>
                        <p>${artigo.conteudo}</p>
                        <a href='./artigo?acao=mostrar&id=${artigo.id}'>ver mais</a>
                    </div>
                </div>
            </c:forEach>

            <%@include file="includes/scripts.html" %>

    </body>
</html>