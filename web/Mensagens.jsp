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
                    List<Mensagem> mensagem = (List<Mensagem>) request.getAttribute("listaMensagens");

                    for (Mensagem men : mensagem) {
                %>

                <tr>
                    <td rowspan="2">
                        <img src="img/Vendedores/<%=men.getRem().getFoto()%>" class="vendImg"/>
                    </td>
                    <td class="prodNome"> <b> <%=men.getAssunto()%> </b> </td>
                <form action="vizualizaMensagemController" method="post">
                    <td class="txtTxtInfo"> 
                        <input type="hidden" value="<%= men.getId()%>" name="id"/>
                        <input type="submit" class="botaoFiltrar" value="Vizualizar" />
                    </td>
                </form>
                </tr>
                <tr>
                    <td>
                        <span class="prodDescri"><%=men.getConteudo()%></span>
                    </td>
                    <form action="deletarMensagemController" method="post">
                        <td class="txtTxtInfo"> 
                            <input type="hidden" value="<%= men.getId()%>" name="idExcluir"/>
                            <input type="submit" class="botaoFiltrar" value="Excluir" />
                        </td>
                    </form>
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

