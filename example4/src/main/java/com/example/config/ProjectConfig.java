package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName( "Toyota" );
        return vehicle;
    }

    @Bean
    @Primary
    Person person(){
        Person person = new Person();
        person.setName( "Basya" );
        // Commenting below line -> No wiring
        person.setVehicle( vehicle() ); // Wiring beans using method call
        return person;
    }

    @Bean("parameterPerson")
    Person person2(Vehicle vehicle){
        Person person = new Person();
        person.setName( "Sisya" );
        person.setVehicle( vehicle );
        return person;
    }
}
