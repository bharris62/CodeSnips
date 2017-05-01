package co.snpr.controllers;

import co.snpr.entities.User;
import co.snpr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserRepository users;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(name="/users", method = RequestMethod.POST)
    public User registerUser(@RequestBody User data) {
        String userName = data.getUserName();
        String password = data.getPassword();
        String email = data.getEmail();

        User u = new User(userName, bCryptPasswordEncoder.encode(password), email);
        users.save(u);

        return u;

    }

    // view current users
    @RequestMapping(path = "users/current", method = RequestMethod.GET)
    public ResponseEntity<?> currentUser() {
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByUserName(name);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Invalid token.", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path="/users/{id}", method=RequestMethod.PATCH)
    public User updateUser(HttpServletResponse response, @RequestBody User data, @RequestParam(value = "id", required = false) int id) throws IOException {
        Authentication u = SecurityContextHolder.getContext().getAuthentication();
        String name = u.getName();
        User user = users.findFirstByUserName(name);

        if(data.getEmail() != null) {
            user.setEmail(data.getEmail());
        }

        if(data.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(data.getPassword()));
        }

        if(data.getUserName() != null) {
            response.sendError(404, "username can't be changed...");
        }

        users.save(user);

        return user;
    }
}
