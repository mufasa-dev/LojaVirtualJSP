package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Produto;
import br.umc.loja.model.conectaDB;
import  br.umc.loja.model.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/ConsultaProdutos"})
public class ConsultaProdutos extends HttpServlet {

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        
        RequestDispatcher rd = null;
        try {
            Produto prod = new Produto(nome, marca, null, null, 0, 0);
            ProdutoDAO pdao = new ProdutoDAO();
            List<Produto> listaProdutos = new ArrayList<Produto>();
            listaProdutos = pdao.Consultar(prod);
            request.setAttribute("listaProdutos", listaProdutos);
            rd = request.getRequestDispatcher("Produtos.jsp");

        } catch (Exception ex) {
            request.setAttribute("erro", ex.toString());
           rd = request.getRequestDispatcher("/PaginaErro.jsp");
        } finally {
            rd.forward(request, response);
        }
        
    }


}
