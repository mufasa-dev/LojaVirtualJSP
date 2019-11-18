package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.umc.loja.model.Produto;
import br.umc.loja.model.Vendedor;
import br.umc.loja.model.dao.ProdutoDAO;
import br.umc.loja.model.dao.VendedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11152100531
 */
@WebServlet(urlPatterns = {"/vizualizaVendedor"})
public class vizualizaVendedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<script src=\"js/botoes.js\" type=\"text/javascript\"></script>");

        long id = Long.parseLong(request.getParameter("id"));
        HttpSession sessionsa = request.getSession(false);
        int idVendedor = (int) sessionsa.getAttribute("idVendedor");
        if (idVendedor == id) {
            out.println("<script>mostrarPerfil();</script>");
        } else {
            RequestDispatcher rd = null;
            try {
                ProdutoDAO pdao = new ProdutoDAO();
                VendedorDAO vdao = new VendedorDAO();

                Vendedor vende = new Vendedor(null, null, null);
                vende = vdao.getAllbyId(id);

                int prodDisponivel = vdao.getNumberProdutos((int) id);
                int prodVendido = vdao.getNumberProdutosVendidos((int) id);
                int prodComprado = vdao.getNumberProdutosComprados((int) id);

                request.setAttribute("listaVendedores", vende);
                request.setAttribute("prodDisponivel", prodDisponivel);
                request.setAttribute("prodVendido", prodVendido);
                request.setAttribute("prodComprado", prodComprado);

                rd = request.getRequestDispatcher("DetalhesVendedor.jsp");
            } catch (Exception ex) {
                request.setAttribute("erro", ex.toString());
                rd = request.getRequestDispatcher("/PaginaErro.jsp");

            } finally {
                rd.forward(request, response);
            }
        }
    }
}
