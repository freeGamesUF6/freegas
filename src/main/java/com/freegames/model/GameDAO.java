/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mark
 */
public class GameDAO {
    
    //Inserir nou usuari
    public static void insertGame(Game u) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

    }
    
    public static void updateGame(Game u) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        //Llibre book = new Llibre(4, "Don Quijote de la Mancha", "Cervantes");
        session.update(u);
        session.getTransaction().commit();
    }
    
    public static void deleteGame(Game u){
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
    }
    
    public static List queryGames() {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Game");
        List<Game> list = new ArrayList();
        list = query.list();
//        for (Game u : list) {
//            list.add(u);
//        }
        session.getTransaction().commit();
        return list;
    }
    
  
    public static Game queryGame(Game g) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Game " +"where id="+g.getId()+"");
        Game list=(Game) query.uniqueResult();
        
        session.getTransaction().commit();
        return list;
    }

    public static void insertTransaction(Transaction u) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

    }
    
        public Set listUsersPerGame(String name){
        Set<Transaction> users;
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        Query query =session.createQuery("from Game where name='"+name+"'");
        Game gamer=(Game) query.uniqueResult();
        users=gamer.getUsers();
        
        return users;
    }
    
}
