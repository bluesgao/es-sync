package com.bluesgao.essync.config;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * config 解析
 * 1,parse 将json字符串解析为syncConfig对象
 */
public class ConfigParse {
    public static List<SyncConfig> parse(String cfgStr) {
        List<SyncConfig> syncConfigs = null;
        try {
            syncConfigs = JSON.parseArray(cfgStr, SyncConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return syncConfigs;
    }
}
