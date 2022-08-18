package com.seleniummaster.maganto.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryPayload {
    @JsonProperty("value")
    private String categoryName;

    public CategoryPayload(String categoryName) {
        this.categoryName = categoryName;
    }
}
