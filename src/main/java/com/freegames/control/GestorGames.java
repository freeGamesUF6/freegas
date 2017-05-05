/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.control;

//import com.freegames.control.exceptions.GameRepetitException;
import com.freegames.model.Game;
import com.freegames.model.GameDAO;
import com.freegames.model.Transaction;
import com.freegames.model.TransactionDAO;
import com.freegames.model.User;
import com.freegames.model.UserDAO;
import com.freegames.model.Utilitats;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhona
 */
public class GestorGames extends HttpServlet {

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

            Session session = Utilitats.getSessionFactory().openSession();
            String op = request.getParameter("accio");

            if (op.equals("alta")) {
                //vista
                response.sendRedirect("views/games/formGame.jsp");

            } else if (op.equals("insert")) {

                try {
                    Game game1 = (Game) request.getAttribute("game");
                    GameDAO ud = new GameDAO();

                    ud.insertGame(game1);

                    response.sendRedirect("index.jsp");
                } catch (Exception e) {
                    System.out.println("Repetido");
                    //throw new GameRepetitException();
                }
            } else if (op.equals("descargar")) {

                try {

                    
                    String nick = (String) request.getSession().getAttribute("nickname");
                    
                    int idGame = Integer.parseInt(request.getParameter("idGame"));
                   

                    User usAux = new User(nick);
                    UserDAO Udao = new UserDAO();
                    User us = Udao.queryUser(usAux);

                    Game gaAux = new Game(idGame);
                    GameDAO Gdao = new GameDAO();
                    Game ga = Gdao.queryGame(gaAux);

                    Transaction e = new Transaction();
                    TransactionDAO ed = new TransactionDAO();

                    e.setIdgame(ga);
                    e.setIduser(us);
                    ed.insertTransaction(e);

                    response.sendRedirect("views/games/index.jsp"); //deveria redireccionar al perfil del usuario
                } catch (Exception e) {
                    System.out.println("descar errrorrrrrrrrrrrrrrrrrr");
                    //throw new GameRepetitException();
                }
            } else if (op.equals("perfil")) {

                try {


                    int idGame = Integer.parseInt(request.getParameter("idGame"));
                    

                    Game gaAux = new Game(idGame);
                    GameDAO Gdao = new GameDAO();
                    Game ga = Gdao.queryGame(gaAux);

                  
                    request.setAttribute("name", ga.getName());
                    request.setAttribute("description", ga.getDescription());
                    request.setAttribute("developer", ga.getDeveloper());
                    request.setAttribute("img", ga.getUrl_img());
                    request.setAttribute("url", ga.getUrl_download());
               
                    
                   //Set<Transaction> users=gaAux.getUsers();
                   
                      System.out.println("llege aqiiiiiiiii");
                    //for (Transaction user : users) {
                       // System.out.println("-"+user.getIduser().getNick());
                     //   System.out.println("hola caracola");
                   // }

                     RequestDispatcher rd = request.getRequestDispatcher("views/games/perfil.jsp");

                     rd.forward(request, response);
                     
                 
                   

       
                } catch (Exception e) {
                    System.out.println("perfil errrorrrrrrrrrrrrrrrrrr");
                    //throw new GameRepetitException();
                }
            }

        } catch (Exception e) {
            System.out.println("CONTROLADOR!!!!!!" + e);

            throw new ServletException(e);
            // System.out.println(e);
        }
          
       
        System.out.println("Soy el Jhona, este es mi pull!");
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
