package com.bluesgao.essync.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * datasource 工具类
 * 1，get client
 * 2，bulk save
 * 3，scroll query
 * 4，index is exist
 */
public class EsUtils {
    public static RestHighLevelClient getClient(String[] ips) {
        //根据es集群的多个节点地址，获取客户端
        //String[] ips = {"192.168.85.133:9200", "192.168.85.133:9400"};
        HttpHost[] httpHosts = new HttpHost[ips.length];
        for (int i = 0; i < ips.length; i++) {
            httpHosts[i] = HttpHost.create(ips[i]);
        }
        RestClientBuilder builder = RestClient.builder(httpHosts);
        RestHighLevelClient restClient = new RestHighLevelClient(builder);
        return restClient;
    }

    public static boolean indexIsExists(RestHighLevelClient restClient, String indexName) {
        return false;
    }

    public static long bulkSave() {
        return 0;
    }


}
