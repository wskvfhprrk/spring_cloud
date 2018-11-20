package com.hejz.dto;

import com.hejz.util.Page;
import lombok.Data;


/**
 * @author 何建哲
 * @date 2018/11/20 11:11
 */
@Data
public class UserPageDto extends Page {
    private String username;
    private String name;
}
