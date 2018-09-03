package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestParam


@Controller
class TopicController(val topicRepository: TopicRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("topics", topicRepository.findAll())
        return "Topics.html"
    }

    
}