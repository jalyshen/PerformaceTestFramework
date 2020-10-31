package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.Parameters;
import org.jaly.pft.domain.entities.elements.Protocol;
import org.jaly.pft.domain.entities.elements.RequestMethod;
import org.jaly.pft.domain.entities.elements.URL;
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
public abstract class TestStepTemplate implements TestStep {

    // 测试用例名称
    private String testStepName;
    // 测试使用的协议类型
    private Protocol protocol;
    // 测试的API
    private URL url;
    // 使用HTTP协议的方法（GET、POST...）
    private RequestMethod method;
    // 输入的参数
    private Parameters parameters;

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
        if (RequestMethod.RequestType.GET == method.getRequestType()) {
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
                                              getTestStepName(),
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
    public String getTestStepName() {
        return testStepName;
    }

    @Override
    public void setTestStepName(String testStepName) {
        this.testStepName = testStepName;
    }

    @Override
    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public RequestMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    @Override
    public Parameters getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

}
