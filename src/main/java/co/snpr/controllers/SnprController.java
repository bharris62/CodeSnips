package co.snpr.controllers;

import co.snpr.entities.Snippet;
import co.snpr.entities.User;
import co.snpr.repositories.SnippetRepository;
import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SnprController {

    @Autowired
    SnippetRepository snippets;

    @Autowired
    UserRepository users;

    @RequestMapping(path="/snip", method = RequestMethod.POST)
    public Snippet addSnip(@RequestBody Snippet snip){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByUserName(name);
        Snippet s;
        if(user == null) {
            s = new Snippet(snip.getTitle(), snip.getDescription(), snip.getCode(), snip.getLanguage());
        }else{
            s = new Snippet(snip.getTitle(), snip.getDescription(), snip.getCode(), user, snip.getLanguage());
        }
        snippets.save(s);
        return s;
    }

    @RequestMapping(path="/snip/{id}", method = RequestMethod.GET)
    public Snippet getSnip(@PathVariable("id") Integer id){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByUserName(name);

        Snippet snip = snippets.findOne(id);
        return snip;
    }

    @RequestMapping(path="/snip", method = RequestMethod.GET)
    public List<Snippet> getAllSnips(){
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByUserName(name);

        return (List)snippets.findAll();
    }
}
