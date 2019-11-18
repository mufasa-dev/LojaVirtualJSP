<%-- 
    Document   : DetalhesProduto
    Created on : 09/11/2017, 18:09:43
    Author     : 11152100531
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
                        <b>Nome: </b> <%= vend.getNome() %> <br>
                        <b>E-mail: </b> <%=vend.geteMail()%> <br>
                        <b>Produtos disponiveis: </b> <%=request.getAttribute("prodDisponivel") %> <br> 
                        <b>Produtos vendidos: </b> <%=request.getAttribute("prodVendido") %> <br> 
                        <b>Produtos comprados: </b> <%=request.getAttribute("prodComprado") %> <br> 
                        <b>Data de cadastro </b> <%=vend.getDataCadastro()%> <br>
                        <b>Descrição: </b> <%=vend.getAssinatura()%> <br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form action="BuscarVendedoresController" >
                            <input  type="submit" class="botaoFiltrar centralizar" value="Voltar" />
                        </form> 
                    </td>
                    <td>
                        <form action="enviarMensagemController" method="post">
                            <input type="hidden" value="<%=vend.getNome()%>" name="nomeDest">
                            <input  type="submit" class="botaoFiltrar centralizar" value="Mensagem" />
                        </form> 
                    </td>
                </tr>


            </table>
        </div>
    </body>
</html>
