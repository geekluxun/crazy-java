package com.geekluxun.guava.network;

import com.google.common.net.InternetDomainName;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-03 11:13
 * @Description: 域名校验器
 * @Other:
 */
public class InternetDomainNameDemo {
    public static void main(String[] argc){
        InternetDomainNameDemo demo = new InternetDomainNameDemo();
        demo.demo1();
    }
    
    public void demo1(){
        InternetDomainName domainName = InternetDomainName.from("jenkins.xxd.com");
        System.out.println("a: " + domainName.topDomainUnderRegistrySuffix());
        System.out.println("b: " + domainName.topPrivateDomain());
        System.out.println("c: " + domainName.publicSuffix());
    }
}
