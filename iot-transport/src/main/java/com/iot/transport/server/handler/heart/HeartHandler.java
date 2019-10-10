package com.iot.transport.server.handler.heart;

import com.iot.common.connection.TransportConnection;
import com.iot.config.RsocketServerConfig;
import com.iot.transport.server.handler.DirectHandler;
import io.netty.handler.codec.mqtt.MqttMessage;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class HeartHandler implements DirectHandler {


    @Override
    public Mono<Void> handler(MqttMessage message, TransportConnection connection, RsocketServerConfig config) {
        return Mono.fromRunnable(()->{
            switch (message.fixedHeader().messageType()){
                case PINGREQ:
                     connection.sendPingRes().subscribe();
                case PINGRESP:
                    log.info("accept pong{}",message.variableHeader());
            }
        });

    }
}