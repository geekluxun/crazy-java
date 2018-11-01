package com.geekluxun.guava.collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @Author: luxun
 * @Create: 2018-06-30 11:11
 * @Description:
 * @Other:
 */
public class RangeMapDemo {

    public static void main(String[] argc) {
        RangeMapDemo demo = new RangeMapDemo();
        demo.demo1();
        demo.demo2();
    }

    /**
     * 某一个范围(Range)映射一个职位
     */
    public void demo1() {
        RangeMap<Integer, String> experienceRangeDesignationMap = TreeRangeMap.create();

        experienceRangeDesignationMap.put(Range.closed(0, 2), "Associate");
        experienceRangeDesignationMap.put(Range.closed(3, 5), "Senior Associate");
        experienceRangeDesignationMap.put(Range.closed(6, 8), "Vice President");
        experienceRangeDesignationMap.put(Range.closed(9, 15), "Executive Director");

        Assert.isTrue("Vice President".equals(experienceRangeDesignationMap.get(6)));
        Assert.isTrue("Executive Director".equals(experienceRangeDesignationMap.get(15)));
    }


    /**
     * 获取某一个元素
     */
    private void demo2() {
        RangeMap<Integer, String> experienceRangeDesignationMap = TreeRangeMap.create();

        experienceRangeDesignationMap.put(Range.closed(0, 2), "Associate");
        experienceRangeDesignationMap.put(Range.closed(3, 5), "Senior Associate");
        experienceRangeDesignationMap.put(Range.closed(6, 8), "Vice President");
        experienceRangeDesignationMap.put(Range.closed(9, 15), "Executive Director");

        Map.Entry<Range<Integer>, String> experienceEntry = experienceRangeDesignationMap.getEntry(10);

        Assert.isTrue(Range.closed(9, 15).equals(experienceEntry.getKey()));
        Assert.isTrue("Executive Director".equals(experienceEntry.getValue()));

    }

}
