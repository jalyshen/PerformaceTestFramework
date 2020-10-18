package org.jaly.pft.collector.box;

import java.util.Map;

public interface BoxCollector {

    Map<String, String> runDistanceShell(String[] commands, String user, String passwd, String host);

    Map<String, String> runLocalShell(String[] commands);

    String disposeResultMessage(Map<String, String> result);
}
