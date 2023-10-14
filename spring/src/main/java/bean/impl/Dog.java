package bean.impl;

import bean.IAnimal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements IAnimal {
    @Override
    public void display() {
        System.out.println("狗...");
    }
}