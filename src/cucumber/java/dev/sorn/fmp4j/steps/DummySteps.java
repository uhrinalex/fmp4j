package dev.sorn.fmp4j.steps;

import dev.sorn.fmp4j.Dummy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummySteps {
    private Dummy dummy;
    private String name;

    @Given("a dummy object with name {string}")
    public void aDummyObjectWithNameName(String arg0) {
        dummy = new Dummy(arg0);
    }

    @When("I get the name")
    public void iGetTheName() {
        this.name = dummy.name();
    }

    @Then("the name should be {string}")
    public void theNameShouldBe(String arg0) {
        assertEquals(arg0, name);
    }
}