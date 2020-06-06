package com.maks.springcloudstream

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import java.util.function.Consumer
import java.util.function.Supplier

@Configuration
class MessageHandler {

    companion object {
        val processor: EmitterProcessor<Message<*>> = EmitterProcessor.create()
        val logger: Logger = LoggerFactory.getLogger(MessageHandler::class.java)
    }

    @Bean
    fun send(): Supplier<Flux<Message<*>>> {
        return Supplier {
            processor
        }
    }

    @Bean
    fun receive(): Consumer<String> {
        return Consumer<String> {
            logger.info(it)
        }
    }
}