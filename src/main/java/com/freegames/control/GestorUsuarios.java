/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.control;

import com.freegames.model.User;
import com.freegames.model.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xavier
 */
public class GestorUsuarios extends HttpServlet{
    
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
        try {
            PrintWriter out = response.getWriter();
            String op = request.getParameter("accio");

            //si l'accio es loguin accedeix aqui
            if (op.equals("login")) {
                //a traves de usebeans pasem els atributs de l'objecte directament.
                //User u es el que rebem del formulari
                User u = (User) request.getAttribute("logueo");
                UserDAO uDao =new  UserDAO();
                //User u2 es el que agafem de la BBDD
                User u2=uDao.queryUser(u);
                if(u2!=null){
                    if (u2.getPassword().equals(u.getPassword())) {
                        //JSP a la que se le redirige si el login es OK!
                        request.getSession().setAttribute("mail", u2.getEmail());
                        request.getSession().setAttribute("nickname", u2.getNick());
                        RequestDispatcher rd = request.getRequestDispatcher("listGames.jsp");
                        rd.forward(request, response);
                    }else{
                        throw new PasswordFailException();
                    }
                }
                
                //si l'accio es singin accedeix aquí
            } else if (op.equals("singin")) {
                User u = (User) request.getAttribute("registro");
                UserDAO uDao=new UserDAO();
                User comprovador=uDao.queryUser(u);
                //comprovem si el nick esta disponible
                if (comprovador==null) {
                    //JSP a la que se le redirige si el login es OK!
                     
                    request.getSession().setAttribute("mail", comprovador.getEmail());
                    request.getSession().setAttribute("nickname", comprovador.getNick());
                    RequestDispatcher rd = request.getRequestDispatcher("listGames.jsp");
                    rd.forward(request, response);
                }else{
                    throw new UsuariRepetitException();
                }
                

            }

        } catch (Exception e) {
            System.out.println("Petó!!!" + e);
            throw new ServletException(e);
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
        return "Short description";
    }// </editor-fold>

}

    

