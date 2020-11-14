<%-- 
    Document   : artigo
    Created on : 14/11/2020, 01:04:58
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

            <div class="container" id="container-post">
                <h2>${artigo.titulo}</h2>
                <h3>${artigo.autor}</h2>
                <p>${artigo.conteudo}</p>
            </div>

            <div class="container" id="container-comentar">
                <form>
                    <div class="form-group">
                        <input type="text" class="form-control" id="input-comentar" placeholder="Comente aqui...">
                    </div>
                </form>
            </div>

            <div class="container" id="container-comentarios">
            <h3>Comentários</h3>
                <ul id="lista-comentarios">
                    <li>
                        <strong>Fulano de Tal:</strong><br/>
                        <p>lkdsfalkdsafjlkdsfjdflsakjdfsa klsdfjlkdsjlkdf lkdskljdfaslkçjdfsaklçj</p>
                    </li>
                    <li>
                        <strong>José Longone:</strong><br/>
                        <p>lkdsfalkdsafjlkdsfjdflsakjdfsa klsdfjlkdsjlkdf lkdskljdfaslkçjdfsaklçj</p>
                    </li>
                    <li>
                        <strong>Roberval dos Santos:</strong><br/>
                        <p>lkdsfalkdsafjlkdsfjdflsakjdfsa klsdfjlkdsjlkdf lkdskljdfaslkçjdfsaklçj</p>
                    </li>
                </ul>
            </div>

    <%@include file="includes/scripts.html" %>

    </body>
</html>