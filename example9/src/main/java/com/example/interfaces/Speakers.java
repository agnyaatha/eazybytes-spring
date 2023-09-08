package com.example.interfaces;

import com.example.model.Song;

public interface Speakers {

    String makeSound();
    String makeSound(boolean vehicleStarted, Song song);
}
