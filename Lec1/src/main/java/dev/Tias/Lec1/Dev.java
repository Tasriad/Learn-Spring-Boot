package dev.Tias.Lec1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    @Autowired // This is a dependency injection called field injection
    Computer computer;

    // This is a constructor injection
//    public Dev(Computer computer) {
//        this.computer = computer;
//    }

//    @Autowired  // This is a setter injection
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

    public void greet(){
        System.out.println("Hello from Dev");
        computer.compile();
    }
}
