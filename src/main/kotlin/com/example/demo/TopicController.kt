package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
class TopicController(val topicRepository: TopicRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("topics", topicRepository.findAll())
        return "Topics.html"
    }

    @PostMapping("/topic")
    fun saveTopic(@ModelAttribute topic: Topic) : String {
        topicRepository.save(topic)
        return "redirect:/"
    }

    @GetMapping("/new-topic")
    fun newTopic(model: Model) : String {
        model.addAttribute("title", "Create a new topic")
        model.addAttribute("topic", Topic())
        return "TopicForm.html"
    }

    @GetMapping("/topics/{id}/edit")
    fun editTopic(@PathVariable id: Int, model: Model) : String {
        model.addAttribute("title", "Edit Topic")
        val topic = topicRepository.findById(id)
        model.addAttribute("topic", topic)
        return "TopicForm.html"
    }
}