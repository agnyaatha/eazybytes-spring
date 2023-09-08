package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example7 {

    // Wiring beans using @Autowired on constructor

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( ProjectConfig.class );
        Vehicle vehicle = context.getBean( Vehicle.class );
        Person person = context.getBean( Person.class );
        System.out.println("Vehicle bean value : " + vehicle.getName());
        System.out.println("Person bean value : " + person.getName() + " --- " + person.getVehicle().getName());
    }
}
