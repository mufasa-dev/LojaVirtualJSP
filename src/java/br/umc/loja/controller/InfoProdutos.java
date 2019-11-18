package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Produto;
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

/**
 *
 * @author 11152100531
 */
@WebServlet(urlPatterns = {"/InfoProdutos"})
public class InfoProdutos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        try {
            ProdutoDAO pdao = new ProdutoDAO();
            VendedorDAO vdao = new VendedorDAO();

            int numeroProdutos = 0;
            int produtosVendidos = 0;
            int vendedoresCadastrados = 0;
            numeroProdutos = pdao.getNumber();
            produtosVendidos = pdao.getNumberVendidos();
            vendedoresCadastrados = vdao.getNumber();

            request.setAttribute("numeroVendedores", vendedoresCadastrados);
            request.setAttribute("numeroProdutosVendidos", produtosVendidos);
            request.setAttribute("numeroProdutos", numeroProdutos);

            rd = request.getRequestDispatcher("Sobre.jsp");

        } catch (Exception ex) {
            request.setAttribute("erro", ex.toString());
            rd = request.getRequestDispatcher("/PaginaErro.jsp");

        } finally {
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
