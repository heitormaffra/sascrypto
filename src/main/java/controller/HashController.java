/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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

/**
 *
 * @author curso
 */
@WebServlet(name = "adicionarContato", urlPatterns = {"/adicionarContato"})
public class HashController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String user = request.getParameter("user");
            String pass = request.getParameter("senha");
            String tipoHash = request.getParameter("tipoHash");

            GeracaoHash hash = new GeracaoHash();
            try {

                if (!user.isEmpty() && !pass.isEmpty()) {
                    String senhaHash = hash.gerarHash(tipoHash, pass);
                    Usuario usuario = new Usuario();
                    usuario.setNomeUsuario(user);
                    usuario.setSenhaUsuario(senhaHash);


                    UsuarioDao usuarioDao = new UsuarioDao();

                    usuarioDao.salvar(usuario);

                    RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("resposta", usuario.getNomeUsuario() + " foi cadastrado com sucesso. Hash: <strong>" + usuario.getSenhaUsuario() + "</strong>" );
                    dispacher.forward(request, response);
                } else {
                    RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("resposta", "Preencha os campos corretamente");
                    dispacher.forward(request, response);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(HashController.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        } finally {
            out.close();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
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
