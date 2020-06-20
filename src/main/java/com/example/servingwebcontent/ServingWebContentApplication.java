package com.example.servingwebcontent;


import com.example.servingwebcontent.model.contact.Contact;
import com.example.servingwebcontent.model.contact.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[]args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }
}
