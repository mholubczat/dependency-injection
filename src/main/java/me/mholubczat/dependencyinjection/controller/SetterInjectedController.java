package me.mholubczat.dependencyinjection.controller;

import me.mholubczat.dependencyinjection.service.GreetingService;
import me.mholubczat.dependencyinjection.service.GreetingServiceImpl;

public class SetterInjectedController {

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
