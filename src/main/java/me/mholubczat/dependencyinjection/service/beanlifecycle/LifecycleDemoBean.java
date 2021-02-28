package me.mholubczat.dependencyinjection.service.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("----------Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("----------Bean name is" + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("----------LifeCycleBean has been destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------LifeCycleBean has its properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("----------Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("----------The post construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("----------The pre destroy annotated method has been called");
    }

    public void beforeInit(){
            System.out.println("-----  -----Before init called by bean post processor");
    }

    public void afterInit(){
        System.out.println("-----  -----After init called by bean post processor");
    }

    public LifecycleDemoBean() {
        System.out.println("----------I am LifeCycleBean constructor");
    }
}
