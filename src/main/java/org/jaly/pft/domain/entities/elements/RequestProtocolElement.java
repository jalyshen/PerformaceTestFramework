package org.jaly.pft.domain.entities.elements;

/**
 * 配置元件中的请求协议元件
 *
 * @author Jaly
 */
public class RequestProtocolElement extends ConfigurationElement{

    private Protocol protocol;

    public RequestProtocolElement() {
        elementType = ElementType.PROTOCOL;
    }

    public RequestProtocolElement(Protocol protocol) {
        this(); // 设置配置元件类型
        this.setProtocol(protocol);
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * 定义请求协议类型
     */
    enum Protocol{
        HTTP, HTTPS, TCP, UDP;
    }
}
