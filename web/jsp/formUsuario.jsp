<%-- 
    Document   : formUsuario
    Created on : 10/12/2020, 19:27:57
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        <%@include file="includes/erros.jsp" %> 
        <div class="container" id="container-login-cadastro">
            <form id="cadastro-form" method="post" action="usuario?acao=solicitar">
                <div class="form-group">
                    <label for="nome" >Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" aria-describedby="emailHelp" 
                           value="${usuarioParaEditar.nome}">
                    
                    <small id="cadastro-nome-help" class="text-danger"></small>      
                </div>
                <div class="form-group">
                    <label for="email" >Email</label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                           value="${usuarioParaEditar.email}">
                    
                    <small id="email-help" class="text-danger"></small>  
                </div>
                <div class="form-group">
                    <label for="cpf" >CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" aria-describedby="emailHelp"
                           value="${usuarioParaEditar.cpf}">
                    
                    <small id="cpf-help" class="text-danger"></small>  
                </div>
                <div>
                    
                    <c:forEach items="${PapelUsuario.values()}" var="papel">
                        <input type="radio" id="${papel.name()}" name="papel" value="${papel.name()}" 
                               ${usuarioParaEditar.papel != null && usuarioParaEditar.papel == papel.getValorInteiro() ? "checked" : ""}>
                        
                        <label for="${papel.name()}">${papel.name()}</label><br>

                    </c:forEach>
                </div>
                <small id="papel-help" class="text-danger"></small> 

                <div class="form-group">
                    <label for="senha" >Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" value="${usuarioParaEditar.senha}">
                    <small id="senha-help" class="text-danger"></small> 
                </div>
                <div class="form-group">
                    <label for="senha-confirmacao" >Confirmação de Senha</label>
                    <input type="password" class="form-control" id="senha-confirmacao" name="senha-confirmacao" value = ${usuarioParaEditar.senha}>
                    <small id="senha-confirmacao-help" class="text-danger"></small>
                </div>
                <input type="hidden" name="id" value="${usuarioParaEditar.id}">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <%@include file="includes/scripts.html" %>
        <script src="js/validacao-form.js"></script>
    </body>
</html>