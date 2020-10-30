package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.ParameterElement;
import org.jaly.pft.domain.entities.elements.RequestProtocolElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement.RequestType;
import org.jaly.pft.domain.entities.elements.URLElement;
import org.jaly.pft.domain.events.BaseApiEvent;
import org.jaly.pft.utils.HttpUtils;

import java.sql.Timestamp;
import java.util.Map;

/**
 * 框架中的"测试用例"概念
 * 一个测试用例就是一个Java中的Thread对象
 * 这个对象是不会有返回值的
 *
 * @author Jaly
 */
public abstract class TestCaseTemplate implements Runnable, TestCase {

    // 测试用例名称
    private String testCaseName;
    // 测试使用的协议类型
    private RequestProtocolElement protocol;
    // 测试的API
    private URLElement url;
    // 使用HTTP协议的方法（GET、POST...）
    private RequestTypeElement method;
    // 输入的参数
    private ParameterElement parameters;

    /**
     * 这个Map用户存储某个TestCase的输出，
     * 其他的TestCase使用这里的数据作为输入
     */
    private Map<String, Object> middleResponses;

    /**
     * 根据每个TestCase自身的情况，构建请求参数。
     * 1. 如果当前TestCase是GET，那么构建的请求参数应该是放到URL中，
     *    这个情况下，当前方法会修改URL对象；
     * 2. 如果是非GET，则作为一个JSON放到Body中
     *    当前情况下，URL对象不会发生改变，但是会修改Request请求对象
     *
     * 这个方法，需要修改TestCaseTemplate的parameters变量
     */
    public abstract void buildingParameters();

    @Override
    public void run() {
        // 构建输入参数
        this.buildingParameters();
        String result = null;
        Timestamp beginTime = new Timestamp(System.currentTimeMillis());
        if (RequestType.GET == method.getRequestType()) {
            //TODO: 缺少设置URL的参数
            result = HttpUtils.doGet(this.getUrl().getWholeStrUrl(),
                                            false);
        } else {
            result = HttpUtils.doPost(this.getUrl().getWholeStrUrl(),
                             this.getParameters().getBodyPayload(),
                             false);
        }
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        BaseApiEvent event = new BaseApiEvent(beginTime, endTime,
                                              getTestCaseName(),
                                              null,
                                              getMethod().getRequestType(),
                                              result);
        sendEvent(event); // 发送事件
    }

    /**
     * 发送事件到事件接收器
     * @param event
     */
    private void sendEvent(BaseApiEvent event) {
        //TODO: 发送Event到事件接收器
    }

    @Override
    public String getTestCaseName() {
        return testCaseName;
    }

    @Override
    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    @Override
    public RequestProtocolElement getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(RequestProtocolElement protocol) {
        this.protocol = protocol;
    }

    @Override
    public URLElement getUrl() {
        return url;
    }

    @Override
    public void setUrl(URLElement url) {
        this.url = url;
    }

    @Override
    public RequestTypeElement getMethod() {
        return method;
    }

    @Override
    public void setMethod(RequestTypeElement method) {
        this.method = method;
    }

    @Override
    public ParameterElement getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(ParameterElement parameters) {
        this.parameters = parameters;
    }

}
