package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.database.ConnectionManager;
import com.seleniummaster.maganto.utility.ApplicationConfig;
import io.cucumber.java.en.Given;

import java.sql.Connection;

public class DatabaseSteps {
    String configFile="config.properties";
    Connection connection;

    @Given("a user has read access to the Magento database")
    public void aUserHasReadAccessToTheMagentoDatabase() {
        String dbUrl= ApplicationConfig.readFromConfigProperties(configFile,"dburl");
        String dbPort=ApplicationConfig.readFromConfigProperties(configFile,"dbport");
        String database=ApplicationConfig.readFromConfigProperties(configFile,"dbname");
        String userName=ApplicationConfig.readFromConfigProperties(configFile,"dbusername");
        String password=ApplicationConfig.readFromConfigProperties(configFile,"dbpassword");
        connection= ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,database,userName,password);
    }
}
