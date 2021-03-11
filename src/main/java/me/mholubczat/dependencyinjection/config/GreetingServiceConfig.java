package me.mholubczat.dependencyinjection.config;

import me.mholubczat.dependencyinjection.service.ConstructorGreetingService;
import me.mholubczat.dependencyinjection.service.PrimaryGreetingService;
import me.mholubczat.dependencyinjection.service.PropertyInjectedGreetingService;
import me.mholubczat.dependencyinjection.service.SetterInjectedGreetingService;
import me.mholubczat.dependencyinjection.service.profiles.I18nENGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
    @Profile("EN")
    @Bean("i18nService")
    I18nENGreetingService i18nEnglishService(){ return new I18nENGreetingService();}

    @Profile({"ES","default"})
    @Bean
    I18nENGreetingService i18nService(){ return new I18nENGreetingService();}
}
