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
        String name = "Pedrinho Bola";
        int number = 5462;
        double height = 1.56;
        boolean footballFan = true;
        char fbClubColor = 'R'; // Red, Blue, Green and None
        String footballClub; // Benfica, Porto, Sporting
        String footballMsg;

        if(footballFan){
            if (fbClubColor == 'R'){
                footballClub = "My favorite club is Benfica.";
            } else if (fbClubColor == 'B'){
                footballClub = "My favorite club is Porto.";
            } else if (fbClubColor == 'G'){
                footballClub = "My favorite club is Sporting.";
            } else {
                footballClub = "I don't have a favorite club.";
            }
            footballMsg = "I am a fan of football.\n" + footballClub;
        } else {
            footballMsg = "not a fan of football.";
        }

        String msg = "Done by " + name + " with number " + number + ".\nI am " + height
        + " tall and " + footballMsg;

        return msg;
    }

}
