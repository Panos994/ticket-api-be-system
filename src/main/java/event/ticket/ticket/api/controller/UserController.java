package event.ticket.ticket.api.controller;

import event.ticket.ticket.api.dto.CreateUserRequestDTO;
import event.ticket.ticket.api.dto.CreateUserResponseDTO;
import event.ticket.ticket.api.entity.Role;
import event.ticket.ticket.api.entity.User;
import event.ticket.ticket.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserRequestDTO));
    }

    @GetMapping
    public ResponseEntity<CreateUserResponseDTO> getByEmail(@RequestParam String email){
        return ResponseEntity.status(HttpStatus.OK).body(mapToResponse(userService.getUserEmail(email)));
    }

    @PatchMapping
    public ResponseEntity<Void> assignRole(@RequestParam Role newRole, @RequestParam UUID userId){
          userService.assignRole(newRole, userId);
          return ResponseEntity.ok().build();
    }




    public CreateUserResponseDTO mapToResponse(User user){
        return CreateUserResponseDTO.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
    
}
