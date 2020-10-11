package org.jaly.pft;

import org.jaly.pft.meterdata.ConfigurationInitialzer;

/**
 * 整个测试框架的启动器。通过该类开启测试
 *
 * @author jaly
 */
public class PerformanceTesterLauncher {

    /**
     * 执行方法
     * @param args
     */
    public static void main(String[] args) {
        ConfigurationInitialzer.injectingConfigurationValues();
        System.out.println("max -> " + ConfigurationInitialzer.getConfiguration().getUsers().getMax());
    }
}
