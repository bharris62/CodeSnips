//package co.snpr.entities;
//
//import javax.persistence.*;
//
//@Entity
//public class CommentLikes {
//    @Id
//    @GeneratedValue
//    int id;
//
//    @ManyToOne
//    private Comment comment;
//
//    @ManyToOne
//    private User user;
//
//    @Column
//    private int like;
//
//    @Column
//    private int dislike;
//
//    public CommentLikes() {
//    }
//
//    public CommentLikes(Comment comment, User user, int like, int dislike) {
//        this.comment = comment;
//        this.user = user;
//        this.like = like;
//        this.dislike = dislike;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Comment getComment() {
//        return comment;
//    }
//
//    public void setComment(Comment comment) {
//        this.comment = comment;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public int getLike() {
//        return like;
//    }
//
//    public void setLike(int like) {
//        this.like = like;
//    }
//
//    public int getDislike() {
//        return dislike;
//    }
//
//    public void setDislike(int dislike) {
//        this.dislike = dislike;
//    }
//}
