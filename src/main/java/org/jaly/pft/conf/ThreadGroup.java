package org.jaly.pft.conf;

/**
 * 线程组（用户）相关设置
 *
 * @author Jaly
 */
public class ThreadGroup {
    /**
     * 设置同时请求的最大用户数量
     */
    private int max;

    /**
     * 测试启动时，立即开启多少个用户同时访问。 这个数应该<=max。
     */
    private int init;

    /**
     * 用户增长数，表示每秒增长的用户（线程）数量。
     */
    private int increase;

    ThreadGroup() {}

    ThreadGroup(int max, int init, int increase) {
        this.max  = max;
        this.init = init;
        this.increase  = increase;
    }

    public void setMax(int max) {
        this.max  = max;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public int getMax() {
        return max;
    }

    public int getInit() {
        return init;
    }

    public int getIncrease() {
        return increase;
    }
}
