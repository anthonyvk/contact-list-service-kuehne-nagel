package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dao;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, PagingAndSortingRepository<Contact, Long> {
    Page<Contact> findAll(Pageable pageable);
    List<Contact> findAllByName(String name, Pageable pageable);
    List<Contact> findByNameContaining(String name, Pageable pageable);
}
