package com.geekluxun.jdk.lang.compareable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: luxun
 * @Create: 2018-11-01 11:03
 * @Description:
 * @Other:
 */
public class Student implements Comparable<Student> {
    private int age;
    private String name;

    public static void main(String[] argc) {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student(15, "luxun");
        Student student2 = new Student(10, "zuxun");
        Student student3 = new Student(13, "luxun");
        Student student4 = new Student(13, "auxun");

        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        System.out.println("排序前:");
        studentList.stream().forEach((e) -> System.out.println("age:" + e.getAge() + " name:" + e.getName()));
        // 方式1
        Collections.sort(studentList, new StudentCompartor());
        // 方式2
        Collections.sort(studentList);
        System.out.println("重新排序后:");
        studentList.stream().forEach((e) -> System.out.println("age:" + e.getAge() + " name:" + e.getName()));

        System.out.print("ok");
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 按年龄从小到大，年龄相同，按名字字母序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if (this.age == o.getAge()) {
            return this.name.compareTo(o.getName());
        }
        return (age - o.getAge());
    }
}
