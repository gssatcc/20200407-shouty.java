package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void person_is_at(String personName, int xCoord, int yCoord) {
        shouty.setLocation(personName, new Coordinate(xCoord, yCoord));
    }

    @When("{word} shouts")
    public void person_shouts(String personName) {
        shouty.shout(personName, ARBITRARY_MESSAGE);
    }

    @Then("Lucy should hear Sean")
    public void lucy_should_hear_sean() {

        assertTrue(shouty.getShoutsHeardBy("Lucy").containsKey("Sean"));
    }

    @Then("{word} should not hear {word}")
    public void listener_should_not_hear_shouter(String listenr, String shouter) {

        assertFalse(shouty.getShoutsHeardBy(listenr).containsKey(shouter));
    }

    @Then("Lucy should hear nothing")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> aa) {

        for (int i = 0; i < aa.size(); i++) {
            String name = aa.get(i).name;
            int xCoord = aa.get(i).x;
            int yCoord =  aa.get(i).y;
            shouty.setLocation(name, new Coordinate(xCoord, yCoord));
        }
    }
}
