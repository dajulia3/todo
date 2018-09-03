package com.example.demo

import org.springframework.data.repository.CrudRepository

interface TodoItemRepository : CrudRepository<TodoItem, Int>