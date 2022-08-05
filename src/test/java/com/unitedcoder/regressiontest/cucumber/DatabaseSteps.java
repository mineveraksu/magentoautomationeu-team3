package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.database.ConnectionManager;
import com.seleniummaster.maganto.database.DataAccess;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.Connection;

public class DatabaseSteps extends ConnectionManager {
    String configFile="config.properties";
    Connection connection;
    DataAccess dataAccess;
    boolean isUserExist;

    @Given("a user has read access to the Magento database")
    public void aUserHasReadAccessToTheMagentoDatabase() {
        connection= connectToDatabaseServer();
        dataAccess=new DataAccess();
    }

    @When("the user query the mg_customer_entity table")
    public void theUserQueryTheMg_customer_entityTable() {
        String userEmail=ApplicationConfig.readFromConfigProperties(configFile,"email");
        isUserExist=dataAccess.getNewlyRegisteredUser(userEmail,connection);
    }

    @Then("the user should see the newly registered user info")
    public void theUserShouldSeeTheNewlyRegisteredUserInfo() {
        Assert.assertTrue(isUserExist);
    }

    @After("@DatabaseTest")
    public void tearDown(){
        closeDatabaseConnection(connection);
    }
}
