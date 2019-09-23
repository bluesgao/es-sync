package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

/**
 * jdbc 配置
 */
@Getter
@Setter
public class JdbcConfig {
    private String jdbcUrl;
    private String userName;
    private String passWord;
    private String driverClassName;
    private String tableName;
}
