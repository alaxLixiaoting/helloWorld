package com.springCloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceInstanceRestController {

    //@Autowired
    //private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaClient eurakaDiscoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        //return discoveryClient.getInstances(applicationName);
        return null;
    }


    @RequestMapping("/service-instances/serviceUrl")
    @ResponseBody
    public String serviceServiceUrl() {
        InstanceInfo instance = eurakaDiscoveryClient.getNextServerFromEureka("client", false);
        return instance.getHomePageUrl();
    }

}
