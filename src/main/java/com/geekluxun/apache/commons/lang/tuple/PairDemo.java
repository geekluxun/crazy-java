package com.geekluxun.apache.commons.lang.tuple;

        import org.apache.commons.lang3.tuple.ImmutablePair;
        import org.apache.commons.lang3.tuple.MutablePair;
        import org.apache.commons.lang3.tuple.Pair;
        import org.apache.commons.lang3.tuple.Triple;

        import java.math.BigDecimal;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-12 14:11
 * @Description:
 * @Other:
 */
public class PairDemo {
    public static void main(String[] argc){
        PairDemo demo = new PairDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }

    /**
     * 两元组
     */
    private void demo1(){
        Pair<String, String> pair = Pair.of("a", "bbb");
        Pair pair2 = Pair.of("c", "eee");
        // 先比较left 如果left相等 再比较 right
        int equal = pair.compareTo(pair2);
        // key是left value是right
        String key = pair.getKey();
        String value = pair.getValue();
        String left = pair.getLeft();
        String right = pair.getRight();
        System.out.println();
    }

    /**
     * 三元组
     */
    private void demo2(){
        Triple<String, Integer, BigDecimal> user1 = Triple.of("luxun", 20, BigDecimal.valueOf(100));
        Triple<String, Integer, BigDecimal> user2 = Triple.of("luxun", 30, BigDecimal.valueOf(90));
        int compare = user1.compareTo(user2);
        user1.equals(user2);
        user1.getLeft();
        user1.getMiddle();
        user1.getRight();
    }
    
    private void demo3(){
        MutablePair<String, String> pair = MutablePair.of("luxun", "hello");
        pair.setLeft("luxun222");
        pair.setRight("hello222");
        String left = pair.getLeft();
        String right = pair.getRight();
        pair.setValue("lu");
        right = pair.getRight();
        System.out.println();

        ImmutablePair<String, String> pair2 = ImmutablePair.of("luxun333", "hello333");
    }
}
