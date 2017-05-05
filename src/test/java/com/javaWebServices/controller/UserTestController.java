package com.javaWebServices.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserTestController {

	@Mock
	private UserRepository mockedUserRepository;

	@InjectMocks
	private UserController mockedUserController;

	@Test
	public void testCreateUser() throws Exception {
		// Expected objects
		User userInput = new User();
		userInput.setId((long) 1L);
		userInput.setName("TestName");
		userInput.setSurname("TestSurname");
		userInput.setUserName("hcampos");
		userInput.setEmailAddress("hcampos@gmai.com");
		userInput.setPhoneNumber("2512415");
		userInput.setPassword("d21ds2");

		User userResult = new User();
		userResult.setId((long) 1L);
		userResult.setName("TestName");
		userResult.setSurname("TestSurname");
		userResult.setUserName("hcampos");
		userResult.setEmailAddress("hcampos@gmai.com");
		userResult.setPhoneNumber("2512415");
		userResult.setPassword("d21ds2");

		// Mockito expectations
		Mockito.when(mockedUserRepository.save(userInput)).thenReturn(
				userResult);

		// Execute the method being tested
		User userTest = mockedUserController.create(userInput);

		// Validation
		Assert.assertNotNull(userTest);
		Assert.assertEquals(userResult.getName(), userTest.getName());

	}

	@Test
	public void testGetAllUser() throws Exception {
		// Expected objects
		User userResult = new User();
		userResult.setId((long) 1L);
		userResult.setName("TestName");
		userResult.setSurname("TestSurname");

		// Mockito expectations
		Mockito.when(mockedUserRepository.findAll()).thenReturn(
				Arrays.asList(userResult));
		// Execute the method being tested
		List<User> listUser = mockedUserController.getUsers(null);
		
		Assert.assertNotNull(Arrays.asList(listUser));

	}

	@Test
	public void testGetUser() throws Exception {
		// Expected objects
		User userInput = new User();
		userInput.setId((long) 1L);
		userInput.setName("TestName");
		userInput.setSurname("TestSurname");

		User userResult = new User();
		userResult.setId((long) 1L);
		userResult.setName("TestName");
		userResult.setSurname("TestSurname");

		// Mockito expectations
		Mockito.when(mockedUserRepository.findOne((long) 1L)).thenReturn(
				userInput);

		// Execute the method being tested
		List<User> userTest = mockedUserController.getUsers((long) 1L);

		// Validation
		Assert.assertNotNull(userTest);
		Assert.assertEquals(userResult.getId(), userTest.get(0).getId());
	}

	@Test
	public void testCreateErrorUser() throws Exception {
		// Expected objects
		User userInput = new User();
		userInput.setId((long) 1L);
		userInput.setName("TestName");
		userInput.setSurname("TestSurname");

		// Mockito expectations
		Mockito.when(mockedUserRepository.save(userInput)).thenReturn(null);

		// Execute the method being tested
		User userTest = mockedUserController.create(userInput);

		// Validation
		Assert.assertNull(userTest);
	}
}
