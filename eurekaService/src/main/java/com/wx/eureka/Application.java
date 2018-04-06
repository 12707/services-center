package com.wx.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableEurekaServer
@Controller
public class Application {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ExitCodeGenerator exitCodeGenerator;

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

    @RequestMapping("exit")
    @ResponseBody
    public String exit() {
        SpringApplication.exit(applicationContext, exitCodeGenerator);
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
