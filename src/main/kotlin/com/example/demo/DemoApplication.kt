package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

    @Bean
    fun init(repository: TopicRepository) = CommandLineRunner {
        repository.save(Topic(title = "hello"))
        repository.findAll().forEach { Topic -> println(Topic) }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
