package com.geekluxun.guava.collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.springframework.util.Assert;

/**
 * @Author: luxun
 * @Create: 2018-06-30 10:46
 * @Description:
 * @Other:
 */
public class RangeSetDemo{
    public static void main(String[] argc){
        RangeSetDemo demo = new RangeSetDemo();
        demo.demo1();
        demo.givenRangeSet_whenSubRangeSetIsCalled_returnsSubRangeSucessfully();
        demo.givenRangeSet_whenComplementIsCalled_returnsSucessfully();
        demo.givenRangeSet_whenIntersectsWithinRange_returnsSucessfully();
    }


    private void demo1(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        // 两头闭
        rangeSet.add(Range.closed(1, 3));
        // 左闭右开
        rangeSet.add(Range.closedOpen(4, 5));
        // 左开右闭
        rangeSet.add(Range.openClosed(5, 7));

        Assert.isTrue(rangeSet.contains(3), "包含3");
        Assert.isTrue(!rangeSet.contains(5), "不含5");

        rangeSet.remove(Range.closed( 3, 5));

        Range<Integer> span = rangeSet.span();
        int min = span.lowerEndpoint().intValue();
        int max = span.upperEndpoint().intValue();

        System.out.println();
    }


    /**
     * 获取子集合
     */
    private void givenRangeSet_whenSubRangeSetIsCalled_returnsSubRangeSucessfully() {

        RangeSet<Integer> numberRangeSet = TreeRangeSet.create();

        numberRangeSet.add(Range.closed(0, 2));
        numberRangeSet.add(Range.closed(3, 5));
        numberRangeSet.add(Range.closed(6, 8));
        RangeSet<Integer> numberSubRangeSet
                = numberRangeSet.subRangeSet(Range.closed(4, 14));

        Assert.isTrue(!numberSubRangeSet.contains(3));
        Assert.isTrue(!numberSubRangeSet.contains(14));
        Assert.isTrue(numberSubRangeSet.contains(7));
    }


    /**
     * 获取在此范围外所有区间
     */
    private void givenRangeSet_whenComplementIsCalled_returnsSucessfully() {
        RangeSet<Integer> numberRangeSet = TreeRangeSet.create();

        numberRangeSet.add(Range.closed(0, 2));
        numberRangeSet.add(Range.closed(3, 5));
        numberRangeSet.add(Range.closed(6, 8));
        RangeSet<Integer> numberRangeComplementSet
                = numberRangeSet.complement();

        Assert.isTrue(numberRangeComplementSet.contains(-1000));
        Assert.isTrue(!numberRangeComplementSet.contains(2));
        Assert.isTrue(!numberRangeComplementSet.contains(3));
        Assert.isTrue(numberRangeComplementSet.contains(1000));
    }

    /**
     * 至少有一个区间包含
     */
    public void givenRangeSet_whenIntersectsWithinRange_returnsSucessfully() {
        RangeSet<Integer> numberRangeSet = TreeRangeSet.create();

        numberRangeSet.add(Range.closed(0, 2));
        numberRangeSet.add(Range.closed(3, 10));
        numberRangeSet.add(Range.closed(15, 18));

        Assert.isTrue(numberRangeSet.intersects(Range.closed(4, 17)));
        Assert.isTrue(!numberRangeSet.intersects(Range.closed(19, 200)));
    }
}
