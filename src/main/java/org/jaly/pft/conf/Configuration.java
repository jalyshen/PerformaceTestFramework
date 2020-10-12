package org.jaly.pft.conf;

/**
 * 配置信息对象
 *
 * snakeyaml这个包破坏了OO的封装，
 * 只能暂时把ThreadGroup和Behavior对象变为独立的public class
 *
 * @author Jaly
 */
public class Configuration {
    private ThreadGroup threadGroup;
    private Behavior behavior;

    Configuration() {}

    Configuration(ThreadGroup threadGroup, Behavior behavior) {
        this.threadGroup = threadGroup;
        this.behavior = behavior;
    }

    public void setUsers(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
    }

    public ThreadGroup getUsers() {
        return this.threadGroup;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }
}
