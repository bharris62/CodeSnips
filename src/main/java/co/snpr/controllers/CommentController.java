package co.snpr.controllers;

import co.snpr.entities.Comment;
import co.snpr.entities.Snippet;
import co.snpr.entities.User;
import co.snpr.repositories.CommentRepository;
import co.snpr.repositories.SnippetRepository;
import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path="/snip/{id}/comment", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment, @PathVariable String id ){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByEmail(name);
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
}
