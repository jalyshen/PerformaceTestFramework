package org.jaly.pft.domain.tcs;

import org.jaly.pft.domain.entities.TestStepTemplate;

/**
 * 框架提供一个默认的HTTP的测试步骤对象。
 * 一般的，可以直接使用。
 * 如果满足不了需求，可以自定义TestCase
 *
 * @author Jaly
 */
public class DefaultHttpTestStep extends TestStepTemplate {

    public DefaultHttpTestStep() {}

    public DefaultHttpTestStep(String testCaseName) {
        this.setTestStepName(testCaseName);
    }

    @Override
    public void buildingParameters() {

    }
}
