package com.geekluxun.apache.commons.collections;

import org.apache.commons.collections.*;
import org.apache.commons.collections.functors.NOPClosure;
import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

import java.util.*;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-12 14:56
 * @Description: 闭包工具类
 * @Other:
 */
public class ClosureUtilsDemo {
    private static final Object cObject = new Object();
    private static final Object cString = "Hello";
    private static final Object cInteger = new Integer(6);
    
    public static void main(String[] argc){
        ClosureUtilsDemo demo = new ClosureUtilsDemo();
        demo.testChainedClosure();
        demo.testDoWhileClosure();
        demo.testExceptionClosure();
        demo.testForClosure();;
        demo.testInvokeClosure();
        demo.testNopClosure();
        demo.testSwitchClosure();
        demo.testSwitchMapClosure();
        demo.testTransformerClosure();
        demo.testWhileClosure();
    }

    static class MockClosure implements Closure {
        int count = 0;

        public void execute(Object object) {
            count++;
        }
    }
    static class MockTransformer implements Transformer {
        int count = 0;

        public Object transform(Object object) {
            count++;
            return object;
        }
    }
    
    public void testExceptionClosure() {
        assertNotNull(ClosureUtils.exceptionClosure());
        Assert.isTrue(ClosureUtils.exceptionClosure() == ClosureUtils.exceptionClosure());
        try {
            ClosureUtils.exceptionClosure().execute(null);
        } catch (FunctorException ex) {
            try {
                ClosureUtils.exceptionClosure().execute(cString);
            } catch (FunctorException ex2) {
                return;
            }
        }
    }

    public void testNopClosure() {
        StringBuffer buf = new StringBuffer("Hello");
        ClosureUtils.nopClosure().execute(null);
        Assert.isTrue("Hello".equals(buf.toString()));
        ClosureUtils.nopClosure().execute("Hello");
        Assert.isTrue("Hello".equals(buf.toString()));
    }
    
    public void testInvokeClosure() {
        StringBuffer buf = new StringBuffer("Hello");
        ClosureUtils.invokerClosure("reverse").execute(buf);
        Assert.isTrue("olleH".equals(buf.toString()));
        buf = new StringBuffer("Hello");
        ClosureUtils.invokerClosure("setLength", new Class[] {Integer.TYPE}, new Object[] {new Integer(2)}).execute(buf);
        Assert.isTrue("He".equals(buf.toString()));
    }
    
