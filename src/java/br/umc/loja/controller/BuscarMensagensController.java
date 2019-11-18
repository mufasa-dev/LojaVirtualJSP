/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.loja.controller;

import br.umc.loja.model.Mensagem;
import br.umc.loja.model.dao.MensagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Bruno
 */
@WebServlet(name = "BuscarMensagensController", urlPatterns = {"/BuscarMensagensController"})
public class BuscarMensagensController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionsa = request.getSession(false);
        int idVendedor = (int) sessionsa.getAttribute("idVendedor");
         
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try
        {
            MensagemDAO pdao = new MensagemDAO();
            List<Mensagem> listaProdutos = new ArrayList<Mensagem>();
            listaProdutos = pdao.getAll(idVendedor);
            request.setAttribute("listaMensagens", listaProdutos);
            RequestDispatcher rd = request.getRequestDispatcher("Mensagens.jsp");
            rd.forward(request, response);
        }
        catch(Exception ex)
        {
           request.setAttribute("erro", ex.toString());
           RequestDispatcher rd = request.getRequestDispatcher("/PaginaErro.jsp");
           rd.forward(request, response);
        } finally {
            out.close();
        }
    }

}