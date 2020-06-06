package com.maks.springcloudstream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
class SpringCloudStreamApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudStreamApplication>(*args)
}
