package com.kyoulho.booksAroundMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:api.properties"})
public class BooksAroundMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksAroundMeApplication.class, args);
    }

}
