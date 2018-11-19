package com.example.shiro.service.impl;

import com.example.shiro.dto.RoleDto;
import com.example.shiro.dto.UserDto;
import com.example.shiro.entity.Permission;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.repository.RoleRepository;
import com.example.shiro.repository.UserRepository;
import com.example.shiro.service.LoginService;
import com.example.shiro.util.RestCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 14:03
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //添加用户
    @Override
    public RestCode addUser(UserDto userDto) throws Exception{
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
        return RestCode.ok(user);
    }

    //添加角色
    @Override
    public RestCode addRole(RoleDto roleDto) {
        User user = userRepository.findById(roleDto.getUserId()).orElse(null);
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
         roleRepository.save(role);
        return RestCode.ok();
    }

    //查询用户通过用户名
    @Override
    public User findByUserame(String username) {
        return userRepository.findByUsername(username);
    }

}
