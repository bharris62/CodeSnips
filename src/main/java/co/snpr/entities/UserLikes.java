package co.snpr.entities;

import javax.persistence.*;

@Entity
@Table(name="userLikes")
public class UserLikes {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    Comment comment;

    @ManyToOne
    User userVoter;

    @Column
    int upvote;

    @Column
    int downvote;

    public UserLikes() {
    }

    public UserLikes(Comment comment, User voter, int upvote, int downvote) {
        this.comment = comment;
        this.userVoter = voter;
        this.upvote = upvote;
        this.downvote = downvote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getVoter() {
        return userVoter;
    }

    public void setVoter(User voter) {
        this.userVoter = voter;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }
}
