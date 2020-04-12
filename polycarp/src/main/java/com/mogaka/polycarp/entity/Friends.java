/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogaka.polycarp.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

import javax.persistence.GenerationType;
/**
 *
 * @author moha
 */
@Entity
@Table(name = "Friends")
public class Friends implements Serializable {

    private long id;
    private String fname;
    private String lname;
    private String email;
 
    public Friends() {
  
    }
 
    public Friends(String firstName, String lastName, String emailId) {
         this.fname= firstName;
         this.lname= lastName;
         this.email= emailId;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Friend [id=" + id + ", first-Name=" + fname+ ", last-Name=" + lname+ ", email-Id=" + email
       + "]";
    }
    
    @Column(name = "email_address", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "first_name", nullable = false)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    @Column(name = "last_name", nullable = false)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
 
}