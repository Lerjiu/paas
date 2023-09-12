package com.buaa.paas.config;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class DockerClientBean {
    @Value("${docker.host}")
    private String host;

    @Value("${docker.api-version}")
    private String apiVersion;
    @Value("${docker.docker-tls-verify}")
    private boolean dockerTleVerify;

    @Value("${docker.registry-url}")
    private String registryUrl;
    @Bean
    public DockerClient connect() {
        // 配置docker CLI的一些选项
        DefaultDockerClientConfig config = DefaultDockerClientConfig
                .createDefaultConfigBuilder()
                .withDockerTlsVerify(dockerTleVerify)
                .withDockerHost(host)
                // 与docker版本对应，参考https://docs.docker.com/engine/api/#api-version-matrix
                // 或者通过docker version指令查看api version
                .withApiVersion(apiVersion)
                .withRegistryUrl(registryUrl)
                .build();

        // 创建DockerHttpClient
        DockerHttpClient httpClient = new ApacheDockerHttpClient
                .Builder()
                .dockerHost(config.getDockerHost())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();

        DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);
//        Info info = dockerClient.infoCmd().exec();
//        String infoStr = JSONObject.toJSONString(info);
//        System.out.println("docker环境信息");
//        System.out.println(infoStr);
        return dockerClient;
    }

}
