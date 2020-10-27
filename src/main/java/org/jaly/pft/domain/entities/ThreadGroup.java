package org.jaly.pft.domain.entities;

import org.jaly.pft.conf.Configuration;

import java.util.List;

/**
 * 框架中的"测试用例组"的概念。
 * 一次完整的测试，就是一个"ThreadGroup"。
 *
 * @author Jaly
 */
public class ThreadGroup {

    /**
     * 测试用例组相关的配置信息
     */
    private Configuration.ThreadGroupConf groupConf;

    /**
     * 测试用例组包含的所有测试用例
     */
    private List<TestCase> testCases;

    /**
     * 初始化测试用例组
     *
     * @param conf
     */
    public ThreadGroup(Configuration.ThreadGroupConf conf) {
        this.groupConf = conf;
    }
}
