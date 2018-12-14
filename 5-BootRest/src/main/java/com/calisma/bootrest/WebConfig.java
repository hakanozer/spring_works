package com.calisma.bootrest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.calisma.bootrest")
public class WebConfig implements WebMvcConfigurer{
	
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource dt = new DriverManagerDataSource();
		dt.setDriverClassName("com.mysql.jdbc.Driver");
		dt.setUrl("jdbc:mysql://localhost/masterpage?useUnicode=true&characterEncoding=utf-8");
		dt.setUsername("root");
		dt.setPassword("");
		return dt;
	}
		

}