package com.leal.store.resources;

import com.leal.store.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> FindAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1l, "Mario", "mario@gmail.com", "abc@123", "11 9 0000-0000"));
        return ResponseEntity.ok().body(users);
    }
}
