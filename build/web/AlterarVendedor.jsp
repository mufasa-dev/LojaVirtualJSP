<%@page import="br.umc.loja.model.Vendedor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="br.umc.loja.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/creative.css" rel="stylesheet" type="text/css"/>
<script src="js/botoes.js" type="text/javascript"></script>
<script src="js/CadastrarFoto.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar dados vendedor</title>
    </head>
    <body class="prodFrame">
        <%
            Vendedor vend = (Vendedor) request.getAttribute("listaVendedores");
        %>
        <form action="AlterarVendedorController" method="post">
            <table>
                <tr>
                    <td rowspan="6" class="detail">
                    <img src="img/Vendedores/<%=vend.getFoto()%>"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadCampo altVendCampo"> <b>Nome:</b> </td>
                    <td  ><input type="text" id="txtMarcaCad" class="cadTextBoxBuscar cadTextBoxBuscarNome" value="<%= vend.getNome()%>" placeholder="Nome" name="nome" /> </td>
                </tr>
                <tr>
                    <td class="cadCampo"> <b>E-mail:</b> </td>
                    <td  ><input type="text" id="txtMarcaCad" class="cadTextBoxBuscar cadTextBoxBuscarNome" value="<%= vend.geteMail()%>" placeholder="E-mail" name="eMail" /> </td>
                </tr>
                <tr>
                    <td class="cadCampo"> <b>Senha atual:</b> </td>
                    <td  ><input type="text" id="txtMarcaCad" class="cadTextBoxBuscar cadTextBoxBuscarNome" placeholder="Senha atual" name="senhaAtual" /> </td>
                </tr>
                <tr>
                    <td class="cadCampo"> <b>Nova senha:</b> </td>
                    <td  ><input type="text" id="txtMarcaCad" class="cadTextBoxBuscar cadTextBoxBuscarNome" placeholder="Nova senha" name="NovaSenha" /> </td>
                </tr>
                <tr>
                    <td  class="cadCampo"> <b>Um pouco sobre você:</b> </td>
                    <td class="cadCampoText" ><textarea id="txtDescriCad" class="cadTextBoxBuscar cadTextBoxBuscarNome txtArea" rows="4" cols="30" placeholder="Descrição" name="descri"><%= vend.getAssinatura()%></textarea> </td>
                </tr>
            </table>
            <hr>
            <input type="submit" id="BtnCad" class="botao btnCad" value="Alterar" /> 
        </form>
    </body>
</html>