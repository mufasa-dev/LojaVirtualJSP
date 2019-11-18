package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Mensagem;
import br.umc.loja.model.Vendedor;
import br.umc.loja.model.dao.MensagemDAO;
import br.umc.loja.model.dao.ProdutoDAO;
import br.umc.loja.model.dao.VendedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/Comprar"})
public class Comprar extends HttpServlet {

  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         long idProduto = Long.parseLong(request.getParameter("idProduto"));
         String nomeProduto = request.getParameter("nomeProduto");
         long idVendedor = Long.parseLong(request.getParameter("idVendedor"));
         HttpSession sessionsa = request.getSession(false);
         int idComprador = (int) sessionsa.getAttribute("idVendedor");

        try {
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.compra(idProduto, idVendedor);
            
            VendedorDAO vdao = new VendedorDAO();
            Vendedor comprador = vdao.getAllbyId(idComprador);
            
            Mensagem mem = new Mensagem((int)idVendedor, idComprador, comprador.getNome() + " comprou seu produto", comprador.getNome() + " comprou seu produto " + nomeProduto);
            MensagemDAO mdao = new MensagemDAO();
            mdao.insert(mem);
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }

        //request.getRequestDispatcher("Produtos.jsp").forward(request, response);
        response.sendRedirect("BuscarProdutosController");
    }

    
}
