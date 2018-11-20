package com.hejz.service;

import com.hejz.dto.UserDto;
import com.hejz.dto.RoleDto;
import com.hejz.entity.User;
import com.hejz.util.RestCode;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:59
 */
public interface LoginService {
    RestCode addUser(UserDto userDto) throws Exception;
    RestCode addRole(RoleDto roleDto) throws Exception;
    User findByUserame(String username);
}
