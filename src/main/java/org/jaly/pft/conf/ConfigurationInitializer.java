package org.jaly.pft.conf;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


/**
 * 框架启动后，读取配置
 *
 * @author Jaly
 */
public class ConfigurationInitializer {

    private static String DEFAULT_CONFIGURATION_SETTING = "default_configuration.yml";
    private static Configuration configuration;

    /**
     * 读取配置文件中的值，并初始化Configuration对象
     * 提供给框架使用
     */
    public static void injectingConfigurationValues() {
        InputStream inputStream = ConfigurationInitializer.class
                .getClassLoader()
                .getResourceAsStream(DEFAULT_CONFIGURATION_SETTING);
        readConfigurationFile(inputStream);
    }

    public static void injectingConfigurationValues(String configurationFile) {
        if (configurationFile != null && !configurationFile.isEmpty()) {
            File confFile = new File(configurationFile);
            try {
                InputStream inputStream = new FileInputStream(confFile);
                readConfigurationFile(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // 应该抛出异常，提示用户输入正确的配置文件路径
            injectingConfigurationValues();
        }
    }

    /**
     * 读取文件的任务，上移到各个具体方法里。
     * 然后全部转化为InputStream对象，这个方法专心处理InputStream对象与配置对象的转化
     *
     * @param configurationFileInputStream
     */
    private static void readConfigurationFile(InputStream configurationFileInputStream) {
        Yaml yaml = new Yaml();
        configuration = yaml.loadAs(configurationFileInputStream, Configuration.class);
    }

    /**
     * 系统使用的配置信息
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
