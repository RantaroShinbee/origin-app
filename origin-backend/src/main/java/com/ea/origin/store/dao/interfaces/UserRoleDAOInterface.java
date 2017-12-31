package com.ea.origin.store.dao.interfaces;

import com.ea.origin.store.dto.UserRoleDto;
import com.ea.origin.store.exception.ExecuteRuntimeException;

public interface UserRoleDAOInterface {

    public void addUserRole(UserRoleDto userRoleDto) throws ExecuteRuntimeException;

}