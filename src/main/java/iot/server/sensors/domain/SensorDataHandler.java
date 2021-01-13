package iot.server.sensors.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;

@Slf4j
class SensorDataHandler {

    void process(Message<?> message) {
        log.info("MQTT Message [topic={}, payload={}]", message.getHeaders().get("mqtt_receivedTopic"), message.getPayload());
    }

}
