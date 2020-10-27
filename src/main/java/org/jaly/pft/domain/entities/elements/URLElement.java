package org.jaly.pft.domain.entities.elements;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 配置元件中的URL元件
 *
 * @author Jaly
 */
public class URLElement extends ConfigurationElement {

    private final String URL_SLICER = ":";

    private final String URL_SLASH = "/";

    private final String HTTP_PROTOCOL = "http";

    /**
     * 一个完整的URL，是URLElement对象对外的参数
     */
    private URL wholeUrl = null;

    public URLElement() {
        elementType = ElementType.URL;
    }

    public URLElement(String host, String port, String service, String path) {
        this();
        /**
         * 如果一个完整的URL是这样的：
         *    http://10.238.38.11:9090/marketplace/productions?name=abc
         * 那么，这个file应该是这一段：
         *    file = marketplace/productions?name=abc
         * 显然，
         *    host = 10.238.38.11
         *    port = 9090
         */
        String file = URL_SLASH + service + URL_SLASH + path;
        try {
            wholeUrl = new URL(HTTP_PROTOCOL, host, Integer.valueOf(port), file );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 追加参数
     *
     * @param parameters
     * @return
     */
    public URL appendParameters(Map<String, String> parameters) {
        StringBuilder file = new StringBuilder("?");
        // 遍历
        Set<String> keys = parameters.keySet();
        int size = keys.size();
        int index =0;
        for (String key: keys) {
            if (index == size - 1) {
                file.append(key).append("=").append(parameters.get(key));
            } else {
                file.append(key).append("=").append(parameters.get(key)).append("&");
                index += 1;
            }
        }
        try {
            wholeUrl = new URL(wholeUrl.toString() + file.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return wholeUrl;
    }

    public URL getWholeUrl() {
        return wholeUrl;
    }

    public String getWholeStrUrl() {
        return wholeUrl.toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试普通的URL
        URLElement urlElement = new URLElement(
                "10.237.134.44",
                "9000",
                "marketplace",
                "productions");
        // 期待： http://10.237.134.44:9000/marketplace/productions
        System.out.println(urlElement.getWholeStrUrl());

        // 追加查询参数： ? name=abc
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "abc");
        parameters.put("cuid", "adfafdaf");
        urlElement.appendParameters(parameters);
        System.out.println(urlElement.getWholeStrUrl());
    }
}
