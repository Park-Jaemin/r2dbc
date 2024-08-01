package com.example.r2dbc.second;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("second")
public class SecondEntity {
    @Id
    private Long id;
    private int age;
}
