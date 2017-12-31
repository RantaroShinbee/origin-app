package com.ea.origin.store.mapping;

import com.ea.origin.store.dto.UserRoleDto;
import com.ea.origin.store.request.UserRoleRequest;

public class UserRoleMapping {

    /* controller mapping */
    public static UserRoleDto setResponseToDto(UserRoleRequest request) {
        UserRoleDto dto = new UserRoleDto();
        dto.setRole(request.getRole());
        dto.setDescription(request.getDescription());
        return dto;
    }
}