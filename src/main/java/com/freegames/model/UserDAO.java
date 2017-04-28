/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mark
 */
public class UserDAO {
       
    
    
    //Inserir nou usuari
    public void insertUser(User u) {
        System.out.println("Hola estic a insert user");
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

    }
    
    public  void updateUser(User u) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        //Llibre book = new Llibre(4, "Don Quijote de la Mancha", "Cervantes");
        session.update(u);
        session.getTransaction().commit();
    }
    
    public  void deleteUser(User u){
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
    }
    
    public List queryUsers() {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from user");
        List<User> list = new ArrayList();
        list = query.list();
        for (User u : list) {
            list.add(u);
        }
        session.getTransaction().commit();
        return list;
    }
    
    public static User queryUser(User g) {
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User " +"where nick='"+g.getNick()+"'");
        User list=(User) query.uniqueResult();
        
        session.getTransaction().commit();
        return list;
    }
}
