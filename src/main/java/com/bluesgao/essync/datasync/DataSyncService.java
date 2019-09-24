package com.bluesgao.essync.datasync;


import com.bluesgao.essync.common.Result;
import com.bluesgao.essync.config.Jdbc2EsConfig;

public interface DataSyncService {
    Result jdbc2es(Jdbc2EsConfig cfg);
}
