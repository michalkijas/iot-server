package iot.server.sensors.domain;

import iot.server.sensors.dto.SensorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

/**
 * @see https://docs.spring.io/spring-integration/reference/html/mqtt.html
 */
@Configuration
class SensorsConfiguration {

    @Bean
    MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter(SensorsProperties properties) {
        return new MqttPahoMessageDrivenChannelAdapter(
                properties.getUrl(),
                properties.getClientId(),
                properties.getTopics()
        );
    }

    @Bean
    SensorDataHandler sensorDataHandler() {
        return new SensorDataHandler();
    }

    @Bean
    IntegrationFlow integrationFlow(
            MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter,
            SensorDataHandler sensorDataHandler
    ) {
        return IntegrationFlows
                .from(mqttPahoMessageDrivenChannelAdapter)
                .handle(sensorDataHandler::process)
                .get();
    }

}
