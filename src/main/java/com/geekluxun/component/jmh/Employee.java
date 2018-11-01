package com.geekluxun.component.jmh;

import java.util.Objects;

/**
 * @Author: luxun
 * @Create: 2018-10-31 17:02
 * @Description:
 * @Other:
 */
public class Employee {
    private Long id;
    private String name;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
