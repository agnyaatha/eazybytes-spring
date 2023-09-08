package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

//@Component
public class Vehicle {

    private String name;

    public Vehicle(){
        System.out.println("Vehicle Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

//    @PostConstruct
//    private void initialize(){
//        this.setName( "Tata Motors" );
//    }
}
