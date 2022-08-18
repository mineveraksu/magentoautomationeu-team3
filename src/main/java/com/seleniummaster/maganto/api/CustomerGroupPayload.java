package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerGroupPayload {
    @JsonProperty("customerGroupCode")
    private String customerGroupName;

    public CustomerGroupPayload(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }
}
