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
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/SalvarVendedor"})
public class SalvarVendedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String eMail = request.getParameter("eMail");
        
        try {
            Vendedor vend = new Vendedor(nome, senha, eMail);
            VendedorDAO vdao = new VendedorDAO();
            vdao.insert(vend);

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }
        
        PrintWriter out = response.getWriter();  
        out.println("<script src=\"js/botoes.js\" type=\"text/javascript\"></script>");
        out.println("<script>mostrarVendedorCadastrado();mostrarLogin();</script>");
        
                    
    }


}
