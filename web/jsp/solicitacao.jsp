<%-- 
    Document   : soliciatacao
    Created on : 10/11/2020, 15:03:16
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
        <div class="container" id="container-login-cadastro">
            <form id="cadastro-form">
                <div class="form-group">
                    <label for="nome" >Nome</label>
                    <input type="text" class="form-control" id="nome" aria-describedby="emailHelp">
                    <small id="cadastro-nome-help" class="text-danger"></small>      
                </div>
                <div class="form-group">
                    <label for="email" >Email</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
                    <small id="email-help" class="text-danger"></small>  
                </div>
                <div class="form-group">
                    <label for="cpf" >CPF</label>
                    <input type="text" class="form-control" id="cpf" aria-describedby="emailHelp">
                    <small id="cpf-help" class="text-danger"></small>  
                </div>
                <div class="form-group">
                    <label for="senha" >Senha</label>
                    <input type="password" class="form-control" id="senha">
                    <small id="senha-help" class="text-danger"></small> 
                </div>
                <div class="form-group">
                    <label for="senha-confirmacao" >Confirmação de Senha</label>
                    <input type="password" class="form-control" id="senha-confirmacao">
                    <small id="senha-confirmacao-help" class="text-danger"></small>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="mantenha-logado">
                    <label class="form-check-label" for="mantenha-logado">Mantenha-me Logado</label>
                </div>
                <button type="submit" class="btn btn-primary">Solicitar</button>
            </form>
        </div>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/validacao-form.js"></script>
    </body>
</html>