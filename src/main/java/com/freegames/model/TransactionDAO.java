/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import org.hibernate.Session;

/**
 *
 * @author Mark
 */
public class TransactionDAO {
     //Inserir nou usuari
    public void insertTransaction(Transaction u) {
        System.out.println("Hola estic a insert trans");
        Session session = Utilitats.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();

    }
}
