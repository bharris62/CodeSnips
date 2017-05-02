package co.snpr.entities;

import javax.persistence.*;

@Entity
@Table(name="snippets")
public class Snippet {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable=false, length = 100)
    private String title;

    @Column(nullable=false, length = 500)
    private String description;

    @Column(nullable=false, length = 1000)
    private String code;

    @Column(nullable=false)
    private String language;

    @ManyToOne
    private User user;

    public Snippet(String title, String description, String code, User user, String language) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.language = language;
        this.user = user;
    }

    public Snippet(String title, String description, String code, String language) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
