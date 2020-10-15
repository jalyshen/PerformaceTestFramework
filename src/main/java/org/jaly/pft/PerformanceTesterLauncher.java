package org.jaly.pft;

import org.jaly.pft.conf.ConfigurationInitializer;

/**
 * 整个测试框架的启动器。通过该类开启测试
 *
 * @author Jaly
 */
public class PerformanceTesterLauncher {

    /**
     * 执行方法
     * @param args
     */
    public static void main(String[] args) {
        ConfigurationInitializer.injectingConfigurationValues();
        System.out.println("max -> " + ConfigurationInitializer.getConfiguration().getUsers().getMax());
    }
}
