package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Produto;
import br.umc.loja.model.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
@WebServlet(urlPatterns = {"/BuscarProdutosControllerExcluir"})
public class BuscarProdutosControllerExcluir extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try
        {
            ProdutoDAO pdao = new ProdutoDAO();
            List<Produto> listaProdutos = new ArrayList<Produto>();
            listaProdutos = pdao.getAll();
            request.setAttribute("listaProdutos", listaProdutos);
            RequestDispatcher rd = request.getRequestDispatcher("Excluir.jsp");
            rd.forward(request, response);
        }
        catch(Exception ex)
        {
           request.setAttribute("erro", ex.toString());
           RequestDispatcher rd = request.getRequestDispatcher("/PaginaErro.jsp");
           rd.forward(request, response);
        } finally {
            out.close();
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
