package com.ea.origin.store.controller;


import com.ea.origin.store.common.Constant;
import com.ea.origin.store.common.PathConstant;
import com.ea.origin.store.dto.UserRoleDto;
import com.ea.origin.store.service.UserRoleService;
import com.ea.origin.store.request.UserRoleRequest;
import com.ea.origin.store.response.UserRoleResponse;
import com.ea.origin.store.exception.ExceptionCode;
import com.ea.origin.store.exception.ExceptionMessage;
import com.ea.origin.store.exception.InvalidParameterException;
import com.ea.origin.store.exception.ExecuteRuntimeException;
import com.ea.origin.store.mapping.UserRoleMapping;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @PostMapping(value = PathConstant.USER_ROLE_POST)
    public ResponseEntity<UserRoleResponse> add(@RequestBody UserRoleRequest request) throws ExecuteRuntimeException, InvalidParameterException {
        logger.info("Start add() method.");
        if(request.getRole().equals(null)) {
            throw new InvalidParameterException(ExceptionCode.INVALID_REQUEST_PARAM, ExceptionMessage.ROLE_INVALID_MESSAGE);
        }
        UserRoleDto roleDto = UserRoleMapping.setResponseToDto(request);
        userRoleService.addUserRole(roleDto);
        UserRoleResponse response = new UserRoleResponse();
        response.setCode(Constant.UPDATE_SUCCESS_CODE);
        response.setMessage(Constant.ADDING_USER_ROLE_SUCCESS_MESSAGE);
        return new ResponseEntity<UserRoleResponse>(response, HttpStatus.OK);
    }
}