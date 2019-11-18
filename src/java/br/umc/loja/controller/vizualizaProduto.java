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
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/vizualizaProduto"})
public class vizualizaProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idVendedor = (int) sessionsa.getAttribute("idVendedor");
        
       long id = Long.parseLong(request.getParameter("id"));
       RequestDispatcher rd = null;
       try
        {
            ProdutoDAO pdao = new ProdutoDAO();
            VendedorDAO vdao = new VendedorDAO();
            
            List<Produto> listaProdutos = new ArrayList<Produto>();
            listaProdutos = pdao.getAllbyId(id);
            
            for (Produto prod : listaProdutos) {
                Vendedor vendedor = vdao.getAllbyId(prod.getIdVendedor());
                request.setAttribute("vendedor", vendedor);
            }
            request.setAttribute("listaProdutos", listaProdutos);
            request.setAttribute("idUsuario", idVendedor);
            
            rd = request.getRequestDispatcher("DetalhesProduto.jsp");
            
        }
        catch(Exception ex)
        {
           request.setAttribute("erro", ex.toString());
           rd = request.getRequestDispatcher("/PaginaErro.jsp");
           
        } finally {
            rd.forward(request, response);
        }
    }

}
