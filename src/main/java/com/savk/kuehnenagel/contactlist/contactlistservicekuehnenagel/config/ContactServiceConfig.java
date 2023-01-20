package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.config;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactServiceConfig {
    @Value("${spring.profiles.active}")
    private String profile;
    @Bean
    public ModelMapper modelMapper()    {
        return new ModelMapper();
    }

    @PostConstruct
    private void fun()  {
        System.out.println("PROFILE = " + profile);
    }
}
