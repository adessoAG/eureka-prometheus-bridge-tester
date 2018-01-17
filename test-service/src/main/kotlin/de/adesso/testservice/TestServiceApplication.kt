package de.adesso.testservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

@SpringBootApplication
@EnableDiscoveryClient
class TestServiceApplication

fun main(args: Array<String>) {
    runApplication<TestServiceApplication>(*args)
}

data class Greeting(val id: Long, val content: String)

@RestController
class GreetingsController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value= "name", defaultValue = "World")
                 name: String)
    = Greeting(counter.incrementAndGet(), "Hello, $name")
}

@RestController
@RequestMapping(value = "/test")
class DataController {

    @Autowired
    lateinit var dataService: DataService

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAll() = dataService.getAll()

}

@Service
class DataService {
    val counter = AtomicLong()

    fun getAll(): Array<String> {
        println("call")
        return arrayOf(counter.incrementAndGet().toString(),"Hello", "from", "spring", "service", "now", "it","is", LocalDateTime.now().toString())
    }

}
