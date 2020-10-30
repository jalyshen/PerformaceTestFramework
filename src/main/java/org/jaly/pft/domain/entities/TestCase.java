package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.ParameterElement;
import org.jaly.pft.domain.entities.elements.RequestProtocolElement;
import org.jaly.pft.domain.entities.elements.RequestTypeElement;
import org.jaly.pft.domain.entities.elements.URLElement;

/**
 * 一个测试用例，可以有返回值，也可以没有返回值。
 * 为了统一这2种测试用例，需要用一个"标签"类
 *
 * @author Jaly
 */
public interface TestCase {

    String getTestCaseName();

    void setTestCaseName(String testCaseName);

    RequestProtocolElement getProtocol();

    void setProtocol(RequestProtocolElement protocol);

    URLElement getUrl();

    void setUrl(URLElement url);

    RequestTypeElement getMethod();

    void setMethod(RequestTypeElement method);

    ParameterElement getParameters();

    void setParameters(ParameterElement parameters);
}
