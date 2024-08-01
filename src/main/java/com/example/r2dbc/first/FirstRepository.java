package com.example.r2dbc.first;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FirstRepository extends R2dbcRepository<FirstEntity, Long> {
}
