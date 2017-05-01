package co.snpr.controllers;

import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository users;

    //TODO register a new user

    //TODO Login a new user

    //TODO Patch a new user
}
