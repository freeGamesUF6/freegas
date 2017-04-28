/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Xavier
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nick")
    private String nick;
    @Column(name="password")
    private String password;
    @Column(name="mail")
    private String mail;
    @OneToMany(fetch = FetchType.LAZY,mappedBy="iduser",cascade= CascadeType.ALL)
    private Set<Transaction> games;
    
    public User(int id, String nick, String password, String email) {
        this.id = id;
        this.nick = nick;
        this.password = password;
        this.mail = email;
    }

    public User() {
    }
    
    

    //Getters
    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return mail;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nick=" + nick + ", password=" + password + ", email=" + mail + '}';
    }
    
    
    
    
    
    
    
}
