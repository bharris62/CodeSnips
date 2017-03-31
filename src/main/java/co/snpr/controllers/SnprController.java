package co.snpr.controllers;

import co.snpr.entities.Snippet;
import co.snpr.services.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class SnprController {

    @Autowired
    SnippetRepository snippets;

    @RequestMapping(path="/add-snip", method = RequestMethod.POST)
    public String addSnip(String code){
        snippets.save(new Snippet(code));
        return("redirect:/");
    }

    @RequestMapping(path="/get-all", method = RequestMethod.GET)
    @ResponseBody
    public List<Snippet> getAllSnips(){
        return (List)snippets.findAll();
    }
}
