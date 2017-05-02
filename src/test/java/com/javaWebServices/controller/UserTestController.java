package com.javaWebServices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.javaWebServices.repository.UserRepository;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserController.class })
@WebAppConfiguration
public class UserTestController {
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepositoryMock;

	@Test
	public void findById_TodoEntryNotFound_ShouldReturnHttpStatusCode404() throws Exception {
		when(userRepositoryMock.findOne(1L));

		mockMvc.perform(get("/api/users/{id}", 1L)).andExpect(status().isNotFound());

		verify(userRepositoryMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(userRepositoryMock);
	}
}
