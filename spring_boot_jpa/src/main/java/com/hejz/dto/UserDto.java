package com.hejz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 15:29
 */
@Data
public class UserDto {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}
