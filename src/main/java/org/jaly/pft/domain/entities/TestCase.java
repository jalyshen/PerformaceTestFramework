package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.ParameterElement;
import org.jaly.pft.domain.entities.elements.RequestProtocolElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement.RequestType;
import org.jaly.pft.domain.entities.elements.URLElement;
import org.jaly.pft.utils.HttpUtils;

/**
 * 框架中的"测试用例"概念
 * 一个测试用例就是一个Java中的Thread对象
 *
 * @author Jaly
 */
public abstract class TestCase implements Runnable {

    private String testCaseName;
    private RequestProtocolElement protocol;
    private URLElement url;
    private RequestTypeElement method;
    private ParameterElement parameters;
    private boolean needReadResponse;

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
        if (RequestType.GET == method.getRequestType()) {
            HttpUtils.doGet(this.getUrl().getEndPointWithStr(), this.isNeedReadResponse());
        } else {
            HttpUtils.doPost(this.getUrl().getEndPointWithStr(),
                             this.getParameters().getBodyPayload(),
                             this.isNeedReadResponse());
        }
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public RequestProtocolElement getProtocol() {
        return protocol;
    }

    public void setProtocol(RequestProtocolElement protocol) {
        this.protocol = protocol;
    }

    public URLElement getUrl() {
        return url;
    }

    public void setUrl(URLElement url) {
        this.url = url;
    }

    public RequestTypeElement getMethod() {
        return method;
    }

    public void setMethod(RequestTypeElement method) {
        this.method = method;
    }

    public ParameterElement getParameters() {
        return parameters;
    }

    public void setParameters(ParameterElement parameters) {
        this.parameters = parameters;
    }

    public boolean isNeedReadResponse() {
        return needReadResponse;
    }

    public void setNeedReadResponse(boolean needReadResponse) {
        this.needReadResponse = needReadResponse;
    }
}
