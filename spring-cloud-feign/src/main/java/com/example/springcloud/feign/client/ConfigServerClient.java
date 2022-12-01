package com.example.springcloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="CONFIG-SERVER")
public interface ConfigServerClient {
	
	@GetMapping("/demo")
	String demo();

}
