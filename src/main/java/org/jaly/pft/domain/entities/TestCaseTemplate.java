package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.ParameterElement;
import org.jaly.pft.domain.entities.elements.RequestProtocolElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement.RequestType;
import org.jaly.pft.domain.entities.elements.URLElement;
import org.jaly.pft.domain.events.BaseApiEvent;
import org.jaly.pft.utils.HttpUtils;

import java.sql.Timestamp;

/**
 * 框架中的"测试用例"概念
 * 一个测试用例就是一个Java中的Thread对象
 * 这个对象是不会有返回值的
 *
 * @author Jaly
 */
public abstract class TestCaseTemplate implements Runnable, TestCase {

    private String testCaseName;
    private RequestProtocolElement protocol;
    private URLElement url;
    private RequestTypeElement method;
    private ParameterElement parameters;

    /**
     * 根据每个TestCase自身的情况，构建请求参数。
     * 1. 如果当前TestCase是GET，那么构建的请求参数应该是放到URL中，
     *    这个情况下，当前方法会修改URL对象；
     * 2. 如果是非GET，则作为一个JSON放到Body中
     *    当前情况下，URL对象不会发生改变，但是会修改Request请求对象
     */
    public abstract void buidingParameters();

    @Override
    public void run() {
        this.buidingParameters();
        String result = null;
        Timestamp beginTime = new Timestamp(System.currentTimeMillis());
        if (RequestType.GET == method.getRequestType()) {
            result = HttpUtils.doGet(this.getUrl().getEndPointWithStr(),
                                            false);
        } else {
            result = HttpUtils.doPost(this.getUrl().getEndPointWithStr(),
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
