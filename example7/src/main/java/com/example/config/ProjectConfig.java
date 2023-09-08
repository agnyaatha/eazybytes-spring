package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.example.beans")
public class ProjectConfig {

    @Bean
    @Primary
        // Commenting this would give NoUniqueBeanDefinitionException
    Vehicle vehicle1(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName( "Honda" );
        return vehicle;
    }

    // Naming a bean to avoid NoUniqueBeanDefinitionException
    // @Bean(value = "vehicle2) or @Bean("vehicle2")
    @Bean(name = "vehicle2")
    Vehicle vehicle2(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName( "Hyundai" );
        return vehicle;
    }
}
