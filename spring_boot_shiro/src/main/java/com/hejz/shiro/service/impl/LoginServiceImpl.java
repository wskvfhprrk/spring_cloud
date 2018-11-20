package com.hejz.shiro.service.impl;

import com.hejz.shiro.dto.RoleDto;
import com.hejz.shiro.dto.UserDto;
import com.hejz.shiro.entity.Permission;
import com.hejz.shiro.entity.Role;
import com.hejz.shiro.entity.User;
import com.hejz.shiro.repository.RoleRepository;
import com.hejz.shiro.repository.UserRepository;
import com.hejz.shiro.service.LoginService;
import com.hejz.shiro.util.RestCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
