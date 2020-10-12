package org.jaly.pft.collector.event;

/**
 * 执行测试用例过程中，需要及时的记录测试用例执行的一些数据。
 * 框架需要通过发送Event的方式来记录。
 *
 * BaseEvent对象，就是所有事件的根对象。定义了测试框架需要的基本信息。
 * 具体的事件，可以扩展此对象。
 *
 * @author Jaly
 */
public class BaseEvent {

    /**
     * 记录当前事件来源于哪个线程，用于后面的性能数据统计
     */
    private String threadName;
}
