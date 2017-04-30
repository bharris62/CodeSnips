package co.snpr.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by BHarris on 4/27/17.
 */
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column
    String username;

    @Column
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

