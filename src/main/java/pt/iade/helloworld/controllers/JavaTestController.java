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

    // Boolean operations
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
    @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getEvacuation(@PathVariable("fire") boolean isFire, 
                @PathVariable("numberOfCovids") int numCovid, 
                @PathVariable("powerShutdown") boolean isPowerDown, 
                @PathVariable("comeBackTime") int time){
        logger.info("Get evacuation");

        return isFire || (numCovid > 5) || (isPowerDown && time > 15);
    }

    // Arrays, conditionals and loops
    private final double GRADES[] = {16.5, 18, 14.5, 19, 15.5, 17.5};
    private final String UCS[] = {"BD", "CC", "MD", "POO", "DM", "PDM"};

    // Calculate and return the average
    @GetMapping(path = "/average", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getAverage(){
        logger.info("Get average");
        double sum = 0;
        for (double grade: GRADES) {
            sum += grade;
        }
        double average = sum/GRADES.length;

        return average;
    }

    // Return the maximum grade
    @GetMapping(path = "/maximumGrade", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getMaximumGrade(){
        logger.info("Get maximum grade");
        double maximum = 0;
        for (double grade: GRADES) {
            if (grade > maximum){
                maximum = grade;
            }
        }

        return maximum;
    }

    // Given the name of the UC return the grade
    @GetMapping(path = "/grade/{ucName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGrade(@PathVariable("ucName") String ucName){
        logger.info("Get grade");
        int index = -1;
        String msg = null;
        for (int i = 0; i < UCS.length; i++) {
            if (ucName.equals(UCS[i])){
                index = i;
            }

        if (index == -1){
            msg = "You don't have this UC";
        } else {
            msg = String.format("Your grade for %s is %.1f.", ucName, GRADES[index]);
            }
        }

        return msg;
    }

    // Given minimum and maximum grade, return how many UCs have grades in those limits

    // Return a string with a text with all UC names and grades
}
