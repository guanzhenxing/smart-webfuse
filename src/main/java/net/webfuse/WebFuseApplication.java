package net.webfuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFuseApplication {



	//TODO PermissionAop，参考guns
	//TODO 认证可以使用拦截器

	//TODO 数据范围

	public static void main(String[] args) {
		SpringApplication.run(WebFuseApplication.class, args);
	}
}
