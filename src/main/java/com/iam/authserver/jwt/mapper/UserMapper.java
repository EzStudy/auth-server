package com.iam.authserver.jwt.mapper;

import com.iam.authserver.jwt.dto.UserDto;
import com.iam.authserver.jwt.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User>{

}
