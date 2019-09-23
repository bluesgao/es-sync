package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SyncConfig {
    private String desc;//描述信息
    private EsConfig esConfig;
    private JdbcConfig jdbcConfig;
    private MappingConfig mappingConfig;
    private TaskConfig taskConfig;
}
