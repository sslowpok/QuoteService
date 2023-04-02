package quotes.app.api.controller;

import quotes.app.api.dto.UserDetailsResponseDto;
import quotes.app.api.dto.UserRequestDto;
import quotes.app.api.dto.UserResponseDto;
import quotes.app.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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
