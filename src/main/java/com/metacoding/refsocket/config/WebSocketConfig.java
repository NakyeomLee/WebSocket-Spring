package com.metacoding.refsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// 옵저버 패턴 노션 정리 참고(고객이 마트를 구독해서 물건 들어오면 알림받음)
// SRP : 마트 점원(메세지 브로커) 세팅

@EnableWebSocketMessageBroker // 웹소켓 메세지 브로커
@Configuration // 설정 파일이라고 IOC에 띄움
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // sub(브라우저) : /바나나
    // pub(브라우저) : /바나나
    
    // 웹소켓 연결 앤드포인트 설정
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect")
                .setAllowedOriginPatterns("*"); // * : /connect 뒤로 모든 경우 가능
    }

    // 구독, 발행 앤드포인트 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); // /sub로 시작하는 모든 주소(구독)
        registry.setApplicationDestinationPrefixes("/pub"); // /pub로 시작하는 모든 주소(발행)
    }
}