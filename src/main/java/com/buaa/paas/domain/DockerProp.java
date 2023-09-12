package com.buaa.paas.domain;
import java.util.List;
import java.util.Map;

public class DockerProp {
    private String containerName;
    private String imageName;
    private String imageTag;
    // 端口绑定（宿主机：容器）
    private Map<Integer, Integer> portMap;
    private Map<String, String> pathMap;
    private String env;
    // 挂载分卷
    private List<String> volumes;
    private String dockerfilePath;
    private String respository;
    private String tag;

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public Map<Integer, Integer> getPortMap() {
        return portMap;
    }

    public void setPortMap(Map<Integer, Integer> portMap) {
        this.portMap = portMap;
    }

    public Map<String, String> getPathMap() {
        return pathMap;
    }

    public void setPathMap(Map<String, String> pathMap) {
        this.pathMap = pathMap;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public List<String> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<String> volumes) {
        this.volumes = volumes;
    }

    public String getDockerfilePath() {
        return dockerfilePath;
    }

    public void setDockerfilePath(String dockerfilePath) {
        this.dockerfilePath = dockerfilePath;
    }

    public String getRespository() {
        return respository;
    }

    public void setRespository(String respository) {
        this.respository = respository;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
