package org.jaly.pft.collector.box;

import java.util.Map;

/**
 * 通过执行Shell脚本，获取服务器的信息。
 * 信息通过Key-Value的形式返回。
 *
 * 为什么不分别返回CPU，内存等信息，是因为针对类Unix系统，
 * 通过一个命令就可以获得相应的信息，只需要不同系统的具体格式分析，
 * 就可以同时获得。
 * 因此，这个接口只定义了一个主要的Run***Shell接口
 *
 */
public interface BoxCollector {

    /**
     * 在远程服务器上执行若干Shell命令，获取需要的结果
     * @param commands 若干需要执行的命令
     * @param user 拥有相应权限的类Unix系统用户
     * @param passwd 类Unix系统用户的登录密码
     * @param host 远程服务器的IP地址，或者host名称
     * @return
     */
    Map<String, String> runDistanceShell(String[] commands, String user, String passwd, String host);

    /**
     * 在本级服务器上执行若干Shell命令，获取需要的结果
     * 这个方法常常用来测试 #runDistanceShell
     * @param commands
     * @return
     */
    Map<String, String> runLocalShell(String[] commands);

    /**
     * 根据需要，处理 #runDistanceShell 或者 #runLocalShell 方法返回的结果
     * @param result
     * @return
     */
    String disposeResultMessage(Map<String, String> result);
}
