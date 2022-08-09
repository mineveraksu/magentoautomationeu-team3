package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.maganto.utility.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;


public class ApiSteps {
    Response response;
    private static String baseURL;
    private static String username;
    private static String password;
    private static String configFile = "config.properties";


    @Given("user should be able to send request")
    public void userShouldBeAbleToSendRequest() {
        baseURL = ApplicationConfig.readFromConfigProperties(configFile, "api.baseurl");
        username = ApplicationConfig.readFromConfigProperties(configFile, "api.username");
        password = ApplicationConfig.readFromConfigProperties(configFile, "api.password");
    }


}
