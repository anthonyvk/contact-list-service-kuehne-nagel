package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.service.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("h2")
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-h2.properties")
class ContactListServiceKuehneNagelApplicationTests {

    @Autowired
    private ContactService contactService;

    @Test
    void checkWhetherDataIsPersisted () {
        long count = contactService.getCount();
        Assertions.assertNotEquals(0, count);
    }
}
