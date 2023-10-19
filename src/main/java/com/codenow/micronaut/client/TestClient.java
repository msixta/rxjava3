package com.codenow.micronaut.client;

import com.codenow.micronaut.TestData;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

@Client(id = "test-service")
public interface TestClient {

    @Get("/test")
    Flowable<TestData> asFlowable();

    @Get("/test")
    Single<List<TestData>> asList();
}
