<%-- 
    Document   : login.jsp
    Created on : 10/11/2020, 11:35:02
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
        <%@include file="includes/erros.jsp" %>
        <div class="container" id="container-login-cadastro" >
            <form id="login-form" action="login" method="post">
                <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" class="form-control" id="cpf" name="cpf" aria-describedby="cpfHelp">
                <small id="cpf-help" class="text-danger"></small> 
                </div>
                <div class="form-group">
                <label for="senha">Senha</label>
                <input type="password" name="senha" class="form-control" id="senha">
                </div>
                <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="login-mantenha-logado">
                <label class="form-check-label" for="login-mantenha-logado">Mantenha-me Logado</label>
                </div>
                <button type="submit" class="btn btn-primary">Entrar</button>
            </form>
        </div>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/validacao-form.js"></script>
    </body>
</html>
