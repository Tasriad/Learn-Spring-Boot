package dev.Tias.Lec1;

import org.springframework.stereotype.Component;

@Component
public class Macbook implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling using Macbook ");
    }
}
