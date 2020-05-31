package com.maks.springcloudstream

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service

@Service
class MessageHandler {

    val logger: Logger = LoggerFactory.getLogger(MessageHandler::class.java)

    @StreamListener(Queues.INPUT)
    fun receive(message: String) {
        logger.info(message)
    }
}