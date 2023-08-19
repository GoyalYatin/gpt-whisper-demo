package com.example.gptwhisperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GptWhisperDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptWhisperDemoApplication.class, args);
	}

}
