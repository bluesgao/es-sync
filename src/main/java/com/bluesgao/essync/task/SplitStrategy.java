package com.bluesgao.essync.task;


import com.bluesgao.essync.common.DateUtils;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SplitStrategy {
    Map<String, Map<String, String>> splitByEveryDate(Date startDate, Date endDate, String dateField) {
        int between = 0;
        try {
            between = DateUtils.dateBetween(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>();

        for (int i = 0; i <= between; i++) {
            Date tempDate = DateUtils.dateAddDays(startDate, i);
            String dateKey = null;
            try {
                dateKey = DateUtils.dateFormat(tempDate, DateUtils.DATE_PATTERN);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (dateKey != null) {
                Map<String, String> dateRangeMap = new HashMap<String, String>();
                dateRangeMap.put("start", dateKey + DateUtils.DAY_BEGIN_TIME);
                dateRangeMap.put("end", dateKey + DateUtils.DAY_END_TIME);
                dateRangeMap.put("dateField", dateField);
                resultMap.put(dateKey, dateRangeMap);
            }
        }
        return resultMap;
    }
}
