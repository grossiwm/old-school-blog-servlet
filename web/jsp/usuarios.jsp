<%-- 
    Document   : usuarios
    Created on : 10/12/2020, 18:25:26
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="enums.PapelUsuario" %>

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
        <div class="container">
        <h2>Usuários</h2>

        <c:if test = "${usuarios.size() > 0}">
            <p>Clique no nome para exibir detalhes e ações</p>
            <td><button type="button" class="btn btn-success mb-2" onclick="${'location.href=&#39;usuario?acao=novoUsuario&#39;'}">Novo Usuario</button></td>
            <table class="table">
                <tr>
                  <th>Nome</th>
                  <th>cpf</th>
                  <th>email</th>
                  <th>papel</th>
                  <th></th>
                  <th></th>
                </tr>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.nome}</td>
                        <td>${usuario.cpf}</td>
                        <td>${usuario.email}</td>
                        <td>${PapelUsuario.getPapelUsuarioFromValorInteiro(usuario.papel)}</td>
                        <td><button type="button" class="btn btn-warning" onclick="${'location.href=&#39;usuario?acao=editarUsuario&id='.concat(usuario.id).concat('&#39;;')}">Editar</button></td>
                        <td><button type="button" class="btn btn-danger" onclick="${'location.href=&#39;usuario?acao=deletar&id='.concat(usuario.id).concat('&#39;;')}">Deletar</button></td>

                    </tr>
                </c:forEach>
              </table>
            </div>
        </c:if>
        <%@include file="includes/scripts.html" %>
    </body>
</html>