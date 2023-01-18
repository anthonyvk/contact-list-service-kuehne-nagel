package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model.Contact;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.service.ContactService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class ContactListServiceKuehneNagelApplication {

    @Value("classpath:people.csv")
    private Resource resourceFile;

    private final ContactService contactService;

    public ContactListServiceKuehneNagelApplication(ContactService contactService) {
        this.contactService = contactService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactListServiceKuehneNagelApplication.class, args);
    }

    @PostConstruct
    public void initialize() throws IOException {
        if(contactService.getCount() == 0) {
            InputStream csvFileStream = resourceFile.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(csvFileStream));

            try {
                String line = reader.readLine();
                line = reader.readLine();

                while (line != null) {
                    String[] data = line.split(",");
                    String name = data[0];
                    String uri = data[1];
                    System.out.println("Name = " + name + " , URI = " + uri);

                    Contact contact = Contact.builder().name(name).profilePictureURI(uri).build();
                    System.out.println("Saved : " + contactService.save(contact));

                    line = reader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reader.close();
                csvFileStream.close();
            }
        }
    }
}
