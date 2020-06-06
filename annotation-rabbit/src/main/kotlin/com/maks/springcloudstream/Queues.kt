package com.maks.springcloudstream

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface Queues {

    companion object {
        const val OUTPUT = "myOutput"
        const val INPUT = "myInput"
    }

    @Output(OUTPUT)
    fun myOutput(): MessageChannel

    @Input(INPUT)
    fun myInput(): SubscribableChannel
}