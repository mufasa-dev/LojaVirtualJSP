<%@page import="br.umc.loja.model.Mensagem"%>
<%@page import="br.umc.loja.model.Vendedor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="br.umc.loja.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/creative.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagens</title>
    </head>
    <body class="prodFrame">
        <div class="prodFrame">

            <table class="prodTable">
                <%
                    Vendedor vend = (Vendedor) request.getAttribute("listaVendedores");
                %>
                <form action="MandarMensagemController" method="post">
                <tr>
                    <td rowspan="4" class="detail">
                        <img src="img/Vendedores/<%=vend.getFoto()%>" class="vendImg"/>
                    </td>
                    <td class="cadCampo">
                        <b>Remetente:</b>
                    </td>
                    <td>
                        <input type="text" name="remetente"  class="cadTextBoxBuscar cadTextBoxBuscarNome" value="<%=vend.getNome()%>" disabled>
                    </td>
                </tr>
                <tr>
                    <td class="cadCampo">
                        <b>Destinatario:</b>
                    </td>
                    <td>
                        <input type="text" name="destinatario"  class="cadTextBoxBuscar cadTextBoxBuscarNome" value="<%=request.getAttribute("nomeDest")%>">
                    </td>
                </tr>
                <tr>
                    <td class="cadCampo">
                        <b>Assunto:</b>
                    </td>
                    <td>
                        <input type="text" name="assunto"  class="cadTextBoxBuscar cadTextBoxBuscarNome" placeholder="Assunto" value="">
                    </td>
                </tr>
                <tr>
                    <td class="cadCampo">
                        <b>Conteúdo:</b>
                    </td>
                    <td>
                        <textarea id="txtDescriCad" class="cadTextBoxBuscar cadTextBoxBuscarNome txtArea" rows="4" cols="30" placeholder="Descrição" name="descri"></textarea>
                    </td>
                </tr>
            </table>
            <hr>
            <input onclick="mostrarEnviado()" type="submit" id="BtnCad" class="botao btnCad" value="Enviar" /> 
            </form>
        </div>
    </body>
</html>
