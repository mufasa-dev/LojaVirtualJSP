<%-- 
    Document   : Login
    Created on : 10/11/2017, 14:47:18
    Author     : 11152100531
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="css/creative.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <script src="js/botoes.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="Login" method="post">
            <table class="cadTable">
                <tr>
                    <td class="cadCampoLogin cadCampoText"> <b>Nome:</b> 
                    <input type="text" class="cadTextBox"  placeholder="Nome" name="nome"> </td>
                </tr>
                <tr>
                    <td class="cadCampoLogin cadCampoText"> <b>Senha:</b> 
                    <input type="password" class="cadTextBox" placeholder="Senha" name="senha" /> </td>
                </tr>

                <tr>
                    <td class="cadBotao">
                        <input onclick="mostrarCadastrarVendedor()" class="botaoLogin" value="Registrar" /> 
                        <input type="submit" class="botaoLogin" value="Login" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
