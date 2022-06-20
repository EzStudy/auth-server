package com.iam.authserver.jwt.controller;

import com.iam.authserver.jwt.dto.UserDto;
import com.iam.authserver.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public UserDto register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

}
