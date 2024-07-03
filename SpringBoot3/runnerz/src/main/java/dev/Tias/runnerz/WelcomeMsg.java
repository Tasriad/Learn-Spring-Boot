package dev.Tias.runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMsg {
    public String getWelcomeMsg()
    {
        return "Welcome to the world of Spring Boot!";
    }
}
