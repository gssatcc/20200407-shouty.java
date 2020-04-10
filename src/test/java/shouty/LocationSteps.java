package shouty;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationSteps {
    @Autowired
    private ShoutyHelper shoutyHelper;

    @Given("{word} is at {coordinate}")
    public void user_is_at(String name, Coordinate coo) {
        shoutyHelper.shouty.setLocation(name, coo);
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocations) {

        for (PersonLocation personLocation: personLocations){
            shoutyHelper.shouty.setLocation(personLocation.name,
                    new Coordinate(personLocation.x, personLocation.y));
        }
    }
}
