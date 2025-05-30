package com.zerobase.api.com.zerobase.api.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.zerobase.domain"])
@ComponentScan(basePackages = ["com.zerobase"])
class JpaAuditingConfiguration {

}