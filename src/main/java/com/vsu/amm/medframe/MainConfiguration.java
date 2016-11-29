package com.vsu.amm.medframe;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@ComponentScan("com.vsu.amm.medframe")
@EnableJpaRepositories
@EnableTransactionManagement
public class MainConfiguration {
}
