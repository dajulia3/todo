package com.example.demo

import javax.persistence.*

@Entity
data class Topic(@Id @GeneratedValue var id: Int? = null, var title: String, @Lob var description: String = ""){
   constructor() : this(id= null, title="", description = "")
}