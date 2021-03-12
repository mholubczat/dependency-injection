package me.mholubczat.dependencyinjection.repositories;

import org.springframework.stereotype.Component;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
