package dev.Tias.Lec1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // This is used to tell spring that this is the primary bean to be used
public class Laptop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling using laptop ");
    }
}
