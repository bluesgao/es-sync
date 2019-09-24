package com.bluesgao.essync.datasource;


import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;

import java.util.List;
import java.util.Map;

public interface EsOperationService {
    void save(Client client, String targetIndex, String idKey, List<Map<String, Object>> dataList);

    List<Map<String, Object>> query(Client client, String targetIndex, BoolQueryBuilder queryBuilder);

    Client getEsClient(String clusterName);

    boolean indexIsExist(Client client, String indexName);

    int syncData(Client fromClient, String fromIndex, BoolQueryBuilder queryBuilder, Client toClient, String toIndex, String idKey);
}
