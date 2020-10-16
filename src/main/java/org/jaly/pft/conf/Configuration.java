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
    private ThreadGroupConf threadGroupConf;
    private Behavior behavior;

    Configuration() {}

    Configuration(ThreadGroupConf threadGroupConf, Behavior behavior) {
        this.threadGroupConf = threadGroupConf;
        this.behavior = behavior;
    }

    public void setUsers(ThreadGroupConf threadGroupConf) {
        this.threadGroupConf = threadGroupConf;
    }

    public ThreadGroupConf getUsers() {
        return this.threadGroupConf;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }
}
