package pt.iade.helloworld.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Check for access to IADE
    @GetMapping(path = "/access/{student}/{covid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, 
    @PathVariable("covid") boolean hasCovid){
        logger.info("Get greeting");

        return isStudent && !hasCovid;
    }

    // Check if student should be in IADE
    // Class type can be “digital”, “presential” or “none”
    @GetMapping(path = "/required/{student}/{temperature}/{classType}", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, 
                @PathVariable("temperature") double hasCovid, 
                @PathVariable("classType") String type){
        logger.info("Ger required");

        return isStudent && type.equals("presential") && (hasCovid > 34.5 && hasCovid <37.5);
    }

    /* Check if the building needs to be evacuated
    Returns true if there is a fire or the numberOfCovids is greater them 5 
    or there is a powerShutdown and the comeBackTime is greater than 15 minutes. */
    @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}/", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getEvacuation(@PathVariable("fire") boolean isFire, 
                @PathVariable("numberOfCovids") int numCovid, 
                @PathVariable("powerShutdown") boolean isPowerDown, 
                @PathVariable("comeBackTime") int time){
        logger.info("Get evacuation");

        return isFire || (numCovid > 5) || (isPowerDown && time > 15);
    }
}
