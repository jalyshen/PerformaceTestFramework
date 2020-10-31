package org.jaly.pft.domain.entities;

import org.jaly.pft.conf.Configuration;

import java.util.List;

/**
 * 框架中的"测试用例"的概念。
 * 一次完整的测试
 *
 * @author Jaly
 */
public class TestCase {

    /**
     * 测试用例组相关的配置信息
     */
    private Configuration.ThreadGroupConf groupConf;

    /**
     * 测试用例组包含的所有测试用例
     */
    private List<TestStep> testSteps;

    /**
     * 初始化测试用例
     *
     * @param conf
     */
    public TestCase(Configuration.ThreadGroupConf conf) {
        this.groupConf = conf;
    }
}
