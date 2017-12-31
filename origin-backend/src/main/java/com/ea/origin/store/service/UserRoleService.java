package com.ea.origin.store.service;

import com.ea.origin.store.common.Utils;
import com.ea.origin.store.common.Constant;
import com.ea.origin.store.common.PathConstant;
import com.ea.origin.store.dao.UserRoleDAO;
import com.ea.origin.store.dto.UserRoleDto;
import com.ea.origin.store.exception.ExceptionCode;
import com.ea.origin.store.exception.ExceptionMessage;
import com.ea.origin.store.exception.ExecuteRuntimeException;

import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements UserRoleDAO {

    private JdbcTemplate jdbcTemplate;

    private Logger logger = LogManager.getLogger(this.getClass());

    private String command;

    public UserRoleService (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void addUserRole(UserRoleDto userRoleDto) throws ExecuteRuntimeException {
        logger.info("Start addUserRole() method.");
		try {
            command = Utils.getElement(PathConstant.USER_ROLE_SQL_FILE, Constant.INSERT_USER_ROLE);
            logger.debug(command);
            this.jdbcTemplate.update(command, UUID.randomUUID().toString(), userRoleDto.getRole(), userRoleDto.getDescription());
        } catch(Exception e) {
            logger.error(e);
            throw new ExecuteRuntimeException(ExceptionCode.UNEXPECTED_EXCEPTION, ExceptionMessage.UNEXPECTED_EXCEPTION_MESSAGE, e);
        }
	}
}