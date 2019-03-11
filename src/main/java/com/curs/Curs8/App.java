package com.curs.Curs8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication app= new SpringApplication(App.class);
        app.run(args);
    }
}
