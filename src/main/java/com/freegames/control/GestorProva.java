/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.control;

import com.freegames.model.Game;
import com.freegames.model.GameDAO;
import com.freegames.model.Transaction;
import com.freegames.model.TransactionDAO;
import com.freegames.model.User;
import com.freegames.model.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
public class GestorProva extends HttpServlet {

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
        
//        Game u=new Game();
//        GameDAO ud=new GameDAO();
//        u.setName("pruebaa");
//        u.setDeveloper("paco");
//        u.setCategory("12");
//        ud.insertGame(u);
//        
        User g=new User();
        UserDAO gd=new UserDAO();
//        g.setNick("manolo");
//        g.setEmail("prodfjd");
//        g.setPassword("15");
//        gd.insertUser(g);
//        
//        Game game=ud.queryGame(u);
//        User user=gd.queryUser(g);
//        System.out.println(game.getId()+"-"+user.getId());
//        Transaction e=new Transaction();
        TransactionDAO ed=new TransactionDAO();
//        e.setIdgame(game);
//        e.setIduser(user);
//        ed.insertTransaction(e);
       
        System.out.println("Soy el xavi, este es mi pull!");
        
        System.out.println("Soy el xavi, este es mi pull!");
        
        g.setNick("prova");
        User user=gd.queryUser(g);
        
       Set<Transaction> games=gd.listGamesPerUser(user.getNick());
        
        for (Transaction game : games) {
            System.out.println(game.getIdgame().getName()+"-"+game.getIduser().getNick());
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
