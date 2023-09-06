package com.example.main;

import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example3 {

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle v1 = context.getBean( Vehicle.class );
        System.out.println("Beans created using XML configuration : " + v1.getName());
    }
}
