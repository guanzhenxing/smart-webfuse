package cn.webfuse;

import cn.webfuse.framework.datasource.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class SmartWebFuseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartWebFuseApplication.class, args);
    }
}
