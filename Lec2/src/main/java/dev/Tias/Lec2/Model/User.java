package dev.Tias.Lec2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String password;
}
