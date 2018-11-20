package com.hejz.controller;

import com.hejz.dto.UserDto;
import com.hejz.dto.UserPageDto;
import com.hejz.service.UserService;
import com.hejz.util.RestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 何建哲
 * @date 2018/11/20 11:20
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加
     * @param userDto
     * @return
     */
    @PostMapping
    public RestCode save(@Valid @RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    /**
     * 修改
     * @param userDto
     * @return
     */
    @PutMapping
    public RestCode update(@Valid @RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public RestCode delete(@PathVariable Long id){
        return userService.deleteUserById(id);
    }

    /**
     * 条件分页查询
     * @param userPageDto
     * @return
     */
    @GetMapping("page")
    public RestCode page(UserPageDto userPageDto){
        return userService.findUserPage(userPageDto);
    }
}
