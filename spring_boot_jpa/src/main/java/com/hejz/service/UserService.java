package com.hejz.service;

import com.hejz.dto.UserDto;
import com.hejz.dto.UserPageDto;
import com.hejz.dto.UserSearchDto;
import com.hejz.util.RestCode;

/**
 * @author 何建哲
 * @date 2018/11/20 10:22
 */
public interface UserService {
    /**
     * 添加
     * @param userDto
     * @return
     */
    RestCode saveUser(UserDto userDto);

    RestCode updateUser(UserDto userDto);

    RestCode deleteUserById(Long id);

    RestCode findUserPage(UserPageDto userPageDto);
}
