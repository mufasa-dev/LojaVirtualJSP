<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="br.umc.loja.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/creative.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body class="prodFrame">
        <div class="prodFrame">
            
            <form class="formBusc" action="ConsultaProdutos" method="post">
                <span>Buscar:</span>
                <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarNome"  placeholder="Nome" name="nome">
                <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarMarca"  placeholder="Marca" name="marca">
                <input type="submit" class="botaoFiltrar" value="Filtrar" />
            </form>

            <table class="prodTable">
                <%
                    List<Produto> prods = (List<Produto>) request.getAttribute("listaProdutos");

                    for (Produto prod : prods) {
                %>

                <tr>
                    <td rowspan="2">
                        <img src="img/produtos/<%=prod.getFoto()%>.jpg" class="prodImg"/>
                    </td>
                    <td class="prodNome"> <b> <%= prod.getNome()%> </b> - <%=prod.getMarca()%> </td>
                <form action="vizualizaProduto" method="post">
                    <td> 
                        <input type="hidden" value="<%= prod.getId()%>" name="id"/>
                        <input type="submit" class="botaoFiltrar" value="Ver mais" />
                    </td>
                </form>
                </tr>
                <tr>
                    <td colspan="2">
                        <span class="prodDescri"><%=prod.getDescri()%></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <hr>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
