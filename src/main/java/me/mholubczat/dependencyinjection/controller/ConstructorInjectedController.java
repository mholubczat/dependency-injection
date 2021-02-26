package me.mholubczat.dependencyinjection.controller;

import me.mholubczat.dependencyinjection.service.GreetingService;

public class ConstructorInjectedController {
private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
