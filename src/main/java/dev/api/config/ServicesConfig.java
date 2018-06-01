package dev.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("dev.api.service")

@EnableJpaRepositories("dev.api.repository") // config a ajouter
public class ServicesConfig {

}