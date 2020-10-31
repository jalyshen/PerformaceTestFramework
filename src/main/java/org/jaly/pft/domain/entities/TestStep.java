package org.jaly.pft.domain.entities;

import org.jaly.pft.domain.entities.elements.Parameters;
import org.jaly.pft.domain.entities.elements.Protocol;
import org.jaly.pft.domain.entities.elements.RequestMethod;
import org.jaly.pft.domain.entities.elements.URL;

/**
 * 一个测试步骤，可以有返回值，也可以没有返回值。
 * 为了统一这2种测试用例，需要用一个"标签"类
 *
 * @author Jaly
 */
public interface TestStep extends Runnable {

    String getTestStepName();

    void setTestStepName(String testStepName);

    Protocol getProtocol();

    void setProtocol(Protocol protocol);

    URL getUrl();

    void setUrl(URL url);

    RequestMethod getMethod();

    void setMethod(RequestMethod method);

    Parameters getParameters();

    void setParameters(Parameters parameters);
}
