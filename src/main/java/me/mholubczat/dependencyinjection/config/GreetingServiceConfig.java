package me.mholubczat.dependencyinjection.config;

import me.mholubczat.dependencyinjection.datasource.FakeDataSource;
import me.mholubczat.dependencyinjection.repositories.EnglishGreetingRepository;
import me.mholubczat.dependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import me.mholubczat.dependencyinjection.service.ConstructorGreetingService;
import me.mholubczat.dependencyinjection.service.PrimaryGreetingService;
import me.mholubczat.dependencyinjection.service.PropertyInjectedGreetingService;
import me.mholubczat.dependencyinjection.service.SetterInjectedGreetingService;
import me.mholubczat.dependencyinjection.service.profiles.I18nENGreetingService;
import me.mholubczat.pets.PetService;
import me.mholubczat.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:di-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${mh.username}") String username,
                                  @Value("${mh.password}") String password,
                                  @Value("${mh.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setJdbcurl(jdbcurl);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUsername(username);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }


    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }


    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nENGreetingService i18nEnglishService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nENGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean
    I18nENGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nENGreetingService(englishGreetingRepository);
    }
}
