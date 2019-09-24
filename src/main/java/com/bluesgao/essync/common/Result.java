package com.bluesgao.essync.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T data;
}
