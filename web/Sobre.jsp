<%-- 
    Document   : Sobre
    Created on : 24/10/2017, 13:16:49
    Author     : 11152100531
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sobre</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/creative.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
        <script src="js/botoes.js" type="text/javascript"></script>
    </head>
    <body class="semBarraSobre">
        <div class="jSobre">
            <p>Somos uma empresa puramente inventada para uma aula normal de sexta-feira</p>
            <div class="contatinhos">
                <div class="cor">
                    <h1><%=request.getAttribute("numeroProdutos")%></h1></div>
                <p>PRODUTOS DISPONIVEIS</p>
            </div>

            <div class="contatinhos">
                <div class="cor">
                    <h1><%=request.getAttribute("numeroProdutosVendidos")%></h1></div>
                <p>PRODUTOS VENDIDOS</p>
            </div>

            <div class="contatinhos">
                <div class="cor">
                    <h1><%=request.getAttribute("numeroVendedores")%></h1></div>
                <p>VENDEDORES<br>CADASTRADOS</p>
            </div>
        </div>
    </body>
</html>
