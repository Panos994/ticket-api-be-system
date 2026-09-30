package event.ticket.ticket.api.service;


import event.ticket.ticket.api.dto.CreateUserRequestDTO;
import event.ticket.ticket.api.dto.CreateUserResponseDTO;
import event.ticket.ticket.api.entity.Role;
import event.ticket.ticket.api.entity.User;
import event.ticket.ticket.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public CreateUserResponseDTO createUser(CreateUserRequestDTO dto){
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("User exist with this email");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
        return CreateUserResponseDTO.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
    public User getUserEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
    @Transactional
    public void assignRole(Role newRole, UUID userId){
        User user = userRepository.findById(userId).orElse(null);
        user.setRole(newRole);
    }


}
