package co.snpr.entities;

import javax.persistence.*;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String content;

    @ManyToOne
    Snippet snippet;

    @ManyToOne
    User user;

    public Comment() {
    }

    public Comment(String content, Snippet snippet, User user) {
        this.content = content;
        this.snippet = snippet;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
