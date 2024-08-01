package com.example.r2dbc.second;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final SecondRepository secondRepository;

    public Mono<SecondEntity> save() {
        return secondRepository.save(SecondEntity.builder().age(10).build())
                .flatMap(Mono::just);
    }
}
