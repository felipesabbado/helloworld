package pt.iade.helloworld.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/java/tester")

public class JavaTestController {
    private Logger logger = LoggerFactory.getLogger(JavaTestController.class);

    @GetMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Get author");
        String name = "Felipe Campelo Sabbado";
        int number = 20191012;
        double height = 1.7;
        
        return "Name: " + name + "Número: " + number;
    }

}
