package com.geekluxun.component.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luxun
 * @Create: 2018-10-31 17:00
 * @Description: 集合的基准测试示例
 * @Other:
 */
@BenchmarkMode(Mode.AverageTime)      // 计算平均值
@OutputTimeUnit(TimeUnit.NANOSECONDS) // 纳秒时间单位
@Warmup(iterations = 5)
public class CollectionBenchmark {

    public static void main(String[] argc) {
        Options options = new OptionsBuilder()
                .include(CollectionBenchmark.class.getSimpleName())
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .jvmArgs("-server")
                .build();

        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 状态类
     */
    @State(Scope.Thread)
    public static class MyState {
        private Set<Employee> employeeSet = new HashSet<>();
        private List<Employee> employeeList = new ArrayList<>();


        private long iterations = 10000;

        private Employee employee = new Employee(100L, "luxun");

        /**
         * 初始化
         */
        @Setup(Level.Trial)
        public void setUp() {
            for (long i = 0; i < iterations; i++) {
                employeeSet.add(new Employee(i, "geek"));
                employeeList.add(new Employee(i, "geek"));
            }

            employeeList.add(employee);
            employeeSet.add(employee);
        }
    }

    /**
     * 基准测试list
     *
     * @param state
     * @return
     */
    @Benchmark
    public boolean testArrayList(MyState state) {
        return state.employeeList.contains(state.employee);
    }

    /**
     * 基准测试set
     *
     * @param state
     * @return
     */
    @Benchmark
    public boolean testHashSet(MyState state) {
        return state.employeeSet.contains(state.employee);
    }

}
