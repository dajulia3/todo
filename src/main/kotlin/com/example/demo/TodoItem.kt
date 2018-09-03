package com.example.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TodoItem(@Id @GeneratedValue var id: Int? = null, var name: String, var done: Boolean = false){
   constructor() : this(null, "", false)
}