package dev.Tias.Lec3.Service;

import dev.Tias.Lec3.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<User> users = new ArrayList<>(Arrays.asList(new User(1, "User 1", "password1"),
            new User(2, "User 2", "password2"),
            new User(3, "User 3", "password3"),
            new User(4, "User 4", "password4")));

    public List<User> getUsers() {
        return users;
    }
    public Optional<User> getUserbyId(int id) {
        return Optional.of(users.stream().filter(user -> user.getUserId() == id).findFirst().get());
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void updateUser(User user){
        User currentUser = users.stream()
                .filter(u->u.getUserId()==user.getUserId())
                .findFirst()
                .get();
        currentUser.setUserId(user.getUserId());
        currentUser.setUserName(user.getUserName());
        currentUser.setPassword(user.getPassword());
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getUserId() == id);
    }
}
