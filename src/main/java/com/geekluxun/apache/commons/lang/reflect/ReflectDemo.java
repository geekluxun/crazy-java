package com.geekluxun.apache.commons.lang.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.springframework.util.Assert;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 16:47
 * @Description:
 * @Other:
 */
public class ReflectDemo {
    public static void main(String[] argc) {
        ReflectDemo demo = new ReflectDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3(new ArrayList<String>());
    }

    private void demo1() {
        Method method = MethodUtils.getAccessibleMethod(Foo.class, "getAge", null);
        try {
            MethodUtils.invokeMethod(new Foo(), method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void demo2() {
        List<Field> fields = FieldUtils.getAllFieldsList(Foo.class);
        Field field = FieldUtils.getDeclaredField(Foo.class, "name");
        Assert.isTrue(field == null);
        // 强制访问 这样访问private
        field = FieldUtils.getDeclaredField(Foo.class, "name", true);
        Assert.isTrue(field != null);
        System.out.println(fields.size());
    }
    
    private void demo3(List<String> data){
        // TODO 这里有问题！！！
        ParameterizedType  type = (ParameterizedType) ArrayList.class.getGenericSuperclass();
        Class<?> classed = getCollectionType(data.getClass().getComponentType());
        System.out.println();
    }

    public static Class<?> getCollectionType(Type type) {
        if (TypeUtils.isAssignable(type, Collection.class)) {
            if (type instanceof ParameterizedType) {
                Type genericType = ((ParameterizedType) type).getActualTypeArguments()[0];

                if (genericType instanceof Class) {
                    return (Class<?>) genericType;
                }
            } else {
                throw new IllegalArgumentException("Cannot infer index type for non-parameterized type: " + type);
            }
        } else if (TypeUtils.isArrayType(type)) {
            return (Class<?>) TypeUtils.getArrayComponentType(type);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }
    

}  
