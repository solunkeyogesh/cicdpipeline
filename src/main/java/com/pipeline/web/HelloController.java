package com.pipeline.web;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello", description = "Versioned demo endpoints for CI/CD & canary")
public class HelloController {

  @GetMapping("/v1/hello")
  @Operation(summary = "Hello V1")
  public ResponseEntity<Map<String, Object>> helloV1(@RequestParam(defaultValue = "Yogesh") String name) {
    return ResponseEntity.ok(Map.of(
        "version", "v1",
        "message", "Hello " + name + " from v1 👋",
        "time", Instant.now().toString()
    ));
  }

  @GetMapping("/v2/hello")
  @Operation(summary = "Hello V2")
  public ResponseEntity<Map<String, Object>> helloV2(@RequestParam(defaultValue = "Yogesh") String name) {
    return ResponseEntity.ok(Map.of(
        "version", "v2",
        "message", "Hello " + name + " from v2 🚀",
        "time", Instant.now().toString(),
        "extra", "This is a new field in v2"
    ));
  }
}