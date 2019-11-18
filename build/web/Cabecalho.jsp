<%-- 
    Document   : Cabecalho
    Created on : 15/11/2017, 11:17:29
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/creative.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <script src="js/botoes.js" type="text/javascript"></script>
        <title>Cabeçalho</title>
    </head>
    <body>
        <div class="icoCabecalho" onclick="mostrarMensagens();">
            <i class="fa fa-envelope-o fa-3x" aria-hidden="true"></i><br>
            <label>Mensagens</label>
        </div>
        <div class="icoCabecalho" onclick="mostrarPerfil();">
            <i class="fa fa-user-circle fa-3x" aria-hidden="true"></i><br>
            <label>Perfil</label>
        </div>
        <div class="icoCabecalho">
            <a href="LogoutController">
            <i class="fa fa-power-off fa-3x" aria-hidden="true"></i><br>
            <label>Sair</label></a>
        </div>
    </body>
</html>
