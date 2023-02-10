package pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User implements Person{
    private String username;

    @Override
    public void doWork() {
        System.out.println("user do work...");
    }
}