package com.br.velha.controller;

import com.br.velha.model.EstadoDoJogo;
import com.br.velha.sessionbeans.JogoManagerSBLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    
/**
 *
 * @author bruce
 */
public class FrontController extends HttpServlet {
    @EJB(name = "jogo")
    private JogoManagerSBLocal jogo;
    
    
    //Usado para verificar se o jogo já começou
    private boolean init = false;
    //Posições no tabuleiro (linha e coluna)
    private int x;
    private int y;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (init) {
                init = false;
                jogo.novoJogo();
                request.getSession().invalidate();
                atualizaTabuleiro(request, response);   
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                EstadoDoJogo estado = jogo.joga(x, y);
                request.getSession().setAttribute("estado", estado);
                atualizaTabuleiro(request, response);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }   
            
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            init = true;
        } else {
            try {
                x = Integer.parseInt(request.getParameter("x"));
                y = Integer.parseInt(request.getParameter("y"));
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao formatar a string");
            }
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        return "Controlador principal";
    }// </editor-fold>

    private void atualizaTabuleiro(HttpServletRequest request, HttpServletResponse response) throws RemoteException {
        request.getSession().setAttribute("tabuleiro", jogo.getTabuleiro());
    }
}
