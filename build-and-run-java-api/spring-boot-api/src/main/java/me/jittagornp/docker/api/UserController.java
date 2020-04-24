package me.jittagornp.docker.api;

import me.jittagornp.docker.api.entity.User;
import me.jittagornp.docker.api.exception.NotFoundException;
import me.jittagornp.docker.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jitta
 */
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Flux<User> findAll() {
        return Flux.fromIterable(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable("id") Long id) {
        return Mono.just(userRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        user.setId(null);
        return Mono.just(userRepository.save(user));
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return findById(id)
                .map(u -> userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id) {
        return findById(id)
                .then(Mono.fromRunnable(() -> userRepository.deleteById(id)));
    }
}
