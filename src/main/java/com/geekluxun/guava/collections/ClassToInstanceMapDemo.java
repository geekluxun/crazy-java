package com.geekluxun.guava.collections;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;


/**
 * @Author: luxun
 * @Create: 2018-06-30 10:07
 * @Description:
 * @Other:
 *
 * Sometimes, your map keys aren't all of the same type: they are types,
 * and you want to map them to values of that type.
 * Guava provides ClassToInstanceMap for this purpose.
 * 适合key是不同类型场景(继承同一父类)
 */
public class ClassToInstanceMapDemo {

    public static void main(String[] argc){
         ClassToInstanceMapDemo demo = new ClassToInstanceMapDemo();
         demo.demo1();
    }

    /**
     * 和map的区别就是两个方法putInstance ， getInstance
     * 不会有类型转换安全问题 适合父类子类场景
     */
    private void demo1(){
        ClassToInstanceMap<Action> map = MutableClassToInstanceMap.create();
        map.putInstance(Delete.class, new Delete());
        map.putInstance(Open.class, new Open());
        map.putInstance(Save.class, new Save());

        map.getInstance(Delete.class).action();
        map.getInstance(Open.class).action();
        map.getInstance(Save.class).action();
    }

    private abstract class Action{
        public abstract void action();
    }
    private class Delete extends Action{
        @Override
        public void action() {
            System.out.println("delete!!!");
        }
    }
    private class Open extends Action{
        @Override
        public void action() {
            System.out.println("open!!!");
        }
    }
    private class Save extends Action{
        @Override
        public void action() {
            System.out.println("save!!!");
        }
    }

}


