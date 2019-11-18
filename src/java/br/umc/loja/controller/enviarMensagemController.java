/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.controller;

import br.umc.loja.model.Vendedor;
import br.umc.loja.model.dao.VendedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "enviarMensagemController", urlPatterns = {"/enviarMensagemController"})
public class enviarMensagemController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idUsauario = (int) sessionsa.getAttribute("idVendedor");
        String nomeDest = request.getParameter("nomeDest");
       
        RequestDispatcher rd = null;
        try {
            VendedorDAO vdao;
            vdao = new VendedorDAO();
            Vendedor vende = new Vendedor(null, null, null);
            vende = vdao.getAllbyId(idUsauario);
            
            request.setAttribute("listaVendedores", vende);
            request.setAttribute("nomeDest", nomeDest);
            
            rd = request.getRequestDispatcher("EnviarMensagem.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(enviarMensagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(enviarMensagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
