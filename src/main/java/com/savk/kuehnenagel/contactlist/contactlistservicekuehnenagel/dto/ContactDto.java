package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto;

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
