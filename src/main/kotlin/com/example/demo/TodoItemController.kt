package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestParam


@Controller
class TodoItemController(val todoItemRepository: TodoItemRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("todoItems", todoItemRepository.findAll())
        model.addAttribute("createTodoItem", TodoItem())
        return "todoItem.html"
    }

    @PostMapping("/")
    fun saveTodoItem(@ModelAttribute todoItem: TodoItem) : String {
        todoItemRepository.save(todoItem)
        return "redirect:/"
    }

    @GetMapping("/todo/{id}")
    fun editTodoItem(@ModelAttribute todoItem: TodoItem, @RequestParam id: Int, model: Model) : String {
        val todoItem = todoItemRepository.findById(id)
        model.addAttribute("editTodoItem", todoItem)
        return "editTodoItem.html"
    }
}