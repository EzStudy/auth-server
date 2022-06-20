package com.iam.authserver.jwt.service;

import com.iam.authserver.jwt.dto.UserDto;

public interface UserService {

    UserDto register(UserDto userDto);
}
