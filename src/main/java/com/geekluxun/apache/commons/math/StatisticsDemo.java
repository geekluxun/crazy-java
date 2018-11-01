package com.geekluxun.apache.commons.math;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.FastMath;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-19 11:12
 * @Description: 统计相关
 * @Other:
 */
public class StatisticsDemo {
    public static void main(String[] argc) {
        StatisticsDemo demo = new StatisticsDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1() {
        double inputArray[] = new double[]{1, 2, 3, 4, 5};
        // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();
        // Add the data from the array
        for (int i = 0; i < inputArray.length; i++) {
            stats.addValue(inputArray[i]);
        }
        // Compute some statistics
        double mean = stats.getMean();
        // 标准差
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        System.out.println();
    }

    public void demo2() {
        // Compute statistics directly from the array
        // assume values is a double[] array
        double values[] = new double[]{1, 2, 3, 4, 5};
        double mean = StatUtils.mean(values);
        double std = FastMath.sqrt(StatUtils.variance(values));
        double median = StatUtils.percentile(values, 50);
        // Compute the mean of the first three values in the array
        mean = StatUtils.mean(values, 0, 3);
    }
}
