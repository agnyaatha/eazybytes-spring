package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgestoneTyres implements Tyres {

    @Override
    public String rotate() {
        return "Vehicle moving with Bridgestone tyres";
    }
}
