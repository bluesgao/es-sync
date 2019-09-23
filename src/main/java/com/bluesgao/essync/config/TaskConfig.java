package com.bluesgao.essync.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 任务配置
 */
@Getter
@Setter
public class TaskConfig {
    private String taskName;//任务名称
    private boolean isParallel;//并行
    private String splitField;//分割字段
    private int subTaskCount;//子任务数量
}
