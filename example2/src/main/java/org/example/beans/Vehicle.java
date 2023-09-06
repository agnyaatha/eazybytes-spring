package org.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void hello(){
        System.out.println("Sample function to test @ComponentScan Bean creation");
    }

    @PostConstruct
    public void intialize(){
        System.out.println("Before creating bean");
        this.setName( "Maruti" );
    }

    @PreDestroy
    public void destroyBean(){
        System.out.println("Before destroying bean");
    }
}
