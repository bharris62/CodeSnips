package co.snpr.entities;

import javax.persistence.*;

/**
 * Created by BHarris on 4/27/17.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String userName;

    @Column
    String email;

    @Column
    String password;

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

