package com.javaWebServices.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserTestController {

	@InjectMocks
	private UserController mockedUserController;
    
	@Mock
    private UserRepository mockedUserRepository;
    
	private static User user1;
	private static User user2;

	@BeforeClass
	public static void setUp() throws Exception {
		user1 = Mockito.mock(User.class);
		user2 = Mockito.mock(User.class);
		
	}

	@Test
	public void testCreateUser() throws Exception {
		User userResult = Mockito.mock(User.class);
		userResult.setId((long)1L);
		userResult.setName("TestName");
		userResult.setSurname("TestSurname");
		Mockito.when(mockedUserController.create(user1)).thenReturn(userResult);
		User userTest = mockedUserRepository.findOne(userResult.getId());
		Assert.assertEquals(userTest, user1);

	}
	
	@Test
	public void testDeleteUser() throws Exception {
		User userResult = Mockito.mock(User.class);
		userResult.setId((long)1L);
		userResult.setName("TestName");
		userResult.setSurname("TestSurname");
		Mockito.when(mockedUserController.update(user1)).thenReturn(userResult);
		User userTest = mockedUserRepository.findOne(userResult.getId());
		Assert.assertEquals(userTest, user1);

	}
}
