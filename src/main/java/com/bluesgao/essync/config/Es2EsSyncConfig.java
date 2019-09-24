package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Es2EsSyncConfig {
    private String desc;//描述信息
    private EsConfig fromEsConfig;
    private EsConfig toEsConfig;
    private MappingConfig mappingConfig;
    private TaskConfig taskConfig;
}
