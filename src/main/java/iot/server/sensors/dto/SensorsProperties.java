package iot.server.sensors.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mqtt")
@Getter
@Setter
@NoArgsConstructor
public class SensorsProperties {

    private String clientId;
    private String url;
    private String[] topics;

}
