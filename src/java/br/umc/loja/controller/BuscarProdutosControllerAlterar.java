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
@WebServlet(urlPatterns = {"/BuscarProdutosControllerAlterar"})
public class BuscarProdutosControllerAlterar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idVendedor = (int) sessionsa.getAttribute("idVendedor");
         
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try
        {
            ProdutoDAO pdao = new ProdutoDAO();
            List<Produto> listaProdutos = new ArrayList<Produto>();
            listaProdutos = pdao.getAllMy(idVendedor);
            request.setAttribute("listaProdutos", listaProdutos);
            RequestDispatcher rd = request.getRequestDispatcher("Alterar.jsp");
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
