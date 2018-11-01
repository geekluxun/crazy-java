package com.geekluxun.apache.commons.lang.builder;

import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 14:09
 * @Description:
 * @Other:
 */
public class EqualsBuilderDemo {
    public static void main(String[] argc) {
        EqualsBuilderDemo demo = new EqualsBuilderDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(10, 10);
        builder.append('a', 'a');
        boolean result = builder.isEquals();
        // 比较两个对象 
        EqualsBuilder.reflectionEquals(this, this);
        System.out.println();
    }

    /**
     * 两个对象比较示例
     */
    private void demo2() {
        Student student1 = new Student();
        student1.setName("luxun");
        student1.setAge(10);
        student1.setMathScore(BigDecimal.valueOf(100));
        Student student2 = null;
        try {
            student2 = (Student) SerializationUtils.clone(student1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 因为score不参与比较，所以，忽略其值比较
        student2.setMathScore(BigDecimal.valueOf(99));

        Validate.isTrue(student1.compareTo(student2) == 0);
        Validate.isTrue(student1.equals(student2));
        System.out.println();
    }

    @Data
    private static class Student implements Serializable, Comparable<Student> {
        private String name;
        private Integer age;
        // 字段不参与比较和计算hashcode
        @EqualsExclude
        @HashCodeExclude
        private BigDecimal mathScore;

        @Override
        public boolean equals(Object o) {
            return EqualsBuilder.reflectionEquals(this, o);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        /**
         * 通过反射实现
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Student o) {
            // 成绩不参与比较 exclude
            return CompareToBuilder.reflectionCompare(this, o, "mathScore");
        }
    }
}
