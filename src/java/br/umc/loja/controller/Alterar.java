package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.conectaDB;
import br.umc.loja.model.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11152100531
 */
@WebServlet(urlPatterns = {"/Alterar"})
public class Alterar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         long id = Long.parseLong(request.getParameter("id_altera"));
         String nome = request.getParameter("nome");
         String marca = request.getParameter("marca");
         String foto = request.getParameter("foto");
         String descri = request.getParameter("descri");
         Double preco = Double.parseDouble(request.getParameter("preco"));
         
        try {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.altera(id, nome, marca, foto, descri, preco);
         } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }

        //request.getRequestDispatcher("Produtos.jsp").forward(request, response);
        response.sendRedirect("BuscarProdutosControllerAlterar");
        }
    }




