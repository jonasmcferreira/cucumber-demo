package com.jonas;

import com.jonas.helper.ApiHelper;
import com.jonas.helper.DatabaseHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class requestsStepdefs {

    private DatabaseHelper databaseHelper;
    private ApiHelper apiHelper;

    public requestsStepdefs(DatabaseHelper databaseHelper, ApiHelper apiHelper){
        this.databaseHelper = databaseHelper;
        this.apiHelper = apiHelper;
    }

    @Given("I have an empty database")
    public void anEmptyDatabase() {
        databaseHelper.clearDatabase();
    }

    @When("I make a (.*) request to the API")
    public void iMakeAValidRequestToTheAPI(String type) {
        if(type.equals("valid")){
            apiHelper.setStatusCode(200);
            databaseHelper.put("something", "something");
        } else {
            apiHelper.setStatusCode(500);
        }

    }

    @Then("I receive a status of {int}")
    public void iReceiveAStatusOf(int arg0) {
        assertEquals(arg0, apiHelper.getStatusCode());
    }

    @Then("I have an entry in the database")
    public void iHaveAnEntryInTheDatabase() {
        assertNotEquals(0, databaseHelper.sizeOf());
    }

    @And("the database has <entries>")
    public void theDatabaseHasEntries() {

    }
}