    public void testForClosure() {
        MockClosure cmd = new MockClosure();
        ClosureUtils.forClosure(5, cmd).execute(null);
        Assert.isTrue(5 == cmd.count);
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.forClosure(0, new MockClosure()));
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.forClosure(-1, new MockClosure()));
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.forClosure(1, null));
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.forClosure(3, null));
        Assert.isTrue(cmd == ClosureUtils.forClosure(1, cmd));
    }
    
    public void testWhileClosure() {
        MockClosure cmd = new MockClosure();
        ClosureUtils.whileClosure(PredicateUtils.falsePredicate(), cmd).execute(null);
        Assert.isTrue(0 ==  cmd.count);

        cmd = new MockClosure();
        ClosureUtils.whileClosure(PredicateUtils.uniquePredicate(), cmd).execute(null);
        Assert.isTrue(1 == cmd.count);

        try {
            ClosureUtils.whileClosure(null, ClosureUtils.nopClosure());
            //fail();
        } catch (IllegalArgumentException ex) {}
        try {
            ClosureUtils.whileClosure(PredicateUtils.falsePredicate(), null);
            //fail();
        } catch (IllegalArgumentException ex) {}
        try {
            ClosureUtils.whileClosure(null, null);
            //fail();
        } catch (IllegalArgumentException ex) {}
    }
    

    public void testDoWhileClosure() {
        MockClosure cmd = new MockClosure();
        ClosureUtils.doWhileClosure(cmd, PredicateUtils.falsePredicate()).execute(null);
        Assert.isTrue(1 == cmd.count);

        cmd = new MockClosure();
        ClosureUtils.doWhileClosure(cmd, PredicateUtils.uniquePredicate()).execute(null);
        Assert.isTrue(2 == cmd.count);

        try {
            ClosureUtils.doWhileClosure(null, null);
            //fail();
        } catch (IllegalArgumentException ex) {}
    }
    
    public void testChainedClosure() {
        MockClosure a = new MockClosure();
        MockClosure b = new MockClosure();
        ClosureUtils.chainedClosure(a, b).execute(null);
        Assert.isTrue(1 == a.count);
        Assert.isTrue(1 == b.count);

        a = new MockClosure();
        b = new MockClosure();
        ClosureUtils.chainedClosure(new Closure[] {a, b, a}).execute(null);
        Assert.isTrue(2 == a.count);
        Assert.isTrue(1 ==  b.count);

        a = new MockClosure();
        b = new MockClosure();
        Collection coll = new ArrayList();
        coll.add(b);
        coll.add(a);
        coll.add(b);
        ClosureUtils.chainedClosure(coll).execute(null);
        Assert.isTrue(1 == a.count);
        Assert.isTrue(2 == b.count);

        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.chainedClosure(new Closure[0]));
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.chainedClosure(Collections.EMPTY_LIST));

        try {
            ClosureUtils.chainedClosure(null, null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        
        try {
            ClosureUtils.chainedClosure((Closure[]) null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        
        try {
            ClosureUtils.chainedClosure((Collection) null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        
        try {
            ClosureUtils.chainedClosure(new Closure[] {null, null});
          
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        
        try {
            coll = new ArrayList();
            coll.add(null);
            coll.add(null);
            ClosureUtils.chainedClosure(coll);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }
    
    public void testSwitchClosure() {
        MockClosure a = new MockClosure();
        MockClosure b = new MockClosure();
        // 条件为真 执行a
        ClosureUtils.ifClosure(PredicateUtils.truePredicate(), a, b).execute(null);
        Assert.isTrue(1 ==  a.count);
        Assert.isTrue(0 == b.count);
        // 条件为假 执行b
        a = new MockClosure();
        b = new MockClosure();
        ClosureUtils.ifClosure(PredicateUtils.falsePredicate(), a, b).execute(null);
        Assert.isTrue(0 ==  a.count);
        Assert.isTrue(1 ==  b.count);
        // swith
        a = new MockClosure();
        b = new MockClosure();
        ClosureUtils.switchClosure(
                new Predicate[] {PredicateUtils.equalPredicate("HELLO"), PredicateUtils.equalPredicate("THERE")},
                new Closure[] {a, b}).execute("WELL");
        Assert.isTrue(0 == a.count);
        Assert.isTrue(0 ==  b.count);

        a = new MockClosure();
        b = new MockClosure();
        ClosureUtils.switchClosure(
                new Predicate[] {PredicateUtils.equalPredicate("HELLO"), PredicateUtils.equalPredicate("THERE")},
                new Closure[] {a, b}).execute("HELLO");
        Assert.isTrue(1 == a.count);
        Assert.isTrue(0 ==  b.count);

        // 数组构造条件谓词 带default的switch
        a = new MockClosure();
        b = new MockClosure();
        MockClosure c = new MockClosure();
        ClosureUtils.switchClosure(
                new Predicate[] {PredicateUtils.equalPredicate("HELLO"), PredicateUtils.equalPredicate("THERE")},
                new Closure[] {a, b}, c).execute("WELL");
        Assert.isTrue(0 ==  a.count);
        Assert.isTrue(0 ==  b.count);
        Assert.isTrue(1 ==  c.count);

        // map 构造条件谓词 
        a = new MockClosure();
        b = new MockClosure();
        Map map = new HashMap();
        map.put(PredicateUtils.equalPredicate("HELLO"), a);
        map.put(PredicateUtils.equalPredicate("THERE"), b);
        ClosureUtils.switchClosure(map).execute(null);
        Assert.isTrue(0 == a.count);
        Assert.isTrue(0 ==  b.count);

        a = new MockClosure();
        b = new MockClosure();
        map = new HashMap();
        map.put(PredicateUtils.equalPredicate("HELLO"), a);
        map.put(PredicateUtils.equalPredicate("THERE"), b);
        ClosureUtils.switchClosure(map).execute("THERE");
        Assert.isTrue(0 == a.count);
        Assert.isTrue(1 == b.count);

        a = new MockClosure();
        b = new MockClosure();
        c = new MockClosure();
        map = new HashMap();
        map.put(PredicateUtils.equalPredicate("HELLO"), a);
        map.put(PredicateUtils.equalPredicate("THERE"), b);
        map.put(null, c);
        // 没有
        ClosureUtils.switchClosure(map).execute("WELL");
        Assert.isTrue(0 == a.count);
        Assert.isTrue(0 == b.count);
        Assert.isTrue(1 ==  c.count);
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.switchClosure(new Predicate[0], new Closure[0]));
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.switchClosure(new HashMap()));
        map = new HashMap();
        map.put(null, null);
        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.switchClosure(map));

        try {
            ClosureUtils.switchClosure(null, null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        try {
            ClosureUtils.switchClosure((Predicate[]) null, (Closure[]) null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        try {
            ClosureUtils.switchClosure((Map) null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        try {
            ClosureUtils.switchClosure(new Predicate[2], new Closure[2]);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        try {
            ClosureUtils.switchClosure(
                new Predicate[] {PredicateUtils.truePredicate()},
                new Closure[] {a,b});
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }

    public void testSwitchMapClosure() {
        MockClosure a = new MockClosure();
        MockClosure b = new MockClosure();
        Map map = new HashMap();
        map.put("HELLO", a);
        map.put("THERE", b);
        ClosureUtils.switchMapClosure(map).execute(null);
        Assert.isTrue(0 == a.count);
        Assert.isTrue(0 ==  b.count);

        a = new MockClosure();
        b = new MockClosure();
        map = new HashMap();
        map.put("HELLO", a);
        map.put("THERE", b);
        ClosureUtils.switchMapClosure(map).execute("THERE");
        Assert.isTrue(0 == a.count);
        Assert.isTrue(1 ==  b.count);

        a = new MockClosure();
        b = new MockClosure();
        MockClosure c = new MockClosure();
        map = new HashMap();
        map.put("HELLO", a);
        map.put("THERE", b);
        map.put(null, c);
        ClosureUtils.switchMapClosure(map).execute("WELL");
        Assert.isTrue(0 == a.count);
        Assert.isTrue(0 == b.count);
        Assert.isTrue(1 == c.count);

        Assert.isTrue(NOPClosure.INSTANCE == ClosureUtils.switchMapClosure(new HashMap()));

        try {
            ClosureUtils.switchMapClosure(null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }

    public void testTransformerClosure() {
        MockTransformer mock = new MockTransformer();
        Closure closure = ClosureUtils.asClosure(mock);
        closure.execute(null);
        Assert.isTrue(1 == mock.count);
        closure.execute(null);
        Assert.isTrue(2 == mock.count);

        Assert.isTrue(ClosureUtils.nopClosure() == ClosureUtils.asClosure(null));
    }
}
