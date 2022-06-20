package com.iam.authserver.jwt.service.impl;

import com.iam.authserver.jwt.dto.UserDto;
import com.iam.authserver.jwt.entity.User;
import com.iam.authserver.jwt.mapper.UserMapper;
import com.iam.authserver.jwt.repository.UserRepository;
import com.iam.authserver.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto register(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
