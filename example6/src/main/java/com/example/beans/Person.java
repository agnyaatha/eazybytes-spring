package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {


//    public Person(){
//        System.out.println("Person Constructor");
//    }

    private String name;

    // Wiring beans using @Autowired on class fields
//    @Autowired
    private final Vehicle vehicle;

    // Most preferred way of autowiring
    @Autowired
    public Person(Vehicle vehicle){
        System.out.println("Inside paramterized constructor");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // Wiring beans using @Autowired on setter methods
//    @Autowired
//    public void setVehicle( Vehicle vehicle ) {
//        this.vehicle = vehicle;
//    }

    @PostConstruct
    private void initialize(){
        this.setName( "Premya" );
    }
}
