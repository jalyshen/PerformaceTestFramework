package org.jaly.pft.conf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * 测试用例的配置信息。 对应配置文件是TestCasePlan.json
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCasePlan {

    private CommonPart commonPart;
    private static Map<String, Api> apiMap = new Hashtable<>();
    private Plan plan;

    /**
     * 设置通用的URL，组合host，port和services sample: localhost:9000/marketplace 通讯的协议，通过api的属性来设置
     *
     * @return
     */
    public String getCommonURL() {
        if (commonPart != null && !commonPart.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer(commonPart.getHost());
            stringBuffer.append(":").append(commonPart.getPort())
                        .append("/").append(commonPart.service);
            return stringBuffer.toString();
        }
        return null;
    }

    public CommonPart getCommonPart() {
        return this.commonPart;
    }

    /**
     * 对外暴露
     *
     * @return
     */
    public Map<String, Api> getApis() {
        if (!plan.apis.isEmpty()) {
            plan.apis.forEach(api -> {
                apiMap.put(api.getApiName(), api);
            });
        }
        return apiMap;
    }

    /**
     * 各个TestCase公共部分的配置信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CommonPart {
        @JsonProperty(value = "host")
        private String host; // 服务所在的ip或者服务器名字
        @JsonProperty(value = "port")
        private Integer port = 80; // 服务的端口号，默认80
        @JsonProperty(value = "service")
        private String service; // 服务名称

        public CommonPart() {
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        /**
         * 判断是否设置了基础的参数 对Port不判断，因为如果port没有设置，默认提供80。
         *
         * @return
         */
        public boolean isEmpty() {
            if (getHost() == null || getHost().isEmpty()) {
                return true;
            }
            if (getService() == null || getService().isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /**
     * 测试计划部分
     */
    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Plan{
        private boolean isCombination;
        /**
         * 对于json，应该是映射为list， 但是系统需要map。内部需要转成map 对外，请参考属性apis
         */
        private List<Api> apis;
    }

    /**
     * 每个API对应的配置信息 如果某个属性没有设置，系统会忽略
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Api {
        @JsonProperty(value = "apiName")
        private String apiName;
        @JsonProperty(value = "protocol")
        private String protocol;
        @JsonProperty(value = "method")
        private String method;
        @JsonProperty(value = "contextType")
        private String contextType; // 这个字段可以不设置，注意null检测
        @JsonInclude(Include.ALWAYS)
        @JsonProperty(value = "path")
        private String path; // 必须要的，具体API的访问路径
        @JsonProperty(value = "parameters")
        private Map<String, String> parameters; // 这个字段可以不设置，注意null检测
        @JsonProperty(value = "order")
        private Integer order; // api的执行顺序

        public Api() {
        }

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

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        TestCasePlan tcp;
        try {
            tcp = mapper.readValue(
                    new File("/Users/jaly/Projects/PerformanceTestFramework/src/main/resources/TestCasePlan.json"),
                    TestCasePlan.class);
            System.out.println("common url -> " + tcp.getCommonURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
