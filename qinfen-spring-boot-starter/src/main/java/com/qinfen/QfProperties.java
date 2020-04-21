package com.qinfen;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.qf")
public class QfProperties {
    private String name = "豆豆";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
