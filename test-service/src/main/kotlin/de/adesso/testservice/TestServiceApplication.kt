package de.adesso.testservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

@SpringBootApplication
@EnableDiscoveryClient
class TestServiceApplication

fun main(args: Array<String>) {
    runApplication<TestServiceApplication>(*args)
}

@RestController
class GreetingsController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting()
            = arrayOf(counter.incrementAndGet(), "Hello", "from", "spring", "service", "2", "now", "it", "is", LocalDateTime.now().toString())
}
