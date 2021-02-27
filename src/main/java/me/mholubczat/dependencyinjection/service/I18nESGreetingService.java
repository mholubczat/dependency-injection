package me.mholubczat.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service()
public class I18nSPGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
