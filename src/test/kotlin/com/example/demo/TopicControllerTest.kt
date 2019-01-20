package com.example.demo

import com.winterbe.expekt.expect
import com.winterbe.expekt.should
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class TopicControllerTest {

    val topicRepo = mockk<TopicRepository>(relaxed = true)
    val mockMvc = MockMvcBuilders.standaloneSetup(TopicController(topicRepo)).build()

    @Test
    fun deleteAllTopics() {

        val result = mockMvc.perform(
                MockMvcRequestBuilders.delete("/topics"))
                .andReturn()

        result.response.status.should.equal(204)

        verify { topicRepo.deleteAll() }
    }
}