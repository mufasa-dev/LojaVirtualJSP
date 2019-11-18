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
        <title>Detalhes produtos</title>
    </head>
    <body class="formAlt">
        <div class="formAlt">
            <table class="detailTable">
                <%
                    List<Produto> prods = (List<Produto>) request.getAttribute("listaProdutos");
                    Vendedor vend = (Vendedor) request.getAttribute("vendedor");
                    int idUsuario = 1000; //(int)request.getAttribute("vendedor");

                    for (Produto prod : prods) {
                %>
                <tr>
                    <td class="detail">
                        <img src="img/produtos/<%=prod.getFoto()%>.jpg" class="detailImg"/>
                    </td>
                    <td>
                        <b>Nome: </b> <%=prod.getNome()%> <br>
                        <b>Marca: </b> <%=prod.getMarca()%> <br>
                        <b>Preço: </b>R$ <%=prod.getPreco()%> <br> 
                        <b>Vendedor: </b> <%=vend.getNome()%> <br>
                        <b>Data da publicação: </b> <%=prod.getDataCriacao()%> <br>
                        <b>Descrição: </b> <%=prod.getDescri()%> <br>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form action="Comprar" method="post">
                            <input  onclick="recarregarProdutos()" class="botaoLogin" value="Voltar" />
                            <% if((int)prod.getIdVendedor() == idUsuario){ }else{%>
                            <input type="hidden" value="<%= prod.getIdVendedor()%>" name="idVendedor"/>
                            <input type="hidden" value="<%= prod.getId()%>" name="idProduto"/>
                            <input type="hidden" value="<%= prod.getNome()%>" name="nomeProduto"/>
                            <input onclick="mostrarComprando()"  type="submit" class="botaoLogin" value="Comprar" />
                        </form>  
                    </td>
                    <%
                        }
                    %>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
