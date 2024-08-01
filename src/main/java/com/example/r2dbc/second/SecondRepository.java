package com.example.r2dbc.second;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SecondRepository extends R2dbcRepository<SecondEntity, Long> {
}
