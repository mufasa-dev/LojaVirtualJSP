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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/ConsultaVendedores"})
public class ConsultaVendedores extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        
        RequestDispatcher rd = null;
        try {
            Vendedor vend = new Vendedor(nome, null, null);
            VendedorDAO vdao = new VendedorDAO();
            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            listaVendedores = vdao.Consultar(vend);
            request.setAttribute("listaProdutos", listaVendedores);
            rd = request.getRequestDispatcher("Vendedores.jsp");

        } catch (Exception ex) {
            request.setAttribute("erro", ex.toString());
           rd = request.getRequestDispatcher("/PaginaErro.jsp");
        } finally {
            rd.forward(request, response);
        }
        
    }
}
