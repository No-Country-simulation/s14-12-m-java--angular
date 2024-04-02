package com.example.app.mapper;

import com.example.app.dto.user.SignedUserDTO;
import com.example.app.dto.user.UserToSignUpDto;
import com.example.app.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserToSignUpDto userToSignUpDto);

    UserToSignUpDto userToSignUpDtoToUser(User user);

    User toEntity(SignedUserDTO signedUserDTO);

    SignedUserDTO userToSignedUserDTO(User user);
}