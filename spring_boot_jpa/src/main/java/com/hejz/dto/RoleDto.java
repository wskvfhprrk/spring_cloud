package com.hejz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
