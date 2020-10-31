package org.jaly.pft.domain.events;

/**
 * 收集OS及Box的硬件使用信息的事件
 *
 * 示例：
 *  {
 *      "cupUsage":"45",
 *      "memUsage":"60",
 *      "threads":"38",
 *      "timing":"13:45:56"
 *  }
 * 事件对象，属于DDD中的"Value Object"，创建后，不能更改其值。
 *
 * @author Jaly
 */
public class BaseBoxEvent {

    private String cupUsage; // CPU的使用比例
    private String memUsage; // 内存使用比例
    private String threads;  // 线程数（3组：正在使用线程数；空闲线程数；僵尸线程数）
    private String timing;   // 采集数据时刻（格式：HH24:mm:ss）

    /**
     * 构建一个系统信息事件
     * @param cupUsage
     * @param memUsage
     * @param threads
     * @param timing
     */
    public BaseBoxEvent(String cupUsage, String memUsage, String threads, String timing) {
        this.cupUsage = cupUsage;
        this.memUsage = memUsage;
        this.threads = threads;
        this.timing = timing;
    }

    public String getCupUsage() {
        return cupUsage;
    }

    public String getMemUsage() {
        return memUsage;
    }

    public String getThreads() {
        return threads;
    }

    /**
     * 返回正在使用的线程数
     * @return
     */
    public String getUsingThreads() {
        return "";
    }

    /**
     * 返回空闲线程数
     * @return
     */
    public String getFreeThreads() {
        return "";
    }

    /**
     * 返回僵尸线程数
     * @return
     */
    public String getIdleThreads() {
        return "";
    }

    public String getTiming() { return timing; }
}
