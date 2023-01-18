package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.service;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dao.ContactRepository;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAll(Pageable pageable)  {
        Page<Contact> contactPage = contactRepository.findAll(pageable);
        return contactPage.stream().collect(Collectors.toList());
    }

    public List<Contact> findAllByName(String name, Pageable pageable)   {
        return contactRepository.findAllByName(name, pageable);
    }

    public List<Contact> findByNameContaining(String name, Pageable pageable)   {
        return contactRepository.findByNameContaining(name, pageable);
    }

    public Contact save(Contact contact)    {
        return contactRepository.save(contact);
    }

    public void deleteAll() {
        contactRepository.deleteAll();
    }

    public long getCount()  {
        return contactRepository.count();
    }
}
