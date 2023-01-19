package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.controller;

import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto.ContactDto;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto.ContactListResponseDto;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model.Contact;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api")
public class ContactListController {

    private final ModelMapper modelMapper;
    private final ContactService contactService;

    public ContactListController(ModelMapper modelMapper, ContactService contactService) {
        this.modelMapper = modelMapper;
        this.contactService = contactService;
    }

    @GetMapping(value = "/getAllContacts", produces = "application/json")
    public ResponseEntity<ContactListResponseDto> getAllContacts(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    )  {
        Pageable pageable = PageRequest.of(page, size);
        List<Contact> contactList = contactService.getAll(pageable);

        Long totalContacts = contactService.getCount();
        ContactListResponseDto contactListResponseDto = mapToContactListResponseDto(page, size, contactList, totalContacts);
        return ResponseEntity.ok().body(contactListResponseDto);
    }

    @GetMapping(value = "/find", produces = "application/json")
    public ResponseEntity<ContactListResponseDto> find(
            @RequestParam(required = false, defaultValue = "name") String searchField,
            @RequestParam(required = false, defaultValue = "") String searchValue,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam() Integer size
    )  {
        Pageable pageable = PageRequest.of(page, size);
        List<Contact> contactList = contactService.findAllByName(searchValue, pageable);

        Long totalContacts = Long.valueOf(size);
        ContactListResponseDto contactListResponseDto = mapToContactListResponseDto(page, size, contactList, totalContacts);
        return ResponseEntity.ok().body(contactListResponseDto);
    }

    @GetMapping(value = "/findNameContaining", produces = "application/json")
    public ResponseEntity<ContactListResponseDto> find(
            @RequestParam(required = false, defaultValue = "0") String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam() Integer size
    )  {
        Pageable pageable = PageRequest.of(page, size);
        List<Contact> contactList = contactService.findByNameContaining(name, pageable);

        Long totalContacts = contactService.getCount();
        ContactListResponseDto contactListResponseDto = mapToContactListResponseDto(page, size, contactList, totalContacts);
        return ResponseEntity.ok().body(contactListResponseDto);
    }

    private ContactListResponseDto mapToContactListResponseDto(Integer page, Integer size, List<Contact> contactList, Long totalContacts) {
        List<ContactDto> contactDtoList = mapContactEntitiesToDto(contactList, modelMapper);
        ContactListResponseDto contactListResponseDto = ContactListResponseDto.builder()
                .contactDtoList(contactDtoList)
                .totalContacts(totalContacts)
                .currentPage(page)
                .totalPages(totalContacts/ size)
                .build();
        return contactListResponseDto;
    }

    private static List<ContactDto> mapContactEntitiesToDto(List<Contact> contactList, ModelMapper modelMapper) {
        List<ContactDto> contactDtoList = contactList.parallelStream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
        return contactDtoList;
    }
}
