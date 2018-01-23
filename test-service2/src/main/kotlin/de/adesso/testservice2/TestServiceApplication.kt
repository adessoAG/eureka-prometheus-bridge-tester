package de.adesso.testservice2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

@SpringBootApplication
class TestServiceApplication

fun main(args: Array<String>) {
    runApplication<TestServiceApplication>(*args)
}

@RestController
class GreetingsController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting()
            = arrayOf(counter.incrementAndGet(), "Hello", "from", "spring", "service", "2", "now", "it","is", LocalDateTime.now().toString())
}
