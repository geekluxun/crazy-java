package com.geekluxun.jdk.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @Author: luxun
 * @Create: 2018-11-07 13:55
 * @Description:
 * @Other:
 */
public class JmxDemo {
    public static void main(String[] argc) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.geekluxun.jdk.jmx:name=game");
        Game gameObj = new Game();
        // 注册到mbean到服务器，可以通过jconsole对此bean进行操作
        mBeanServer.registerMBean(gameObj, objectName);
        while (true) {

        }
    }


}
