package com.buaa.paas.service;

import com.buaa.paas.domain.DockerProp;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

import java.util.List;

public interface DockerService {
    List<Image> listImages();
    boolean pullImage(String imageName);
    List<Container> listContainers();
    CreateContainerResponse createContainers(DockerProp dockerProp);
}
