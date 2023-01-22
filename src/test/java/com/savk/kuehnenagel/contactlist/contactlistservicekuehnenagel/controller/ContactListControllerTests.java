package com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.savk.kuehnenagel.contactlist.contactlistservicekuehnenagel.dto.ContactListResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("h2")
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-h2.properties")
public class ContactListControllerTests {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testGetAllContactsHavingDefaultCountAsTen() throws Exception   {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/getAllContacts"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$.*", hasSize(greaterThan(0))))
				.andReturn();
		String contactListResponseDtoAsString = mvcResult.getResponse().getContentAsString();
		ContactListResponseDto contactListResponseDto = objectMapper.readValue(contactListResponseDtoAsString, ContactListResponseDto.class);
		Assertions.assertEquals(10, contactListResponseDto.getContactDtoList().size());
	}

	@Test
	void testGetAllContactsPagination() throws Exception   {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/getAllContacts")
						.param("page", "2")
						.param("size", "50")
				)
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$.*", hasSize(greaterThan(0))))
				.andReturn();
		String contactListResponseDtoAsString = mvcResult.getResponse().getContentAsString();
		ContactListResponseDto contactListResponseDto = objectMapper.readValue(contactListResponseDtoAsString, ContactListResponseDto.class);
		Assertions.assertEquals(50, contactListResponseDto.getContactDtoList().size());
	}

	@Test
	void testFindByName() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/find")
						.param("searchValue", "Happy Little Elves")
						.param("page", "0")
						.param("size", "10")
				)
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andReturn();

		String contactListResponseDtoAsString = mvcResult.getResponse().getContentAsString();
		ContactListResponseDto contactListResponseDto = objectMapper.readValue(contactListResponseDtoAsString, ContactListResponseDto.class);
		Assertions.assertNotEquals(0, contactListResponseDto.getContactDtoList().size());
	}

	@Test
	void testfindNameContaining() throws Exception   {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/findNameContaining")
						.param("name", "Happy")
						.param("page", "0")
						.param("size", "10")
				)
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andReturn();

		String contactListResponseDtoAsString = mvcResult.getResponse().getContentAsString();
		ContactListResponseDto contactListResponseDto = objectMapper.readValue(contactListResponseDtoAsString, ContactListResponseDto.class);
		Assertions.assertNotEquals(0, contactListResponseDto.getContactDtoList().size());
	}

	@Test
	void testfindNameContainingRandomNotExisting() throws Exception   {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/findNameContaining")
						.param("name", "SAVK")
						.param("page", "0")
						.param("size", "10")
				)
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andReturn();

		String contactListResponseDtoAsString = mvcResult.getResponse().getContentAsString();
		ContactListResponseDto contactListResponseDto = objectMapper.readValue(contactListResponseDtoAsString, ContactListResponseDto.class);
		Assertions.assertEquals(0, contactListResponseDto.getContactDtoList().size());
	}
}
