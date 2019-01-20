package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.HiddenHttpMethodFilter

@Configuration
class AppConfig{

    @Bean
    fun filter(): HiddenHttpMethodFilter = HiddenHttpMethodFilter()
}
