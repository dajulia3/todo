package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

    @Bean
    fun init(repository: TodoItemRepository) = CommandLineRunner {
        repository.save(TodoItem(name = "hello"))
        repository.findAll().forEach { todoItem -> println(todoItem) }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
