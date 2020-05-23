package com.redhat.developers.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "adjustment-core.resend-conditions")
public class AdjustmentSendConditionsProperties {



    private Collection<Map<String, Collection>> status;


    @Bean
    @RefreshScope
    public Map<String, Collection<String>> mapStatusConditions() {

        final Map<String,Collection<String>> mapStatusReasons = new HashMap<>();

        status.forEach(mapStatus -> {

            mapStatus.keySet().forEach(status -> {
                mapStatusReasons.put(status.substring(0,status.indexOf(".")),new ArrayList<>(mapStatus.get(status)));
            });

        });

        return mapStatusReasons;
    }


    public Collection<Map<String, Collection>> getStatus() {
        return status;
    }

    public void setStatus(Collection<Map<String, Collection>> status) {
        this.status = status;
    }
}
