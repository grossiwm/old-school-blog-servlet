<%-- 
    Document   : novoArtigo
    Created on : 11/11/2020, 20:25:49
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="container" id="container-postar">
            <form action="artigo?acao=criar" method="post">
                <div class="form-group">
                    <label for="titulo">Título do post</label>
                    <input type="text" class="form-control" id="titulo" name="titulo" placeholder='Escreva aqui o título do seu post...'>
                </div>
                <div class="form-group">
                    <label for="corpo">Corpo do post</label>
                    <textarea class="form-control" id="corpo" name="conteudo" rows="10" placeholder='Escreva aqui o corpo do seu post...'></textarea>
                </div>
            </form>
        </div>

        <%@include file="includes/scripts.html" %>

    </body>
</html>