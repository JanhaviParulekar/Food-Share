package com.wt.pro.pojo;

import com.wt.pro.pojo.Email;
import com.wt.pro.pojo.Person;
import javax.persistence.*;


@Entity
@Table(name="user_table")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person {

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    
    @Column(name="role")
    private String role;

    @OneToOne(mappedBy="user" , cascade= CascadeType.ALL)
    private Email email;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    
    
}