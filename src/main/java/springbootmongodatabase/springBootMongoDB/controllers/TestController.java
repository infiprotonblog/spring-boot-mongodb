package springbootmongodatabase.springBootMongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootmongodatabase.springBootMongoDB.model.User;
import springbootmongodatabase.springBootMongoDB.service.UserService;
import springbootmongodatabase.springBootMongoDB.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsersList() {
        return userService.userList();
    }

    @PostMapping("/create/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("user/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userService.user(id);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PutMapping("update/user")
    public User updateUser(@RequestBody User user) throws ResourceNotFoundException {
        return userService.updateUser(user);
    }
}
