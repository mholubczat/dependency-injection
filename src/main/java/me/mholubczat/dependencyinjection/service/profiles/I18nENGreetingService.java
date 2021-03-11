package me.mholubczat.dependencyinjection.service.profiles;

import me.mholubczat.dependencyinjection.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18nENGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
