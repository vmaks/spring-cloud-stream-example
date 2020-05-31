package com.maks.springcloudstream

import org.apache.http.client.methods.RequestBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MessageController(private val queues: Queues) {

    @PostMapping
    fun sendMessage(@RequestBody body: String): ResponseEntity<Unit> {
        queues.myOutput().send(MessageBuilder.withPayload(body).build())
        return ResponseEntity.ok().build()
    }
}