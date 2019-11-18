package br.umc.loja.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.umc.loja.model.Mensagem;
import br.umc.loja.model.Produto;
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


@WebServlet(urlPatterns = {"/MandarMensagemController"})
public class MandarMensagemController extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idUsauario = (int) sessionsa.getAttribute("idVendedor");
        String nomeDest = request.getParameter("destinatario");
        String assunto = request.getParameter("assunto");
        String conteudo = request.getParameter("descri");
        
        try {
            VendedorDAO vdao = new VendedorDAO();
            int idDest = vdao.getAllbyNome(nomeDest);
            
            Mensagem mem = new Mensagem(idDest, idUsauario, assunto, conteudo);
            MensagemDAO mdao = new MensagemDAO();
            mdao.insert(mem);

        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        } finally {
        }

        request.getRequestDispatcher("BuscarVendedoresController").forward(request, response);
    }
}
