/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.controller;

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
 * @author Bruno
 */
@WebServlet(name = "AlterarVendedorController", urlPatterns = {"/AlterarVendedorController"})
public class AlterarVendedorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idVendedor = (int) sessionsa.getAttribute("idVendedor");
        String nome = request.getParameter("nome");
        String eMail = request.getParameter("eMail");
        String senhaAtual = request.getParameter("senhaAtual");
        String novaSenha = request.getParameter("NovaSenha");
        String descri = request.getParameter("descri");
        
        try {
        VendedorDAO vdao = new VendedorDAO();
        if(vdao.validarSenha(idVendedor, senhaAtual)){
            vdao.altera(idVendedor, nome, novaSenha, descri, eMail);
            response.sendRedirect("AbrirPerfilController");
        }else{
            response.sendRedirect("AbrirAlterarPerfilController");
        }
         } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }
    }
}
