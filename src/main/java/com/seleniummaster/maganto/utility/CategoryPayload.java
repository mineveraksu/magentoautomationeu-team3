package com.seleniummaster.maganto.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryPayload {
    @JsonProperty("categoryName")
    private String categoryName;

    public CategoryPayload(String categoryName) {
        this.categoryName = categoryName;
    }
}
