package me.mholubczat.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedGreetingService implements GreetingService {


    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
