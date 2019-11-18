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
        <title>Vendedores</title>
    </head>
    <body class="prodFrame">
        <div class="prodFrame">
            
            <form class="formBusc" action="ConsultaVendedores" method="post">
                <span>Buscar:</span>
                <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarNome"  placeholder="Nome" name="nome">
                <input type="submit" class="botaoFiltrar" value="Filtrar" />
            </form>

            <table class="prodTable">
                <%
                    List<Vendedor> vendedor = (List<Vendedor>) request.getAttribute("listaProdutos");

                    for (Vendedor vend : vendedor) {
                %>

                <tr>
                    <td rowspan="2">
                        <img src="img/Vendedores/<%=vend.getFoto()%>" class="vendImg"/>
                    </td>
                    <td class="prodNome"> <b> <%=vend.getNome()%> </b> </td>
                <form action="vizualizaVendedor" method="post">
                    <td class="txtTxtInfo"> 
                        <input type="hidden" value="<%= vend.getId()%>" name="id"/>
                        <input type="submit" class="botaoFiltrar" value="Informações" />
                    </td>
                </form>
                </tr>
                <tr>
                    <td colspan="2">
                        <span class="prodDescri"><%=vend.getAssinatura()%></span>
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

