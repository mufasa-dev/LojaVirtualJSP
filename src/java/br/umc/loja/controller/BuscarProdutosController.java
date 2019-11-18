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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
@WebServlet(urlPatterns = {"/BuscarProdutosController"})
public class BuscarProdutosController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        
        RequestDispatcher rd = null;
        try
        {
            ProdutoDAO pdao = new ProdutoDAO();
            
            List<Produto> listaProdutos = new ArrayList<Produto>();
            listaProdutos = pdao.getAll();
            int al = 2;
            
            request.setAttribute("al", al);
            request.setAttribute("listaProdutos", listaProdutos);
            rd = request.getRequestDispatcher("Produtos.jsp");
            
        }
        catch(Exception ex)
        {
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
