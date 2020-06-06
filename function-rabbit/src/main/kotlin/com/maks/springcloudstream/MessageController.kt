package com.maks.springcloudstream

import org.springframework.http.ResponseEntity
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.EmitterProcessor

@RestController
@RequestMapping("/")
class MessageController {

    @PostMapping
    fun sendMessage(@RequestBody body: String): ResponseEntity<Unit> {
        MessageHandler.processor.onNext(MessageBuilder.withPayload(body).build())
        return ResponseEntity.ok().build()
    }
}