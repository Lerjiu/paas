package com.buaa.paas.service.impl;

import com.buaa.paas.domain.DockerProp;
import com.buaa.paas.service.DockerService;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.github.dockerjava.api.model.HostConfig.newHostConfig;

@Service
public class DockerServiceImpl implements DockerService {
    @Value("${docker.registry-url}")
    private String registryUrl;
    private DockerClient dockerClient;

    public DockerServiceImpl(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Image> listImages() {
        List<Image> images = dockerClient.listImagesCmd().exec();
        for (Image image : images) {
            System.out.println(image);
        }
        return images;
    }

    @Override
    public boolean pullImage(String imageName) {
        boolean isSuccess = false;
        try {
            isSuccess = dockerClient.pullImageCmd(registryUrl + imageName)
                    .start()
                    .awaitCompletion(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            return isSuccess;
        }
    }

    @Override
    public List<Container> listContainers() {
        List<Container> containers = dockerClient.listContainersCmd()
                .withShowAll(true).exec();
        for (Container container : containers) {
            System.out.println(container.getId() + "\t" + container.getNames() + "\t" + container.getStatus());
        }
        return containers;
    }

    @Override
    public CreateContainerResponse createContainers(DockerProp dockerProp) {
        // 端口绑定
        Map<Integer, Integer> portMap = Optional.ofNullable(dockerProp).map(DockerProp::getPortMap).orElse(new HashMap<>());
        Iterator<Map.Entry<Integer, Integer>> iterator = portMap.entrySet().iterator();
        List<PortBinding> portBindingList = new ArrayList<>();
        List<ExposedPort> exposedPortList = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            ExposedPort tcp = ExposedPort.tcp(entry.getKey());
            Ports.Binding binding = Ports.Binding.bindPort(entry.getValue());
            PortBinding ports = new PortBinding(binding, tcp);
            portBindingList.add(ports);
            exposedPortList.add(tcp);
        }

        CreateContainerResponse container = dockerClient.createContainerCmd(dockerProp.getImageName())
                .withName(dockerProp.getContainerName())
                .withHostConfig(newHostConfig().withPortBindings(portBindingList))
                .withExposedPorts(exposedPortList).exec();
        System.out.println("Created container---------------------------------");
        System.out.println(container);
        return container;
    }


}
