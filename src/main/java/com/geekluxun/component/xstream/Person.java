package com.geekluxun.component.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-17 14:54
 * @Description:
 * @Other:
 */
@Data
@XStreamAlias("person")
public class Person {
    private String name;
    // 作为person元素的属性
    // <person age="18"></person>
    @XStreamAsAttribute
    private int age;
    @XStreamImplicit(itemFieldName = "girlFriends")
    private List<Person> girlFriends;
}
