/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GeracaoHash;
import model.dao.UsuarioDao;
import model.entities.Usuario;
import org.apache.catalina.Session;
import org.apache.catalina.ha.ClusterSession;

/**
 *
 * @author heitor.filho
 */
@WebServlet(name = "autenticar", urlPatterns = {"/autenticar"})
public class Autenticar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDao userDao = new UsuarioDao();
        Usuario usuario = new Usuario();

        String nomeUsuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String hash = request.getParameter("tipoHash");
        try {
            Session s = null;
            GeracaoHash autenticar = new GeracaoHash();
            boolean valida = autenticar.validaLogin(nomeUsuario, senha, hash);
            if (valida) {
                s.setValid(true);
                RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("resposta", "Login efetuado com sucesso");
                dispacher.forward(request, response);

            } else {
                s.setValid(false);
                RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("resposta", "Login ou senha inválidos");
                dispacher.forward(request, response);
            }
        } catch (Exception ex) {
            RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("resposta", "Login ou senha inválidos");
            dispacher.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
