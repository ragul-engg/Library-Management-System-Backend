package io.library.libmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.library.libmgmtsys.model.LoginUser;
import io.library.libmgmtsys.model.User;
import io.library.libmgmtsys.service.LibraryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    LibraryService libraryService;

    @PostMapping("/login")
    public ResponseEntity<?> checkUser(@RequestBody LoginUser user) {
        // if (user.getEmail().equals("admin@library.io") &&
        // user.getPassword().equals("123456789"))
        // return new ResponseEntity<>(new HashMap<>(){"Login", "success"});
        return new ResponseEntity<>(libraryService.authUser(user), HttpStatus.OK);
        // HttpHeaders headers = new HttpHeaders();
        // headers.set("Access-Control-Allow-Credentials", "true");
        // headers.set("Access-Control-Allow-Headers", "Accept");
        // headers.set("Access-Control-Allow-Origin", "*");
        // HttpCookie c = ResponseCookie.from("name",
        // user.getEmail()).httpOnly(true).path("/").build();
        // return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
        // c.toString()).body(user);
    }

    @GetMapping("/login")
    public List<User> getAllUsers() {
        return libraryService.getAllUsers();
    }
}
