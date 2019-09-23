package com.bluesgao.essync.config;

import com.alibaba.fastjson.JSON;
import com.bluesgao.essync.utils.EsUtils;
import com.bluesgao.essync.utils.JdbcUtils;
import org.elasticsearch.client.RestHighLevelClient;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * config 解析
 * 1,parse 将json字符串解析为syncConfig对象
 */
public class ConfigParse {
    //jdbcUrl->dataSource
    private static Map<String, DataSource> jdbcCache = null;
    private static Map<String, RestHighLevelClient> esClientCache = null;

    static {
        jdbcCache = new ConcurrentHashMap<String, DataSource>();
        esClientCache = new ConcurrentHashMap<String, RestHighLevelClient>();


        List<SyncConfig> configs = parse("");
        for (SyncConfig cfg : configs) {
            //创建 jdbc datasource
            String jdbcUrl = cfg.getJdbcConfig().getJdbcUrl();
            DataSource dataSource = JdbcUtils.createDataSource(null);
            if (dataSource != null && !jdbcCache.containsKey(jdbcUrl)) {
                jdbcCache.put(jdbcUrl, dataSource);
            }

            //创建es client
            String esClusterName = cfg.getEsConfig().getClusterName();
            RestHighLevelClient esClient = EsUtils.getClient(null);
            if (esClient != null && !esClientCache.containsKey(esClusterName)) {
                esClientCache.put(esClusterName, esClient);
            }
        }
    }

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
