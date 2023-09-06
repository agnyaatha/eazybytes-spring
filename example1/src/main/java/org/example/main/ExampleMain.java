package org.example.main;

import org.example.beans.Vehicle;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleMain {

    public static void main( String[] args ) {

        Vehicle vehicle0 = new Vehicle();
        vehicle0.setName( "Maruti" );
        System.out.println("Outside spring context : " + vehicle0.getName() );


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( ProjectConfig.class);
        Vehicle v1 = context.getBean( Vehicle.class );
        System.out.println("Inside spring context : " + v1.getName());

        Vehicle v2 = context.getBean( "vehicle2", Vehicle.class );
        System.out.println("Bean name vehicle2 : " + v2.getName());

    }
}
