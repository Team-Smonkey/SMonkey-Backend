package com.saehyun.smonkey.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.saehyun.smonkey.global.security.filter.FilterConfig
import com.saehyun.smonkey.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .authorizeRequests()
            .antMatchers("/user").permitAll()
            .antMatchers("/user/signin").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(
                FilterConfig(
                    jwtTokenProvider = jwtTokenProvider,
                    objectMapper = objectMapper,
                )
            )

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
