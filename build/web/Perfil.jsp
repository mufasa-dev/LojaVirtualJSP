<%-- 
    Document   : Perfil
    Created on : 16/11/2017, 17:30:49
    Author     : Bruno
--%>

<%@page import="br.umc.loja.model.Vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.umc.loja.model.Produto"%>

<link href="css/creative.css" rel="stylesheet" type="text/css"/>
<script src="js/botoes.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes vendedores</title>
    </head>
    <body class="formAlt">
        <div class="formAlt">
            <table class="detailTable">
                <%
                    Vendedor vend = (Vendedor) request.getAttribute("listaVendedores");
                %>
                <tr>
                    <td class="detail">
                        <img src="img/Vendedores/<%=vend.getFoto()%>" class="detailVendImg"/>
                    </td>
                    <td>
                        <b>Nome: </b> <%= vend.getNome()%> <br>
                        <b>E-mail: </b> <%=vend.geteMail()%> <br>
                        <b>Produtos disponiveis: </b> <%=request.getAttribute("prodDisponivel")%> <br> 
                        <b>Produtos vendidos: </b> <%=request.getAttribute("prodVendido")%> <br> 
                        <b>Produtos comprados: </b> <%=request.getAttribute("prodComprado")%> <br> 
                        <b>Data de cadastro </b> <%=vend.getDataCadastro()%> <br>
                        <b>Descrição: </b> <%=vend.getAssinatura()%> <br>
                    </td>
                </tr>
                <tr>
                    <td class="centralizar">
                        <form action="AbrirFotoPerfilController">
                            <input  type="submit" class="botaoFiltrar centralizar" value="Alterar foto" />
                        </form> 
                    </td>
                    <td>
                        <form action="AbrirAlterarPerfilController">
                            <input  type="submit" class="botaoFiltrar" value="Alterar dados" />
                        </form> 
                    </td>
                </tr>


            </table>
        </div>
    </body>
</html>