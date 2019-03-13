package cn.webfuse.smartwebfuse.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.webfuse"})
public class SmartWebfuseAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartWebfuseAdminApplication.class, args);
    }

}
