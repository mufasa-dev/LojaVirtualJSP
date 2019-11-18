package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Vendedor;
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
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();  
        out.println("<script src=\"js/botoes.js\" type=\"text/javascript\"></script>");
        
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        try {
            VendedorDAO vdao = new VendedorDAO();
            Boolean valida = vdao.validarLogin(nome, senha);
            if (valida){
                HttpSession session = request.getSession ();  
                session.setAttribute ( "idVendedor" , vdao.decobrirId(nome, senha));  
                out.println("<script>fecharLogin();</script>");
            }else{
                out.println("<script>mostrarLogin();</script>");
            }
            
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }
    }
}
