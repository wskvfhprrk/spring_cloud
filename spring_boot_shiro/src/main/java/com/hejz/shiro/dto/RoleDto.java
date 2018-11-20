package com.hejz.shiro.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 15:57
 */
@Data
public class RoleDto {
    @NotNull
    private Long userId;
    @NotBlank
    private String roleName;
}
