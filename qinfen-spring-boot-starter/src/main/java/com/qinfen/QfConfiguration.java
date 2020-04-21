package com.qinfen;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SayHello.class)
@EnableConfigurationProperties(QfProperties.class)
public class QfConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SayHello getSayHello() {
        return new SayHelloImpl();
    }
}
