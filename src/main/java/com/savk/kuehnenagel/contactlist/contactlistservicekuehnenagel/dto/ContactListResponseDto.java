package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ContactListResponseDto {
    @JsonProperty("contactList")
    private List<ContactDto> contactDtoList;
    private Long totalContacts;
    private Long totalPages;
    private Integer currentPage;
}
