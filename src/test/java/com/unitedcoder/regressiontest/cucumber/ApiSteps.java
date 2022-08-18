package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import com.seleniummaster.maganto.utility.PayloadUtility;
import com.seleniummaster.maganto.utility.TestDataHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;


public class ApiSteps {
    Response response;
    private static String baseURL;
    private static String username;
    private static String password;
    private static String configFile = "config.properties";

    @Given("authorization and base url")
    public void authorizationAndBaseUrl() {
        baseURL = ApplicationConfig.readFromConfigProperties(configFile, "api.baseurl");
        username = ApplicationConfig.readFromConfigProperties(configFile, "api.username");
        password = ApplicationConfig.readFromConfigProperties(configFile, "api.password");
    }

    @When("user should be able to send post request for creating a {string}")
    public void userShouldBeAbleToSendPostRequestForCreatingA(String arg0) {
        response = given().headers("Content-Type", "application/json").and().body(PayloadUtility.getCustomerGroupPayload(arg0))
                .auth().basic(username, password)
                .when().post(baseURL + "/customergroup");
        response.getBody().prettyPrint();
        TestDataHolder.setCustomerGroupID(response.jsonPath().getString("id"));
    }

    @Then("a new {string} should be created")
    public void aNewShouldBeCreated(String arg0) {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("customerGroupCode").contains(arg0));
    }

    @When("user should be able to send put request for updating a {string}")
    public void userShouldBeAbleToSendPutRequestForUpdatingA(String arg0) {
        response = given().headers("Content-Type", "application/json").and().body(PayloadUtility.getCustomerGroupPayload(arg0))
                .auth().basic(username, password)
                .when().put(baseURL + "/customergroup/"+TestDataHolder.getCustomerGroupID());
        response.getBody().prettyPrint();
    }

    @Then("a customer group should be updated")
    public void aCustomerGroupShouldBeUpdated() {
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    //Post,Get and Put one category
    @When("user should be able to send post request for creating one {string}")
    public void userShouldBeAbleToSendPostRequestForCreatingOne(String arg0) {
        response = given().headers("Content-Type", "application/json").and().body(PayloadUtility.getCategoryPayload(arg0))
                .auth().basic(username, password)
                .when().post(baseURL + "/category");
        response.getBody().prettyPrint();
        TestDataHolder.setCategoryID(response.jsonPath().getString("id"));
    }

    @Then("user should be created a new {string}")
    public void userShouldBeCreatedANew(String arg0) {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getString("categoryName").contains(arg0));
    }

    @When("user should be able to send request for get specific information one {string}")
    public void userShouldBeAbleToSendRequestForGetSpecificInformationOne(String arg0) {
        response = given().headers("Content-Type", "application/json").and().body(PayloadUtility.getCategoryPayload(arg0))
                .auth().basic(username, password)
                .when().get(baseURL + "/category/"+TestDataHolder.getCategoryID());
        response.getBody().prettyPrint();
    }

    @Then("user should be get information about the category")
    public void userShouldBeGetInformationAboutTheCategory() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("user should be able to send put request for updating one {string}")
    public void userShouldBeAbleToSendPutRequestForUpdatingOne(String arg0) {
        response = given().headers("Content-Type", "application/json").and().body(PayloadUtility.getCategoryPayload(arg0))
                .auth().basic(username, password)
                .when().put(baseURL + "/category/"+TestDataHolder.getCategoryID());
        response.getBody().prettyPrint();
    }

    @Then("one category should be updated")
    public void oneCategoryShouldBeUpdated() {
        Assert.assertEquals(response.getStatusCode(), 204);
    }

}
