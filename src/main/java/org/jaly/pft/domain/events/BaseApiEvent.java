package org.jaly.pft.domain.events;

import org.jaly.pft.domain.entities.elements.RequestTypeElement.RequestType;

import java.sql.Timestamp;

/**
 * 事件对象，用于收集测试用例(API)执行时间的对象
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
public class BaseApiEvent {
    /**
     * 事件发生前的时间戳
     */
    private Timestamp startTime;
    /**
     * 事件结束时的时间戳
     */
    private Timestamp endTime;
    /**
     * 触发此事件的测试用例名称
     */
    private String testCaseName;

    /**
     * 当前测试的API唯一表识
     */
    private String apiIdentify;
    /**
     * 触发此事件的方法类型
     */
    private RequestType method;

    /**
     * 测试的结果。一个完整的HTTP Response。
     * 由于HttpUtil返回的结果都是String，
     * 因此，需要后续的事件分析器做相应的对象转化
     */
    private String testResult;

    public BaseApiEvent(Timestamp startTime, Timestamp endTime,
                        String testCaseName, String apiIdentify,
                        RequestType method, String testResult) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.testCaseName = testCaseName;
        this.apiIdentify = apiIdentify;
        this.method = method;
        this.setTestResult(testResult);
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

    public String getApiIdentify() {
        return apiIdentify;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
