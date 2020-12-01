<%-- 
    Document   : nav
    Created on : 10/11/2020, 11:38:48
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="model.Usuario" %>
<%@ page import="enums.PapelUsuario" %>
<%@ page import="javax.servlet.http.HttpUtils.*" %>

<c:set var = "usuario" scope = "page" value = "${sessionScope.usuarioLogado}"/>
<c:set var = "urlAtual" scope = "page" value = "${requestScope['javax.servlet.forward.request_uri']}"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Servlet Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav mr-auto">
        <c:if test = "${usuario != null}">
            <li class="nav-item">
              <a class="nav-link" href="artigo?acao=meusArtigos"> Gerenciar Meus Artigos <span class="sr-only">(current)</span></a>
            </li>
        </c:if>
        <c:if test = "${usuario == null}">
            <li class="nav-item">
                <a class="nav-link" href="login">Login<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="usuario?acao=solicitar">Solicitar Acesso</a>
            </li>
        </c:if> 
        
        <c:if test = "${usuario != null && usuario.papel == PapelUsuario.ADMINISTRADOR.getValorInteiro()}">
            <li class="nav-item">
              <a class="nav-link" href="/usuario?acao=solicitacoes">Gerenciar Solicitações <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/usuario?acao=gerenciarArtigos">Gerenciar Artigos <span class="sr-only">(current)</span></a>
            </li>
        </c:if> 
        <c:if test = "${usuario != null && usuario.papel == PapelUsuario.ADMINISTRADOR.getValorInteiro() || usuario.papel == PapelUsuario.AUTOR.getValorInteiro()}">
            <li class="nav-item">
              <a class="nav-link" href="/artigo?acao=novo"> Escrever Artigo <span class="sr-only">(current)</span></a>
            </li>
        </c:if> 
        <li class="nav-item">
            <a class="nav-link" href="/artigo?acao=listar"> Navegar por Artigos <span class="sr-only">(current)</span></a>
        </li>
        <c:if test = "${usuario != null}">
            <li class="nav-item">
              <a class="nav-link" href="usuario?acao=logout"> Sair <span class="sr-only">(current)</span></a>
            </li>
        </c:if>

      </ul>
      <span class="navbar-text">

      </span>
    </div>

</nav>
