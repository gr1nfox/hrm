package hu.dev.hrm.service;

import hu.dev.hrm.model.User;
import hu.dev.hrm.repository.UserRepository;
import hu.dev.hrm.type.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(UserDto userDto) {
        return userRepository.save(new User(userDto.username(), userDto.email(), userDto.password(), userDto.children()));
    }
}
