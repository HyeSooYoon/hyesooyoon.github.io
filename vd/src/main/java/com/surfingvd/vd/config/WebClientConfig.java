package com.surfingvd.vd.config;

import com.surfingvd.vd.apiController.VDApiController;
import com.surfingvd.vd.dto.VdYoutubeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.http.client.HttpClient;

@Slf4j
@Configuration
public class WebClientConfig {       

    @Bean
    public WebClient webClient() {    

        HttpClient httpClient = HttpClient.create()
            .tcpConfiguration(
                client -> client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000) //miliseconds
                    .doOnConnected(
                        conn -> conn.addHandlerLast(new ReadTimeoutHandler(5))     //sec
                            .addHandlerLast(new WriteTimeoutHandler(60))           //sec
                    )
            );

        //Memory 조정: 2M (default 256KB)
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024)) 
            .build();

        return WebClient.builder()
            .baseUrl("https://www.googleapis.com")            
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            // Request Header를 추가
            .filter(
                (req, next) -> next.exchange(
                    ClientRequest.from(req).header("from", "webclient").build()
                )
            )
            // Request Header를 로깅
            .filter(
                ExchangeFilterFunction.ofRequestProcessor(
                    clientRequest -> {
                        log.info("REQUEST ▶▶▶▶▶▶▶▶▶▶");
                        log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
                        clientRequest.headers().forEach(
                            (name, values) -> values.forEach(value -> log.info("{} : {}", name, value))
                        );
                        return Mono.just(clientRequest);
                    }
                )
            )
            // Response Header를 로깅
            .filter(
                ExchangeFilterFunction.ofResponseProcessor(
                    clientResponse -> {
                        log.info("RESPONSE ◀◀◀◀◀◀◀◀◀◀");
                        clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> log.info("{} : {}", name, value)));
                        return Mono.just(clientResponse);
                    }
                )
            )
            .exchangeStrategies(exchangeStrategies)            
            .defaultHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.3")
            .defaultCookie("httpclient-type", "webclient")
            .build();
    }
}
