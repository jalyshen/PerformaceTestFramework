package org.jaly.pft.domain.entities.elements;

/**
 * 配置元件中的请求协议元件
 *
 * @author Jaly
 */
public class RequestTypeElement extends ConfigurationElement {

    private RequestType requestType;

    public RequestTypeElement() {
        this.elementType = ElementType.HTTP_TYPE;
    }

    public RequestTypeElement(RequestType requestType) {
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
