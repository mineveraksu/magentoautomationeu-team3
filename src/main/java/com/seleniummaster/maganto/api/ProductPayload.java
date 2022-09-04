package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {





    @JsonProperty("attributeSetId")
    private int attributeSetId;
    @JsonProperty("entityTypeId")
    private int entityTypeId;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("typeId")
    private String typeId;


    public ProductPayload( int attributeSetId ,int entityTypeId, String sku, String typeId ) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
    }

}
