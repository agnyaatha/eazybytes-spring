package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import com.example.service.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example8 {

    // Bean scope - @Scope(singleton, prototype), @Lazy, Eager - by default

    public static void main( String[] args ) {
        var context = new AnnotationConfigApplicationContext( ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices",VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " +vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " +vehicleServices2.hashCode());
        if(vehicleServices1==vehicleServices2){
            System.out.println("VehicleServices bean is a singleton scoped bean");
        }else{
            System.out.println("VehicleServices bean is a prototype scoped bean");
        }
        // -------------------------------------------------------------------------------
        System.out.println("Line before creating bean");
        Person person = context.getBean( Person.class);
        System.out.println("Line after creating bean");
    }
}
