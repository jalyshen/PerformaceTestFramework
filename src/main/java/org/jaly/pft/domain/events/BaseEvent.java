package org.jaly.pft.domain.events;

import org.jaly.pft.domain.entities.elements.RequestTypeElement.RequestType;

import java.sql.Timestamp;

/**
 * 事件对象，用于收集测试用例执行时间的对象
 *
 * 示例：
 *   {
 *     "testCaseName": "获取用户的DutyDate",
 *     "method":"GET",
 * 	   "startTime": 98765492,
 *     "endTime": 98876448
 * }
 *
 *  事件对象，属于DDD中的"Value Object"，创建后，不能更改其值。
 *
 * @author Jaly
 */
public class BaseEvent {
    /**
     * 事件发生前的时间戳
     */
    private Timestamp startTime;
    /**
     * 事件结束时的时间戳
     */
    private Timestamp endTime;
    /**
     * 触发此事件的测试用例
     */
    private String testCaseName;
    /**
     * 触发此事件的方法类型
     */
    private RequestType method;

    public BaseEvent(Timestamp startTime, Timestamp endTime,
                     String testCaseName, RequestType method) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.testCaseName = testCaseName;
        this.method = method;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public RequestType getMethod() {
        return method;
    }
}
