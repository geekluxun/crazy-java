package com.geekluxun.guava.preconditions;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 8:58
 * @Description: 前置条件验证Demo
 * @Other: 适用场景：对方法调用参数进行验证，即验证调用者传的参数的合法性
 * 不适用场景：不是由于调用的错误导致的错误检查
 */
public class PreconditionsDemo {
    private static final Logger logger = LoggerFactory.getLogger(PreconditionsDemo.class);

    public static void main(String[] argc) {
        demo1();
        //demo2();
        //demo3("luxun", 9);
        //demo4();
        demo5();
    }

    private static void demo1() {
        try {
            Preconditions.checkArgument(1 > 0);
            // 抛IllegalArgumentException异常 message由参数提供
            Preconditions.checkArgument(1 > 5, "条件错误！！");
            Preconditions.checkNotNull(null, "不能为null!!");
        } catch (Exception e) {
            logger.error("异常:", e);
        }

    }

    private static void demo2() {
        // 抛java.lang.NullPointerException message由参数提供
        Preconditions.checkNotNull(null, "不能为null!!");
    }

    private static void demo3(String name, Integer age) {
        // 抛IllegalArgumentException message由参数提供 不同之处可以格式化输出错误的参数值方便排查问题
        Preconditions.checkArgument(age > 10, "年龄:%s,姓名：%s", age, name);
    }

    private static void demo4() {
        Preconditions.checkPositionIndex(3, 2);
    }

    private static void demo5() {
        // 抛IllegalStateException异常 比如：流已经关闭，再从流中读取数据
        Preconditions.checkState(1 > 5, "无效状态");
    }


}
