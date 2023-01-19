package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.config;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model.Contact;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.service.ContactService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@Slf4j
public class InitializeDatabaseFromCSV {

    @Value("classpath:people.csv")
    private Resource resourceFile;

    private final ContactService contactService;

    public InitializeDatabaseFromCSV(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void initialize() throws IOException {
        if(contactService.getCount() == 0) {
            InputStream csvFileStream = resourceFile.getInputStream();

            try (csvFileStream; BufferedReader reader = new BufferedReader(new InputStreamReader(csvFileStream))) {
                String line = reader.readLine();
                line = reader.readLine();

                while (line != null) {
                    String[] data = line.split(",");
                    String name = data[0];
                    String uri = data[1];
                    log.debug("Name = " + name + " , URI = " + uri);

                    Contact contact = Contact.builder().name(name).profilePictureURI(uri).build();
                    log.debug("Persisted in Database : " + contactService.save(contact));

                    line = reader.readLine();
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }
    }
}
