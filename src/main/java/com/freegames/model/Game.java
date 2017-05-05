/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Xavier
 * @version 1.0
 */
@Entity
@Table(name="game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="developer")
    private String developer;
    @Column(name="idcategory")
    private String idcategory;
    @OneToMany(fetch = FetchType.LAZY,mappedBy="idgame",cascade= CascadeType.ALL)
   // @JoinTable(name="transaction")
    private Set<Transaction> users;
    
    private static final long serialVersionUID=1L;
    
    
    public Game(int id, String name, String developer, String category) {
        this.id = id;
        this.name = name;
        this.developer = developer;
        this.idcategory = category;
    }
 /*
    *Constructor para buscar juego por ID
    *@author: Jhonatan
    */
    public Game(int id) {
        this.id = id;
    }


    
    
    

    public Game() {
    }
    
    
    

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getCategory() {
        return idcategory;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl_img() {
        return url_img;
    }

    public String getUrl_download() {
        return url_download;
    }

    public Set<Transaction> getUsers() {
        return users;
    }

    public void setUsers(Set<Transaction> users) {
        this.users = users;
    }
    
    
    
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setCategory(String category) {
        this.idcategory = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public void setUrl_download(String url_download) {
        this.url_download = url_download;
    }

    
    
    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", name=" + name + ", developer=" + developer + ", idcategory=" + idcategory + ", description=" + description + ", url_img=" + url_img + ", url_download=" + url_download + '}';
    }

    
    
    
}
