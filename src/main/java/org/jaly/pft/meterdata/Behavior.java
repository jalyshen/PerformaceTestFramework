package org.jaly.pft.meterdata;

/**
 * 线程（Test case）执行过程中的行为
 */
public class Behavior {
    /**
     * 指定了启动所有用户（线程）所花费的时间，单位是秒，
     * 默认时间是1秒。如果需要立即启动所有用户（线程），将此设定为0即可
     */
    private int rampUpPeriod;

    /**
     * 循环次数，表示每个用户执行多少次请求。 -1表示永远循环，除非手动停止
     */
    private int loopCount;

    /**
     * 定时器，负责定义请求(线程)之间的延迟间隔，模拟对服务器的连续请求。
     * 用于操作之间设置等待时间，等待时间是性能测试中常用的控制客户端QPS的手段。
     * 如果不指定，会一个请求(线程)完成后立即执行下一个请求(线程)，没有任何等待时间。
     */
    private int timers;

    Behavior() {}

    Behavior(int rampUpPeriod, int loopCount, int timers) {
        this.rampUpPeriod  = rampUpPeriod;
        this.loopCount = loopCount;
        this.timers = timers;
    }

    public void setRampUpPeriod(int rampUpPeriod) {
        this.rampUpPeriod  = rampUpPeriod;
    }

    public void setLoopCount(int loopCount) {
        this.loopCount = loopCount;
    }

    public void setTimers(int timers) {
        this.timers = timers;
    }

    public int getRampUpPeriod() {
        return rampUpPeriod;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getTimers() {
        return timers;
    }
}
