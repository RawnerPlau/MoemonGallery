package com.moemon.user.mapper;

import com.moemon.user.dto.UserDTO;
import com.moemon.user.model.User;

public class UserMapper {
    public static UserDTO toDTO (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setDescription(user.getDescription());
        userDTO.setLinks(LinkMapper.toDTOs(user.getLinks()));
        return userDTO;
    }
}
