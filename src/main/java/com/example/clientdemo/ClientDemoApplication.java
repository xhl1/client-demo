package com.example.clientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@SpringCloudApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableScheduling
public class ClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDemoApplication.class, args);
	}
}
