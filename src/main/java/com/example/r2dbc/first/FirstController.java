package com.example.r2dbc.first;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class FirstController {

    private final FirstService firstService;

    @GetMapping
    public Mono<ResponseEntity<FirstEntity>> first() {
        return firstService.saveEntity()
                .flatMap(entity -> Mono.just(ResponseEntity.ok(entity)));
    }
}
