package com.bluesgao.essync.common;

/**
 * 同步类型
 */
public enum SyncTypeEnum {
    ES_2_ES(1,"ES2ES"),
    JDBC_2_ES(2,"JDBC2ES");

    private Integer type;
    private String msg;

    SyncTypeEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
