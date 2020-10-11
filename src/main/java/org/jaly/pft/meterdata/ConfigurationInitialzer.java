package org.jaly.pft.meterdata;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;


/**
 * 框架启动后，读取配置
 */
public class ConfigurationInitialzer {

    private static String DEFAULT_CONFIGURATION_SETTING = "default_configuration.yml";
    private static Configuration configuration;

    /**
     * 读取配置文件中的值，并初始化Configuration对象
     * 提供给框架使用
     */
    public static void injectingConfigurationValues() {
        readConfigurationFile(DEFAULT_CONFIGURATION_SETTING);
    }

    public static void injectingConfigurationValues(String configurationFile) {
        if (configurationFile != null && !configurationFile.isEmpty()) {
            readConfigurationFile(configurationFile);
        } else {
            // 应该抛出异常，提示用户输入正确的配置文件路径
            readConfigurationFile(DEFAULT_CONFIGURATION_SETTING);
        }
    }

    private static void readConfigurationFile(String configurationFile) {
        Yaml yaml = new Yaml();
        InputStream inputStream = ConfigurationInitialzer.class
                                                         .getClassLoader()
                                                         .getResourceAsStream(configurationFile);
        configuration = yaml.loadAs(inputStream, Configuration.class);
    }

    /**
     * 系统使用的配置信息
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
