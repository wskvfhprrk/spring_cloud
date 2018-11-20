package com.hejz.util;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author 何建哲
 * @date 2018/11/20 11:12
 */
@Data
public class Page implements Serializable {
    /**
     * 页码
     */
    private Integer page = 0;
    /**
     * 每页行数
     */
    private Integer size = 10;
}
