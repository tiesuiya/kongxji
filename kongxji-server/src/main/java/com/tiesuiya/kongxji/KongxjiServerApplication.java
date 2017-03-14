package com.tiesuiya.kongxji;

import org.kongxji.framework.jdbc.CustomeRespositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*扫描框架和本应用*/
@ComponentScan(basePackages = {"org.kongxji.framework", "com.tiesuiya.kongxji"})
/*扫描@WebServlet, @WebFilter, and @WebListener*/
@ServletComponentScan(basePackages = "org.kongxji.framework.web")
/*指定jpa基类*/
@EnableJpaRepositories(basePackages = "com.tiesuiya.kongxji.respository", repositoryBaseClass = CustomeRespositoryImpl.class)
public class KongxjiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongxjiServerApplication.class, args);
	}
}
