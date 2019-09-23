package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

/**
 * elasticsearch 配置
 */
@Getter
@Setter
public class EsConfig {
    private String clusterName;//es集群名称
    private String address;//es cluster ip地址
    private String user;//es用户名称
    private String passWord;//es密码
}
