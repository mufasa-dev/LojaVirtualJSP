<%-- 
    Document   : Alterar
    Created on : 20/10/2017, 18:49:04
    Author     : 11152100531
--%>

<%@page import="br.umc.loja.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exercicio loja</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/creative.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/botoes.js" type="text/javascript"></script>
        <script src="js/CadastrarFoto.js" type="text/javascript"></script>
    </head>
    <body class="formAlt">
        <div class="formAlt">
            <table class="prodTable">
                <%
                    List<Produto> prods = (List<Produto>) request.getAttribute("listaProdutos");

                    for (Produto prod : prods) {
                %>
                <tr>
                <form action="Alterar" method="post">
                    <td rowspan="2">
                        <img src="img/produtos/<%=prod.getFoto()%>.jpg" class="altImg"/>
                    </td>
                    <td colspan="2"> <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarNome txtAlt"  value="<%=prod.getNome()%>" placeholder="Nome" name="nome"> </td>
                    <td> <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarNome txtAlt"  value="<%=prod.getMarca()%>" placeholder="Marca" name="marca"></td>
                    <td> <input type="hidden" value="<%= prod.getId()%>" name="id_altera"/> 
                        <input onclick="mostrarAlterado()"  type="submit" class="botaoExcluir" value="Alterar" /><br>
                    </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="txtFoto" class="cadTextBoxBuscar txtAltMini"  value="<%=prod.getFoto()%>" placeholder="Foto" name="foto" onkeypress="return ApenasNumeros(event)" onkeyup="altImagem()">
                        </td>
                        <td><span>preço:</span>
                            <input type="text" id="txtPreco" class="cadTextBoxBuscar txtAltMini"  value="<%=prod.getPreco()%>" placeholder="Preço" name="preco" onkeypress="return ApenasNumeros(event)" >
                        </td>
                        <td>
                            <input type="text" class="cadTextBoxBuscar cadTextBoxBuscarNome txtAlt"  value="<%=prod.getDescri()%>" placeholder="Descrição" name="descri">
                        </td></form>
                        <td>
                            <form action="excluir" method="post"> 
                            <input type="hidden" value="<%= prod.getId()%>" name="id_excluir"/>
                            <input  onclick="mostrarExcluido()" type="submit" class="botaoExcluir" value="Excluir" /> 
                        </form>
                        </td>
                    </tr>
                    <tr><td><br></td></tr>
                   
                
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
