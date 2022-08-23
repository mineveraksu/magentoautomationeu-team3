package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {
    @JsonProperty("attribute_id")
    private int attribute_id;
    @JsonProperty("entity_id")
    private int entity_id;
   @JsonProperty("entity_type_id")
    private int entity_type_id;
    @JsonProperty("id")
    private int id;
    @JsonProperty("value")
    private String value;

    public CustomerPayload(int attribute_id, int entity_id, int entity_type_id, int id, String value) {
        this.attribute_id = attribute_id;
        this.entity_id = entity_id;
        this.entity_type_id = entity_type_id;
        this.id = id;
        this.value = value;
    }
}
