<%-- 
    Document   : Produtos
    Created on : 15/09/2017, 09:13:59
    Author     : Bruno
--%>

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
        <title>JSP Page</title>
    </head>
    <body class="prodFrame">
        <form action="Salvar" method="post">
            <table>
                <tr>
                    <td rowspan="3" class="cadImg">
                        <img src="img/produtos/1.jpg" id="imgFoto" class="prodImg"/>
                        <input typo="button" class="btnSeta" value="<" onclick="setaMenos();">
                        <input type="text" id="txtFoto" class="cadTextBoxBuscar cadTextBoxFoto"  value="1" placeholder="1" name="foto" onkeypress="return ApenasNumeros(event)" onkeyup="altImagem()">
                        <input typo="button" class="btnSeta" value=">" onclick="setaMais();">
                    </td>

                    <td class="cadCampo"> <b>Nome:</b> </td>
                    <td class="cadCampoText" ><input type="text" id="txtNomeCad" class="cadTextBoxBuscar cadTextBoxBuscarNome"  placeholder="Nome" name="nome" onkeyup="validaFormCadProduto()"> </td>
                    
                    <td class="cadCampo"> <b>Preço:</b> </td>
                    <td ><input type="text" id="txtPrecoCad" class="cadTextBoxBuscar cadTextBoxBuscarPreco" placeholder="Preço" name="preco" onkeyup="validaFormCadProduto()"/> </td>
                    
                </tr>
                <tr>
                    <td class="cadCampo"> <b>Marca:</b> </td>
                    <td  ><input type="text" id="txtMarcaCad" class="cadTextBoxBuscar cadTextBoxBuscarNome" placeholder="Marca" name="marca" onkeyup="validaFormCadProduto()"/> </td>

                </tr>
                <tr>
                    <td  class="cadCampo"> <b>Descrição:</b> </td>
                    <td class="cadCampoText" ><textarea id="txtDescriCad" class="cadTextBoxBuscar cadTextBoxBuscarNome txtArea" rows="4" cols="30" placeholder="Descrição" name="descri" onkeyup="validaFormCadProduto()"></textarea> </td>
                </tr>
            </table>
            <hr>
            <input type="hidden" name="idVendedor" value="${sessionScope.idVendedor}">
            <input onclick="mostrarCadastrado()" type="submit" id="BtnCad" class="botao btnCad" value="Cadastrar" disabled/> 
        </form>
    </body>
</html>
