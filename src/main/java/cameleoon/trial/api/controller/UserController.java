package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.UserDetailsResponseDto;
import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserServiceImpl userService;

	@GetMapping
	@Operation(summary = "Get list of users")
	public List<UserResponseDto> getUsersList() {
		return userService.getUsers();
	}

	@PostMapping
	@Operation(summary = "Add new user")
	public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.addUser(userRequestDto);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get user details by id")
	public UserDetailsResponseDto getUserDetails(@PathVariable Long id) {
		return userService.getUserById(id);
	}

}
