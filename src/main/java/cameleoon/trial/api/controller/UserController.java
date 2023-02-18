package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.UserDetailsResponseDto;
import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserServiceImpl userService;

	@GetMapping
	public List<UserEntity> getUsersList() {
		return userService.getUsers();
	}

	@PostMapping
	public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.addUser(userRequestDto);
	}

	@GetMapping("/{id}")
	public UserDetailsResponseDto getUserDetails(@PathVariable Long id) {
		return userService.getUserById(id);
	}

}
