package me.jittagornp.docker.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@RestController
public class HelloWorldController {

    @GetMapping({"", "/"})
    public Mono<String> helloWorld() {
        return Mono.just("Hello from Spring-boot-hello-world");
    }

}
