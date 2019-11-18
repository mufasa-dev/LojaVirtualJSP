package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Produto;
import br.umc.loja.model.conectaDB;
import br.umc.loja.model.dao.ProdutoDAO;
import br.umc.loja.model.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
@WebServlet(urlPatterns = {"/Salvar"})
public class Salvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String foto = request.getParameter("foto");
        String descri = request.getParameter("descri");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
        
        try {
            Produto prod = new Produto(nome, marca, foto, descri, preco, idVendedor);
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.insert(prod);

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }

        request.getRequestDispatcher("BuscarProdutosController").forward(request, response);
    }
}
