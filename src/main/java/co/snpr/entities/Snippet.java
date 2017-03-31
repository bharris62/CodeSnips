package co.snpr.entities;

import javax.persistence.*;


@Entity
@Table(name="snippets")
public class Snippet {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable=false, length = 1000)
    String text;

    public Snippet() {
    }

    public Snippet(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
