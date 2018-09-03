package com.example.demo

import javax.persistence.*

@Entity
data class Topic(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Int? = null,
                 var title: String,
                 @Lob var description: String = "",
                 var votes: Int = 0
) {
    constructor() : this(id = null, title = "", description = "", votes=0)
}