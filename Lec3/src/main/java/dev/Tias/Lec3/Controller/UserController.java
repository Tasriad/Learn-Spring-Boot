package dev.Tias.Lec3.Controller;

import dev.Tias.Lec3.Model.User;
import dev.Tias.Lec3.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @RequestMapping("/users/{id}")
    public Optional<User> getUserbyId(@PathVariable int id) {
        return userService.getUserbyId(id);
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    //note-> we cant update userid
    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
