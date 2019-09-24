package com.bluesgao.essync.datasync;

import com.alibaba.fastjson.JSON;
import com.bluesgao.essync.common.Result;
import com.bluesgao.essync.config.Jdbc2EsConfig;
import com.bluesgao.essync.datasource.EsOperationService;
import com.bluesgao.essync.task.SplitStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSyncServiceImpl implements DataSyncService {

    SplitStrategy splitStrategy;

    private EsOperationService esOperationService;

    public Result jdbc2es(Jdbc2EsConfig cfg) {
        log.info("jdbc2es cfg:{}", JSON.toJSONString(cfg));

//        Result checkResult = check(jdbc2es);
//        log.info("es2es checkResult:{}", JSON.toJSONString(checkResult));
//        if (checkResult != null) {
//            return checkResult;
//        }
//
//        //按日期分割
//        Date start = null;
//        Date end = null;
//        try {
//            start = DateUtils.dateParse(cfg.getDateRangeDto().getStart(), DateUtils.DATE_PATTERN);
//            end = DateUtils.dateParse(dataSyncConfigDto.getDateRangeDto().getEnd(), DateUtils.DATE_PATTERN);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String dateField = dataSyncConfigDto.getDateRangeDto().getDateField();
//        Map<String, DateRangeDto> splitDateMap = splitStrategy.splitByEveryDate(start, end, dateField);
//        log.info("es2es splitDateMap.size:{},splitDateMap:{}", splitDateMap.size(), JSON.toJSONString(splitDateMap));
//
//        //结果集
//        List<Result<Integer>> resultList = new ArrayList<Result<Integer>>();
//
//        if (splitDateMap != null && splitDateMap.size() > 0) {
//
//            //1.定义CompletionService
//            CompletionService<Result<Integer>> completionService = new ExecutorCompletionService(taskExecutor);
//
//            //key cf-sync-worker:jes:cf-content-5
//            String redisKey = OtherUtils.genRedisKey(dataSyncConfigDto.getTo().getCluster(), dataSyncConfigDto.getTo().getIdx());
//            //2,向线程池提交任务
//            int taskCount = 0;
//            for (String key : splitDateMap.keySet()) {
//
//                //去除已经同步过的日期
//                String ret = r2mClusterClient.hget(redisKey, key);
//                log.info("redis hget redisKey:{},field:{},ret:{}", redisKey, key, ret);
//                if (ret != null && Integer.valueOf(ret) > 0) {
//                    log.info("当前日期{}已经同步,跳过 redis hget redisKey:{},field:{},ret:{}", key, redisKey, key, ret);
//                    continue;
//                }
//                dataSyncConfigDto.setDateRangeDto(splitDateMap.get(key));
//                Es2EsJob es2EsJob = new Es2EsJob(esOperationService, r2mClusterClient, dataSyncConfigDto);
//                completionService.submit(es2EsJob);
//                taskCount++;
//            }
//
//            //3.获取线程执行结果，使用内部阻塞队列的take()
//            for (int i = 0; i < taskCount; i++) {
//                //采用completionService.take()，内部维护阻塞队列，任务先完成的先获取到
//                Result<Integer> result = null;
//                try {
//                    //todo timeout 有堵塞风险 线程执行时间与数据量大小正相关，不好评估
//                    result = completionService.take().get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//                log.info("es2es call result:{}", JSON.toJSONString(result));
//                resultList.add(result);
//            }
//            log.info("es2es call all result:{}", JSON.toJSONString(resultList));
//        }
//        return Result.getResult(ResultCodeEnum.SUCCESS.getCode(), "es2es success " + JSON.toJSONString(resultList));
        return null;
    }

    public Result check(Jdbc2EsConfig config) {
//        //0，获取client
//        Client readClient = esOperationService.getEsClient(esDataSyncConfigDto.getFrom().getCluster());
//        String readIdx = esDataSyncConfigDto.getFrom().getIdx();
//        Client writeClient = esOperationService.getEsClient(esDataSyncConfigDto.getTo().getCluster());
//        String writeIdx = esDataSyncConfigDto.getTo().getIdx();
//        String writeIdKey = esDataSyncConfigDto.getTo().getIdKey();
//        //form
//        if (readClient == null || StringUtils.isEmpty(readIdx)) {
//            log.error("es2es error readClient or readIdx is null:{}", JSON.toJSONString(esDataSyncConfigDto));
//            return Result.getResult(ResultCodeEnum.PARAM_ERROR.getCode(), "serialDataSync error readClient or readIdx is null " + JSON.toJSONString(esDataSyncConfigDto));
//        }
//
//        //to
//        if (writeClient == null || StringUtils.isEmpty(writeIdx) || StringUtils.isEmpty(writeIdKey)) {
//            log.error("es2es error writeClient or writeIdx or writeIdKey is null:{}", JSON.toJSONString(esDataSyncConfigDto));
//            return Result.getResult(ResultCodeEnum.PARAM_ERROR.getCode(), "serialDataSync error writeClient or writeIdx or writeIdKey is null " + JSON.toJSONString(esDataSyncConfigDto));
//        }
//
//        if (!esOperationService.indexIsExist(readClient, readIdx)) {
//            log.error("es2es error readClient readIdx is not exist:{}", JSON.toJSONString(esDataSyncConfigDto.getFrom()));
//            return Result.getResult(ResultCodeEnum.PARAM_ERROR.getCode(), "serialDataSync error readClient readIdx is not exist " + JSON.toJSONString(esDataSyncConfigDto.getFrom()));
//        }
//
//        if (!esOperationService.indexIsExist(writeClient, writeIdx)) {
//            log.error("es2es error writeClient writeIdx or writeIdKey is not exist:{}", JSON.toJSONString(esDataSyncConfigDto.getTo()));
//            return Result.getResult(ResultCodeEnum.PARAM_ERROR.getCode(), "serialDataSync error writeClient writeIdx or writeIdKey is not exist " + JSON.toJSONString(esDataSyncConfigDto.getTo()));
//        }
        return null;
    }
}
