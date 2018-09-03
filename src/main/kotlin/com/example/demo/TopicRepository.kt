package com.example.demo

import org.springframework.data.repository.CrudRepository

interface TopicRepository : CrudRepository<Topic, Int>