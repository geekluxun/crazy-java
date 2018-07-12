package com.geekluxun.common.dto;

import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 9:41
 * @Description:
 * @Other:
 */
@Data
public class RequestDto<T> {
    private String code;
    private String msg;
    private T data;
}
