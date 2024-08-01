package com.example.r2dbc.first;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FirstService {

    private final FirstRepository firstRepository;

    public Mono<FirstEntity> saveEntity() {
        return firstRepository.save(FirstEntity.builder().name("이름").build())
                .flatMap(Mono::just);
    }
}
