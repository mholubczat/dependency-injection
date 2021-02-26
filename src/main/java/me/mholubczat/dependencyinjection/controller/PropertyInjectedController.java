package me.mholubczat.dependencyinjection.controller;

import me.mholubczat.dependencyinjection.service.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
       return greetingService.sayGreeting();
    }
}
