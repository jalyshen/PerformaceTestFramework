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
    private TestUsersConf testUsersConf;
    private Behavior behavior;

    public Configuration() {}

    public Configuration(TestUsersConf testUsersConf, Behavior behavior) {
        this.testUsersConf = testUsersConf;
        this.behavior = behavior;
    }

    public int getRampUpPeriod() {
        return behavior.getRampUpPeriod();
    }

    public int getLoopCount() {
        return behavior.getLoopCount();
    }

    public int getTimers() {
        return behavior.getTimers();
    }

    public int getMax() {
        return testUsersConf.getMax();
    }

    public int getInit() {
        return testUsersConf.getInit();
    }

    public int getIncrease() {
        return testUsersConf.getIncrease();
    }

    /**
     * 线程（Test case）执行过程中的行为
     * 对应到configuration中的"behavior"段
     * 这个配置是全局性的，针对整个测试框架
     *
     * @author Jaly
     */
    class Behavior {
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

        void setRampUpPeriod(int rampUpPeriod) {
            this.rampUpPeriod  = rampUpPeriod;
        }

        void setLoopCount(int loopCount) {
            this.loopCount = loopCount;
        }

        void setTimers(int timers) {
            this.timers = timers;
        }

        int getRampUpPeriod() {
            return rampUpPeriod;
        }

        int getLoopCount() {
            return loopCount;
        }

        int getTimers() {
            return timers;
        }
    }

    /**
     * 测试用例相关设置
     * 对应configuration配置文件中的"users"段
     * 这个配置是全局性的，针对整个测试框架
     *
     * @author Jaly
     */
    class TestUsersConf {
        /**
         * 设置同时请求的最大线程（用户）数量
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

        TestUsersConf() {}

        TestUsersConf(int max, int init, int increase) {
            this.max  = max;
            this.init = init;
            this.increase  = increase;
        }

        void setMax(int max) {
            this.max  = max;
        }

        void setInit(int init) {
            this.init = init;
        }

        void setIncrease(int increase) {
            this.increase = increase;
        }

        int getMax() {
            return max;
        }

        int getInit() {
            return init;
        }

        int getIncrease() {
            return increase;
        }
    }
}
