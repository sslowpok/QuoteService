package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping
	public List<UserEntity> getUsersList() {
		return userService.getUsers();
	}

	@PostMapping
	public StatusResponseDto addUser(@RequestBody UserEntity userEntity) {
		return userService.addOrUpdateUser(userEntity);
	}

}
