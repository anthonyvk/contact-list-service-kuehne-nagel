package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactServiceConfig {
    @Bean
    public ModelMapper modelMapper()    {
        return new ModelMapper();
    }
}
