package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.event.EventListenerSupport;
import org.apache.commons.lang3.event.EventUtils;
import org.springframework.util.Assert;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.TreeMap;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 15:29
 * @Description: 事件监听器
 * @Other:
 */
public class EventUtilsDemo {
    public static void main(String[] argc) {
        EventUtilsDemo demo = new EventUtilsDemo();
        demo.demo1();
    }

    private void demo1() {
        final PropertyChangeSource src = new PropertyChangeSource();
        final EventCountingInvociationHandler handler = new EventCountingInvociationHandler();
        final PropertyChangeListener listener = handler
                .createListener(PropertyChangeListener.class);

        Assert.isTrue(0 == handler.getEventCount("propertyChange"));
        EventUtils.addEventListener(src, PropertyChangeListener.class, listener);
        Assert.isTrue(0 == handler.getEventCount("propertyChange"));
        src.setProperty("newValue");
        Assert.isTrue(1 == handler.getEventCount("propertyChange"));
    }

    public static class PropertyChangeSource {
        private final EventListenerSupport<PropertyChangeListener> listeners =
                EventListenerSupport.create(PropertyChangeListener.class);

        private String property;

        public void setProperty(final String property) {
            final String oldValue = this.property;
            this.property = property;
            // 监听器
            listeners.fire().propertyChange(new PropertyChangeEvent(this, "property", oldValue, property));
        }

        protected void addVetoableChangeListener(
                final VetoableChangeListener listener) {
            // Do nothing!
        }

        public void addPropertyChangeListener(
                final PropertyChangeListener listener) {
            listeners.addListener(listener);
        }

        public void removePropertyChangeListener(
                final PropertyChangeListener listener) {
            listeners.removeListener(listener);
        }
    }

    public static class EventCountingInvociationHandler implements InvocationHandler {
        private final Map<String, Integer> eventCounts = new TreeMap<String, Integer>();

        public <L> L createListener(final Class<L> listenerType) {
            return listenerType.cast(Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class[]{listenerType}, this));
        }

        public int getEventCount(final String eventName) {
            final Integer count = eventCounts.get(eventName);
            return count == null ? 0 : count.intValue();
        }

        @Override
        public Object invoke(final Object proxy, final Method method,
                             final Object[] args) throws Throwable {
            final Integer count = eventCounts.get(method.getName());
            if (count == null) {
                eventCounts.put(method.getName(), Integer.valueOf(1));
            } else {
                eventCounts.put(method.getName(), Integer.valueOf(count.intValue() + 1));
            }
            return null;
        }
    }

}

