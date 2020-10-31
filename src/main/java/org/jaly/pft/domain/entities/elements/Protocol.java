package org.jaly.pft.domain.entities.elements;

/**
 * 配置元件中的请求协议元件
 *
 * @author Jaly
 */
public class Protocol extends ConfigurationElement{

    private ProtocolType protocolType;

    public Protocol() {
        elementType = ElementType.PROTOCOL;
    }

    public Protocol(ProtocolType protocol) {
        this(); // 设置配置元件类型
        this.setProtocol(protocol);
    }

    public ProtocolType getProtocol() {
        return protocolType;
    }

    public void setProtocol(ProtocolType protocol) {
        this.protocolType = protocol;
    }

    /**
     * 定义请求协议类型
     */
    enum ProtocolType {
        HTTP, HTTPS, TCP, UDP;
    }
}
