package com.wx.sample.service;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleService {
    @Autowired
    private ApplicationInfoManager applicationInfoManager;

    @Value("${test.name}")
    private String name;

    @RequestMapping(value = "sample", method = RequestMethod.GET)
    @ResponseBody
    public InstanceInfo sample() {
        return applicationInfoManager.getInfo();
    }

    @RequestMapping(value = "hi")
    public String hi() {
        return "HI" + name;
    }
}
