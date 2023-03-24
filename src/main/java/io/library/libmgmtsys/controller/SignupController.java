package io.library.libmgmtsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.library.libmgmtsys.model.User;
import io.library.libmgmtsys.service.LibraryService;

@RequestMapping("/api")
@RestController
public class SignupController {
    @Autowired
    LibraryService libraryService;

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public boolean saveUser(@RequestBody User user) {
        return libraryService.addUser(user);
    }
}
