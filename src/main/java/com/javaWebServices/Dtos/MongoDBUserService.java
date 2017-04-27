package com.javaWebServices.Dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;
import com.javaWebServices.services.UserService;

@Service
final class MongoDBUserService implements UserService{

	 private UserRepository repository;
	 
    @Autowired
    MongoDBUserService(UserRepository repository) {
        this.repository = repository;
    }
	@Override
	public UserDto create(UserDto userDto) {
		User user = convertDTOToUser(userDto);
		User persisted = repository.save(user);
		return convertToDTO(persisted);
	}

	@Override
	public UserDto delete(String id) {
		User deleted = findUserById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
	}

	@Override
	public List<UserDto> findAll() {
		List<User> userEntries = repository.findAll();
        return convertToDTOs(userEntries);
	}

	@Override
	public UserDto findById(String id) {
		User found = findUserById(id);
        return convertToDTO(found);
	}

	@Override
	public UserDto update(UserDto user) {
		User updated = findUserById(user.getId());
		updated.setName(user.getName());
		updated.setLastName(user.getLastName());
	    updated = repository.save(updated);
	    
	    return convertToDTO(updated);
	}
	
	private List<UserDto> convertToDTOs(List<User> models) {
		List<UserDto> list = new ArrayList<UserDto>();
		for (User userDto : models) {
			list.add(convertToDTO(userDto));
		}
		return list;
    }

	private UserDto convertToDTO(User model) {
		UserDto dto = new UserDto();
	    dto.setName(model.getName());
		dto.setLastName(model.getLastName());
		dto.setEmail(model.getEmail());
		dto.setAge(model.getAge());
		dto.setPassword(model.getPassword());
		
		return dto;
	}
	
	private User findUserById(String id) {
        User result = repository.findOne(id);
        return result;
    }
	
	private User convertDTOToUser(UserDto dto) {
		User user = new User();
		user.setName(dto.getName());
	    user.setLastName(dto.getLastName());
	    user.setEmail(dto.getEmail());
	    user.setAge(dto.getAge());
	    user.setPassword(dto.getPassword());
		
		return user;
	}
}
