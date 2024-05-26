package hu.dev.hrm.controller;

import hu.dev.hrm.model.User;
import hu.dev.hrm.service.UserService;
import hu.dev.hrm.type.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
}
