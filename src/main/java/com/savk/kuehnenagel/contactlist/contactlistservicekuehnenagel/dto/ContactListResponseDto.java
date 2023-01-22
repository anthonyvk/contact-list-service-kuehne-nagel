package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
