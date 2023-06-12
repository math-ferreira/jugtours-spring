package com.okta.developer.jugtours;

import com.okta.developer.jugtours.model.Event;
import com.okta.developer.jugtours.model.Group;
import com.okta.developer.jugtours.model.User;
import com.okta.developer.jugtours.model.repository.GroupRepository;
import com.okta.developer.jugtours.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) {
        Stream.of("Omaha JUG", "Kansas City JUG", "Chicago JUG",
                        "Dallas JUG", "Philly JUG", "Garden State JUG", "NY Java SIG")
                .forEach(name -> groupRepository.save(new Group(name)));

        Group jug = groupRepository.findByName("Garden State JUG");
        Event e = new Event(Instant.parse("2023-10-18T18:00:00.000Z"),
                "OAuth for Java Developers", "Learn all about OAuth and OIDC + Java!");
        jug.setEvents(Collections.singleton(e));
        groupRepository.save(jug);

        User user1 = new User("Matheus", "mat.s.ferreira@gmail.com");
        User user2 = new User("Maysa", "pradom@gmail.com");
        User user3 = new User("Antonio", "ferreiramiron@hotmail.com.br");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        groupRepository.findAll().forEach(System.out::println);
    }
}