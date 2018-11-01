package com.geekluxun.jdk.lang.compareable;

import java.util.Comparator;

/**
 * @Author: luxun
 * @Create: 2018-11-01 11:27
 * @Description:
 * @Other:
 */
public class StudentCompartor implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        }
        return (o1.getAge() - o2.getAge());
    }
}
