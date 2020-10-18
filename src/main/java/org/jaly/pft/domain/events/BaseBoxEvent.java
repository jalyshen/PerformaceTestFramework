package org.jaly.pft.domain.events;

/**
 * 收集OS及Box的硬件使用信息的事件
 *
 * 示例：
 *  {
 *      "cupUsage":"45",
 *      "memUsage":"60",
 *      "threads":"38"
 *  }
 * 事件对象，属于DDD中的"Value Object"，创建后，不能更改其值。
 *
 * @author Jaly
 */
public class BaseBoxEvent {

    private String cupUsage;
    private String memUsage;
    private String threads;

    public BaseBoxEvent(String cupUsage, String memUsage, String threads) {
        this.cupUsage = cupUsage;
        this.memUsage = memUsage;
        this.threads = threads;
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
}
