package org.jaly.pft.conf;

/**
 * 配置信息对象
 *
 * snakeyaml这个包破坏了OO的封装，
 * 只能暂时把Users和Behavior对象变为独立的public class
 *
 * @author Jaly
 */
public class Configuration {
    private Users users;
    private Behavior behavior;

    Configuration() {}

    Configuration(Users users, Behavior behavior) {
        this.users  = users;
        this.behavior = behavior;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }
}
