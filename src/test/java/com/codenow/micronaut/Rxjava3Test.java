package com.codenow.micronaut;

import com.codenow.micronaut.client.TestClient;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import java.util.Objects;

@MicronautTest
class Rxjava3Test {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

}
