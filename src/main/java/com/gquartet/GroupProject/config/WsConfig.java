package com.gquartet.GroupProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    //kanoume register ena websocket end point to opoio oi xrhstes 8a xrhsimopoihsoun gia na sunde8oun ston websocket Server 
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("javatechie").withSockJS(); //--> withSockJS() se periptwsh pou o browser den uposthrizei to websocket 
    }

    //kanoume configure enan broker pou 8a stelenei mnm stous xrhstes 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");  //orizoume oti ta mnm pou 3ekinane me /topic 8a prepei na 3ekinaei ston broker 
        registry.setApplicationDestinationPrefixes("/app"); //orizoume ta mnm pou o proorismos tous 3ekinamei me /app
    }

}
