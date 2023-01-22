package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
