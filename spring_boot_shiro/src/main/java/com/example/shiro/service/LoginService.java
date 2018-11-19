package com.example.shiro.service;

import com.example.shiro.dto.RoleDto;
import com.example.shiro.dto.UserDto;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.util.RestCode;

import java.util.Map;

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
