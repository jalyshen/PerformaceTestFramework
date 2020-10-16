package org.jaly.pft.domain.entities.elements;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置元件中的请求参数元件
 *
 * @author Jaly
 */
public class ParameterElement extends ConfigurationElement {

    private String parameterJsonString;

    public ParameterElement() {
        this.elementType = ElementType.PARAMETER;
    }

    public ParameterElement(String parameterJsonString) {
        this();
        this.parameterJsonString = parameterJsonString;
    }

    /**
     * 把parameter变为K-V，让使用方转化为URL上的参数
     *
     * @return
     */
    public Map<String, String> convertToParameter() {
        Map<String, String> parameters = new HashMap<>();
        //TOOD: 转化JSON为K-V
        return parameters;
    }


    /**
     * 原始的参数形式，即一个String，内容为一个JSON对象。
     * 这个参数会根据请求类型而变化。
     *   * 如果是GET请求，此内容会变成K-V形式，拼接在URL上
     *   * 如果是POST等请求，会作为BODY的Payload
     */
    public String getParameterJsonString() {
        return parameterJsonString;
    }

    public void setParameterJsonString(String parameterJsonString) {
        this.parameterJsonString = parameterJsonString;
    }
}
