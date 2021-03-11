package me.mholubczat.dependencyinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - from the primary bean";
    }
}
