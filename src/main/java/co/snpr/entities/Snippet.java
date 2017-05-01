package co.snpr.entities;

import javax.persistence.*;


@Entity
@Table(name="snippets")
public class Snippet {
    @Id
    @GeneratedValue
    int id;

    //
    @Column(nullable=false, length = 100)
    private String title;

    @Column(nullable=false, length = 1000)
    private String description;

    @Column(nullable=false)
    private User user;

    @Transient
    private int userId;

    public Snippet(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Snippet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
