package com.example.demo

import org.springframework.http.ResponseEntity
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

    @PostMapping(("/topics/{id}/delete"))
    fun deleteTopic(@PathVariable id: Int ) : String {
        topicRepository.deleteById(id)
        return "redirect:/"
    }

    @ResponseBody
    @DeleteMapping("/topics")
    fun deleteAllTopics() :ResponseEntity<String> {
        topicRepository.deleteAll()
        return ResponseEntity.noContent().build()
    }

    @PostMapping(("/topics/{id}/votes"))
    fun upvoteTopic(@PathVariable id: Int ) : String {
        var topic = topicRepository.findById(id).get()
        println("increment topic" + topic )
        topic.votes = ++topic.votes
        println(topic)
        topicRepository.save(topic)
        return "redirect:/"
    }
}