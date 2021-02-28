package me.mholubczat.dependencyinjection.controller.nameconvention;

public class NameConventionController {

    private final MyService myService;

    public NameConventionController(MyService myService) {
        this.myService = myService;
    }
}
