package org.jaly.pft.domain.entities;

import org.jaly.pft.conf.Configuration;
import org.jaly.pft.conf.TestCasePlan;

import java.util.Map;

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
    private Configuration configuration;

    /**
     * 测试用例的计划
     */
    private TestCasePlan testCasePlan;

    /**
     * 测试用例组包含的所有测试用例
     * String key: 测试步骤的名字
     * TestStep testStep: 测试步骤
     */
    private Map<String, TestStep> testSteps;

    /**
     * 初始化测试用例
     *
     * @param configuration
     */
    public TestCase(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 执行一个TestCase
     */
    public void run() {

    }
}
