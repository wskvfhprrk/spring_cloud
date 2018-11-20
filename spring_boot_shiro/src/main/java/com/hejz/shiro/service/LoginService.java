package com.hejz.shiro.service;

import com.hejz.shiro.dto.RoleDto;
import com.hejz.shiro.dto.UserDto;
import com.hejz.shiro.entity.User;
import com.hejz.shiro.util.RestCode;

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
