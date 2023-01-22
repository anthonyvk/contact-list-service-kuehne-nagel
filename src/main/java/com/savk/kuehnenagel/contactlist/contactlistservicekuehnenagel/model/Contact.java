package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
