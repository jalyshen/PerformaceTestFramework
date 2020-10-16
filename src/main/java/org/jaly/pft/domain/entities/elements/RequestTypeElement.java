package org.jaly.pft.domain.entities.elements;

/**
 * 配置元件中的请求协议元件
 *
 * @author Jaly
 */
public class RequestTypeElement extends ConfigurationElement {

    public RequestTypeElement() {
        this.elementType = ElementType.HTTP_TYPE;
    }

    enum RequestType {
        GET, POST, PUT, DELETE;
    }
}
