/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freegames.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Xavier
 */
@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
//    @Id
//    private Long id;
    @ManyToOne
    @JoinColumn(name="iduser")
    @Id
    private User iduser;
    @ManyToOne
    @JoinColumn(name="idgame")
    @Id
    private Game idgame;
    
    

    

    public Transaction() {
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Game getIdgame() {
        return idgame;
    }

    public void setIdgame(Game idgame) {
        this.idgame = idgame;
    }

   

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    
    
    

    
    
    
    
    
}
