package com.ea.origin.store.dao;

import com.ea.origin.store.dto.UserRoleDto;
import com.ea.origin.store.exception.ExecuteRuntimeException;

public interface UserRoleDAO {

    public void addUserRole(UserRoleDto userRoleDto) throws ExecuteRuntimeException;
}