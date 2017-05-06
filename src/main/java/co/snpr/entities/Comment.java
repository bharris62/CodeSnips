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
    private String comment;

    @Column
    private boolean isLive;

    @ManyToOne
    Snippet snippet;

    @ManyToOne
    User user;

    public Comment() {
    }

    public Comment(String comment, Snippet snippet, User user) {
        this.comment = comment;
        this.snippet = snippet;
        this.user = user;
        this.isLive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
