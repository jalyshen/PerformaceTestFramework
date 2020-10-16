package org.jaly.pft.domain.entities;

/**
 * 框架中的"配置元件"概念
 * 配置元件有如下几种：
 *   ** 请求协议
 *   ** URL
 *   ** HTTP的请求类型
 *   ** 请求参数
 *
 */
public abstract class ConfigurationElement {

    public ElementType elementType; // 表示当前的配置信息是哪一类

    enum ElementType {
        PROTOCOL, //HTTP， TCP，UDP等
        URL, // 服务端的URL
        HTTP_TYPE, // GET， POST，PUT等
        PARAMETER; // 请求参数
    }
}
