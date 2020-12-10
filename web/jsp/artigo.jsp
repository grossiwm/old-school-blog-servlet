<%-- 
    Document   : artigo
    Created on : 14/11/2020, 01:04:58
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "usuario" scope = "page" value = "${sessionScope.usuarioLogado}"/>
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
            <p>Autor: ${artigo.autor}</p>
            <p>Categoria: ${artigo.categoria}</p>
            <h2>${artigo.titulo}</h2>
            <p>${artigo.conteudo}</p>
        </div>

        <c:if test = "${usuario != null && usuario.papel == PapelUsuario.COMENTARISTA.getValorInteiro() || usuario.papel == PapelUsuario.ADMINISTRADOR.getValorInteiro()}">
            <div class="container" id="container-comentar">
                <form method="POST" action="/comentario?acao=criar">
                    <div class="form-group">
                        <input type="text" name="comentario" class="form-control" id="input-comentar" placeholder="Comente aqui...">
                        <input name="artigoId" type="hidden" value="${artigo.id}">
                        <input name="usuarioId" type="hidden" value="${usuario.id}">
                        <button type="submit" class="btn btn-primary mt-2">comentar</button>
                    </div>
                </form>
            </div>
        </c:if>
        <div class="container" id="container-comentarios">
            <h3>Comentários</h3>
            <ul id="lista-comentarios">
                <c:forEach items="${comentarios}" var="comentario">

                        <li class="container container-comentario">
                            <strong>${comentario.autor}:</strong><br/>
                            <p>${comentario.comentario}</p>
                            <c:if test = "${usuario.id == comentario.autorId || usuario.papel == PapelUsuario.ADMINISTRADOR.getValorInteiro()}">
                                <button type="button" class="btn btn-danger mb-4" 
                                        onclick="${'location.href=&#39;comentario?acao=deletar&id='.
                                                   concat(comentario.id).concat("&artigoId=").
                                                   concat(artigo.id).concat("&autorId=").
                                                   concat(comentario.autorId).
                                                   concat('&#39;;')}"
                                        >Deletar</button>
                            </c:if>
                            

                        </li>

                </c:forEach>
            </ul>
        </div>

    <%@include file="includes/scripts.html" %>

    </body>
</html>