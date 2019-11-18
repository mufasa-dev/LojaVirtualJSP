/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.controller;

import br.umc.loja.model.Vendedor;
import br.umc.loja.model.dao.ProdutoDAO;
import br.umc.loja.model.dao.VendedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AbrirAlterarPerfilController", urlPatterns = {"/AbrirAlterarPerfilController"})
public class AbrirAlterarPerfilController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int id = (int) sessionsa.getAttribute("idVendedor");
        
         RequestDispatcher rd = null;
       try
        {
            VendedorDAO vdao = new VendedorDAO();
            
            Vendedor vende = new Vendedor(null, null, null);
            vende = vdao.getAllbyId(id);
            
            request.setAttribute("listaVendedores", vende);
            
            rd = request.getRequestDispatcher("AlterarVendedor.jsp");
            
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
