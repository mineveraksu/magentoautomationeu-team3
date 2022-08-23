package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryPayload {
    @JsonProperty("value")
    private String categoryName;

    public CategoryPayload(String categoryName) {
        this.categoryName = categoryName;
    }
}
