package pojo;

import lombok.Data;

@Data
public class User implements Person{
    private String username;

    @Override
    public void doWork() {
        System.out.println("user do work...");
    }
}