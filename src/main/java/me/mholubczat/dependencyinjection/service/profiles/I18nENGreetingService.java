package me.mholubczat.dependencyinjection.service.profiles;

import me.mholubczat.dependencyinjection.repositories.EnglishGreetingRepository;
import me.mholubczat.dependencyinjection.service.GreetingService;


public class I18nENGreetingService implements GreetingService {


    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nENGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
