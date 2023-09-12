package com.buaa.paas;

import com.buaa.paas.domain.DockerProp;
import com.buaa.paas.service.DockerService;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@SpringBootTest
public class PaasApplicationTests {
    @Autowired
    private DockerService dockerService;

    @Test
    public void listImages() {
        dockerService.listImages();
    }

    @Test
    public void pullImage() {
        dockerService.pullImage("nginx:latest");
    }

    @Test
    public void listContainers() {
        dockerService.listContainers();
    }

    @Test void createContainers() {
        DockerProp dockerProp = new DockerProp();
        dockerProp.setContainerName("test-create-container");
        dockerProp.setImageName("nginx");
        dockerProp.setImageTag("latest");
        dockerProp.setPortMap(new HashMap<>(9001, 80));

        dockerService.createContainers(dockerProp);
    }
}
