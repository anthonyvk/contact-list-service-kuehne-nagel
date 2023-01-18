package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactDto {
    private Long id;
    private String name;
    private String profilePictureURI;
}
