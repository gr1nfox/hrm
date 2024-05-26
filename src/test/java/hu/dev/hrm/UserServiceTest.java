package hu.dev.hrm;

import hu.dev.hrm.model.User;
import hu.dev.hrm.repository.UserRepository;
import hu.dev.hrm.service.UserService;
import hu.dev.hrm.type.Children;
import hu.dev.hrm.type.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@Slf4j
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void saveUser_thenReturnNewUser() {
        // Arrange
        UserDto userDto = new UserDto("testuser", "test@test.hu", "test123", new Children());
        User newUser = new User(userDto.username(), userDto.email(), userDto.password(), userDto.children());
        when(userRepository.save(newUser)).thenReturn(newUser);

        // Act
        User savedUser = userService.save(userDto);

        // Assert
        assertThat(savedUser).isEqualTo(newUser);
        log.info("successful test for saving user");
    }
}
