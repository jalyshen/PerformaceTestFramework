package org.jaly.pft.domain.entities.elements;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 配置元件中的URL元件
 *
 * @author Jaly
 */
public class URLElement extends ConfigurationElement {

    private final String URL_SLICER = ":";

    private String host;
    private String port;
    private String service;
    private String path;

    public URLElement() {
        elementType = ElementType.URL;
    }

    public URLElement(String host, String port, String service, String path) {
        this();
        this.setHost(host);
        this.setPort(port);
        this.setService(service);
        this.setPath(path);
    }

    /**
     * 获取完整的请求路径
     *
     * @return
     */
    public String getEndPointWithStr() {
        if (host == null || host.isEmpty()) {
            return null; // 或者抛出一场
        }
        //TODO: 这里需要根据Protocol提供默认的port
        if (port == null || port.isEmpty()) {
            return null;
        }
        return host + URL_SLICER + port + path;
    }

    /**
     * 提供URL类型的完整请求路径
     *
     * @return
     */
    public URL getEndPointWithURL() {
        URL url = null;
        try {
            url = this.getEndPointWithStr() == null ? null : new URL(this.getEndPointWithStr());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
