package com.codenow.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.rxjava3.core.Flowable;

import java.util.List;

@Controller("/test")
public class TestServiceController {



    @Get
    public Flowable<Object> getTestData() {
        final var testData = List.of(TestData.of("key1", "value1"), TestData.of("key2", "value2"));

        return Flowable.fromIterable(testData);
    }
}
