package org.jaly.pft.domain.entities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 配置元件中的URL元件
 *
 * @author Jaly
 */
public class URLElement extends ConfigurationElement {

    private final String URL_SLICER = ":";

    private String hostName;
    private String port;
    private String path;

    public URLElement() {
        elementType = ElementType.URL;
    }

    public URLElement(String hostName, String port, String path) {
        this();
        this.hostName = hostName;
        this.port = port;
        this.path = path;
    }

    /**
     * 获取完整的请求路径
     *
     * @return
     */
    public String getEndPointWithStr() {
        if (hostName == null || hostName.isEmpty()) {
            return null; // 或者抛出一场
        }
        //TODO: 这里需要根据Protocol提供默认的port
        if (port == null || port.isEmpty()) {
            return null;
        }
        return hostName + URL_SLICER + port + path;
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
}
