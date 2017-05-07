package co.snpr.controllers;

import co.snpr.entities.Comment;
import co.snpr.entities.Snippet;
import co.snpr.entities.User;
import co.snpr.entities.UserLikes;
import co.snpr.repositories.CommentRepository;
import co.snpr.repositories.SnippetRepository;
import co.snpr.repositories.UserLikesRepository;
import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentRepository comments;

    @Autowired
    SnippetRepository snippets;

    @Autowired
    UserRepository users;

    @Autowired
    UserLikesRepository userLikes;

    @RequestMapping(path="/snip/{id}/comment", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment, @PathVariable String id, HttpServletResponse response) throws IOException {
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByEmail(name);
        if(user == null) {
            response.sendError(400, "You must be logged in");
        }
        Snippet snip = snippets.findOne(Integer.parseInt(id));
        Comment c = new Comment(comment.getComment(), snip, user);
        comments.save(c);
        return c;
    }

    @RequestMapping(path="/snip/comment/{id}", method=RequestMethod.GET)
    public List<Comment> getComment(@PathVariable String id){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByEmail(name);

        List<Comment> cmnts = comments.findAllBySnippetIdAndIsLiveTrue(Integer.parseInt(id));

        return cmnts;
    }

    @RequestMapping(path="/snip/comment/{id}", method=RequestMethod.DELETE)
    public void deleteComment(@PathVariable String id){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByEmail(name);

        comments.updateLive(false, Integer.parseInt(id));
    }

    @RequestMapping(path="snip/comment/rate/{id}", method = RequestMethod.POST)
    public UserLikes rateComment(@PathVariable String id, @RequestBody String rate) {
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByEmail(name);
        Comment c = comments.findOne(Integer.parseInt(id));

        UserLikes like = new UserLikes(c, user, 1, 0);
        userLikes.save(like);
        return like;
    }

}
