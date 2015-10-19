<%-- 
    Document   : index
    Created on : 03/10/2015, 19:39:17
    Author     : bruce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogo da Velha (RMI)</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <c:if test="${empty tabuleiro}">
            <%-- Redireciona para o FrontController para inicializar o tabuleiro --%>
            <jsp:forward page="FrontController?action=init"/>
        </c:if>
        <div class="container">
            <div class="linha">
                <a href="FrontController?x=1&y=1"><div class="quadrado"><img src="img/${tabuleiro.getPos(0,0)}.png"/></div></a>
                <a href="FrontController?x=1&y=2"><div class="quadrado"><img src="img/${tabuleiro.getPos(0,1)}.png"/></div></a>
                <a href="FrontController?x=1&y=3"><div class="quadrado"><img src="img/${tabuleiro.getPos(0,2)}.png"/></div></a>
            </div>
            <div class="linha">
                <a href="FrontController?x=2&y=1"><div class="quadrado"><img src="img/${tabuleiro.getPos(1,0)}.png"/></div></a>
                <a href="FrontController?x=2&y=2"><div class="quadrado"><img src="img/${tabuleiro.getPos(1,1)}.png"/></div></a>
                <a href="FrontController?x=2&y=3"><div class="quadrado"><img src="img/${tabuleiro.getPos(1,2)}.png"/></div></a>
            </div>
            <div class="linha">
                <a href="FrontController?x=3&y=1"><div class="quadrado"><img src="img/${tabuleiro.getPos(2,0)}.png"/></div></a>
                <a href="FrontController?x=3&y=2"><div class="quadrado"><img src="img/${tabuleiro.getPos(2,1)}.png"/></div></a>
                <a href="FrontController?x=3&y=3"><div class="quadrado"><img src="img/${tabuleiro.getPos(2,2)}.png"/></div></a>
            </div>            
        </div>
            <c:choose>
                <c:when test="${estado == 'HUMANO'}">
                    <br> Você venceu! <br>
                    <a href="FrontController?action=init"><button type="button"> Recomeçar</button></a>
                </c:when>
                <c:when test="${estado == 'MAQUINA'}">
                    <br> Você perdeu D:<br>
                    <a href="FrontController?action=init"><button type="button"> Recomeçar</button></a>
                </c:when>
                <c:when test="${estado == 'EMPATE'}">
                    <br> EMPATE!<br>
                    <a href="FrontController?action=init"><button type="button"> Recomeçar</button></a>
                </c:when>
            </c:choose>
    </body>
</html>
