package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * field mapping 配置
 */
@Getter
@Setter
public class MappingConfig {
    //jdbc column->es doc field
    private HashMap<String, String> fieldMappingMap;
}
