package com.example.r2dbc.first;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("first")
@Data
@Builder
public class FirstEntity {
    @Id
    private Long id;
    private String name;
}
