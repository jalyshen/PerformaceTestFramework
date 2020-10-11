package org.jaly.pft.meterdata;

/**
 * 配置信息对象
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
