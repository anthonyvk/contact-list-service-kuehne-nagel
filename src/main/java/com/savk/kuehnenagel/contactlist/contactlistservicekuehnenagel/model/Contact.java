package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "contact")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Contact {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String profilePictureURI;
}
