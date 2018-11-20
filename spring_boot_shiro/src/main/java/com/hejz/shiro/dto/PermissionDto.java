package com.hejz.shiro.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 15:57
 */
@Data
public class PermissionDto {
    @NonNull
    private Long roleId;
    @NotBlank
    private String permission;
}
