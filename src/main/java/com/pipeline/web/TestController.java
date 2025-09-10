package com.pipeline.web;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public ResponseEntity<Map<String, String>> test(){
		return ResponseEntity.ok().body(Map.of("Testing","Up and Running By Yogesh..."));
	}
}
