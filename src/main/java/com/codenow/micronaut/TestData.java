package com.codenow.micronaut;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Serdeable
public class TestData {
    private String key;
    private String value;

    public static TestData of(String key, String value) {
        return TestData.builder()
                .key(key)
                .value(value)
                .build();
    }
}
