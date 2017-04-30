package co.snpr.controllers;

import co.snpr.entities.Snippet;
import co.snpr.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SnprController {

    @Autowired
    SnippetRepository snippets;

    @RequestMapping(path="/snip", method = RequestMethod.POST)
    public Snippet addSnip(String code){
        Snippet s = new Snippet(code);
        snippets.save(s);
        return s;
    }

    @RequestMapping(path="/snip/{id}")
    public Snippet getSnip(@PathVariable("id") Integer id){

        Snippet s = snippets.findOne(id);
        return s;
    }

    @RequestMapping(path="/snip", method = RequestMethod.GET)
    public List<Snippet> getAllSnips(){

        return (List)snippets.findAll();


    }
}
