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
@WebServlet(urlPatterns = {"/BuscarVendedoresController"})
public class BuscarVendedoresController extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher rd = null;
        try
        {
            VendedorDAO pdao = new VendedorDAO();
            
            List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
            listaVendedores = pdao.getAll();
            request.setAttribute("listaProdutos", listaVendedores);
            rd = request.getRequestDispatcher("Vendedores.jsp");
            
        }
        catch(Exception ex)
        {
           request.setAttribute("erro", ex.toString());
           rd = request.getRequestDispatcher("/PaginaErro.jsp");
           
        } finally {
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
