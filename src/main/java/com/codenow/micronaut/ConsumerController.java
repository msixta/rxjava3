package com.codenow.micronaut;

import com.codenow.micronaut.client.TestClient;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.context.ServerRequestContext;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Controller("/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final TestClient testClient;

    @Get("/flowable")
    public Flowable<TestData> getDataFlowable() {
        return testClient.asFlowable().toList()
                         .flatMapPublisher(l -> {

                             final var currentRequest = ServerRequestContext.currentRequest();

                             Objects.requireNonNull(currentRequest.orElse(null), "Current request is null");
                             return testClient.asFlowable();
                         });
    }

    @Get("/single")
    public Single<List<TestData>> getDataSingle() {
        return testClient.asList()
                         .flatMap(l -> {

                             final var currentRequest = ServerRequestContext.currentRequest();

                             Objects.requireNonNull(currentRequest.orElse(null), "Current request is null");
                             return testClient.asList();
                         });
    }

}
