package com.saehyun.smonkey.global.exception.properties

import com.saehyun.smonkey.global.security.properties.JwtProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackageClasses = [JwtProperties::class])
@Configuration
class ConfigurationPropertiesScanConfig
