package co.snpr.controllers;

import co.snpr.entities.Snippet;
import co.snpr.entities.User;
import co.snpr.repositories.SnippetRepository;
import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SnprController {

    @Autowired
    SnippetRepository snippets;

    @Autowired
    UserRepository users;

    @RequestMapping(path="/snip", method = RequestMethod.POST)
    public Snippet addSnip(@RequestBody Snippet snip){
        User u = users.findOne(snip.getUserId());
        Snippet s = new Snippet(snip.getTitle(), snip.getDescription(), u);
        snippets.save(s);
        return s;
    }

    @RequestMapping(path="/snip/{id}")
    public Snippet getSnip(@PathVariable("id") Integer id){

        Snippet snip = snippets.findOne(id);
        return snip;
    }

    @RequestMapping(path="/snip", method = RequestMethod.GET)
    public List<Snippet> getAllSnips(){

        return (List)snippets.findAll();
    }
}
