package com.example.r2dbc.second;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class SecondController {

    private final SecondService secondService;

    @GetMapping("/2")
    public Mono<ResponseEntity<SecondEntity>> second() {
        return secondService.save().flatMap(s -> Mono.just(ResponseEntity.ok(s)));
    }
}
