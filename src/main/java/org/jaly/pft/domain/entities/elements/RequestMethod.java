package org.jaly.pft.domain.entities.elements;

/**
 * 配置元件中的请求协议元件
 *
 * @author Jaly
 */
public class RequestMethod extends ConfigurationElement {

    private RequestType requestType;

    public RequestMethod() {
        this.elementType = ElementType.HTTP_TYPE;
    }

    public RequestMethod(RequestType requestType) {
        this();
        this.setRequestType(requestType);
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public enum RequestType {
        GET, POST, PUT, DELETE;
    }
}
