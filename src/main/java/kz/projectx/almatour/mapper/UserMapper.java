package kz.projectx.almatour.mapper;

import kz.projectx.almatour.dto.UserDTO;
import kz.projectx.almatour.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "userPassword", source = "user.password")
    @Mapping(target = "userFullName", source = "user.fullName")
    @Mapping(target = "userRePassword", source = "user.rePassword")
    UserDTO toDto(User user);

    @Mapping(target = "email", source = "userDto.userEmail")
    @Mapping(target = "password", source = "userDto.userPassword")
    @Mapping(target = "fullName", source = "userDto.userFullName")
    @Mapping(target = "rePassword", source = "userDto.userRePassword")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toEntity(UserDTO userDto);
}
