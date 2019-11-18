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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="prodFrame">
        <div class="prodFrame">
            <table class="prodTable">
                <%
                    List<Produto> prods = (List<Produto>) request.getAttribute("listaProdutos");

                    for (Produto prod : prods) {
                %>
                <tr>
                    <td class="prodNomeExcluir"> <b> <%=prod.getNome()%> </b> - <%=prod.getMarca()%></td>
                    <td>
                        <form action="excluir" method="post"> 
                            <input type="hidden" value="<%= prod.getId()%>" name="id_excluir"/>
                            <input  onclick="mostrarExcluido()" type="submit" class="botaoExcluir" value="Excluir" /> 
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
