package org.example.main;

import org.example.beans.Vehicle;
import org.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class ExampleMain2 {

    public static void main( String[] args ) {

        // Bean creation using @ComponentScan annotation
        // @PostConstruct
        // @PreDestroy

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( ProjectConfig.class);
        Vehicle v1 = context.getBean( Vehicle.class );
        System.out.println("Inside spring context : " + v1.getName());
        v1.hello();

        // Programtically addding beans
        System.out.println("---------------------------------------------------------");
        System.out.println("Programatically creating beans");

        Vehicle vw = new Vehicle();
        vw.setName( "Volkswagen" );
        Supplier<Vehicle> volkswagenSupplier = () -> vw ;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle() ;
            audi.setName( "Audi" );
            return audi;
        };

//        The Random.nextInt() method in Java is used to generate a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive). So, Random.nextInt(10) will generate a random integer between 0 and 9, inclusive.
        int randomNumber = new Random().nextInt(10);
        System.out.println("Random number = " + randomNumber);

        if(randomNumber % 2 == 0){
            context.registerBean( "volkswagen", Vehicle.class, volkswagenSupplier );
        }else{
            context.registerBean( "audi", Vehicle.class, audiSupplier );
        }

        Vehicle vwVehicle = null;
        Vehicle audiVehicle = null;

        try{
            vwVehicle = context.getBean( "volkswagen", Vehicle.class );
            System.out.println("Created Volkswagen bean");
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Volkswagen vehicle");
        }

        try{
            audiVehicle = context.getBean( "audi", Vehicle.class );
            System.out.println("Created Audi bean");
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Audi vehicle");
        }

        if(null != vwVehicle){
            System.out.println("Programming bean creation : " + vwVehicle.getName());
        }

        if(null != audiVehicle){
            System.out.println("Programming bean creation : " + audiVehicle.getName());
        }

    }
}
