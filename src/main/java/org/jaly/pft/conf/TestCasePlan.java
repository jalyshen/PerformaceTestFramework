package org.jaly.pft.conf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 测试用例的配置信息。
 * 对应配置文件是TestCasePlan.json
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCasePlan {

    @JsonInclude(Include.ALWAYS)
    private CommonPart commonPart;

    private static Map<String, Api> apis = new Hashtable<>();

    private static String commonURL = "";

    /**
     * 对于json，应该是映射为list，
     * 但是系统需要map。内部需要转成map
     * 对外，请参考属性apis
     */
    @JsonInclude(Include.ALWAYS)
    @JsonProperty(value = "apis")
    private List<Api> innerApis;

    /**
     * 设置通用的URL，组合host，port和services
     * sample: localhost:9000/marketplace
     * 通讯的协议，通过api的属性来设置
     * @return
     */
    public String getCommonURL() {
        if (commonPart != null && !commonPart.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer(commonPart.getHost());
            stringBuffer.append(":").append(commonPart.getPort())
                        .append("/").append(commonPart.service);
            commonURL = stringBuffer.toString();
        }
        return commonURL;
    }

    /**
     * 对外暴露
     * @return
     */
    public Map<String, Api> getApis() {
        if (!innerApis.isEmpty()) {
            innerApis.forEach(api -> {
                apis.put(api.getApiName(), api);
            });
        }
        return apis;
    }

    /**
     * 各个TestCase公共部分的配置信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class CommonPart {
        private String host; // 服务所在的ip或者服务器名字
        private String port = "80"; // 服务的端口号，默认80
        private String service; // 服务名称

        CommonPart(String host, String port, String service) {
            this.host = host;
            this.port = port;
            this.service = service;
        }

        public String getService() {
            return service;
        }

        public String getHost() {
            return host;
        }

        public String getPort() {
            return port;
        }

        /**
         * 判断是否设置了基础的参数
         * 对Port不判断，因为如果port没有设置，默认提供80。
         * @return
         */
        public boolean isEmpty() {
            if (getHost() == null || getHost().isEmpty()) return false;
            if (getService() == null || getService().isEmpty()) return false;
            return true;
        }
    }

    /**
     * 每个API对应的配置信息
     * 如果某个属性没有设置，系统会忽略
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Api {
        private String apiName;
        private String protocol;
        private String method;
        private String contextType; // 这个字段可以不设置，注意null检测
        @JsonInclude(Include.ALWAYS)
        private String path; // 必须要的，具体API的访问路径
        @JsonProperty(value = "parameters")
        private Map<String, String> parameters; // 这个字段可以不设置，注意null检测

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getContextType() {
            return contextType;
        }

        public void setContextType(String contextType) {
            this.contextType = contextType;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        TestCasePlan tcp;
        try {
            tcp = mapper.readValue(new File("TestCasePlan.json"), TestCasePlan.class);
            System.out.println("sss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
