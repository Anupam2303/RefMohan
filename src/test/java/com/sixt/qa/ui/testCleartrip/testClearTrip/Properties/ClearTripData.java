package com.sixt.qa.ui.testCleartrip.testClearTrip.Properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component
@ConfigurationProperties(prefix = "cleartrip")
public class ClearTripData {
    private String username;
    private String password;
}
