package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {





    @JsonProperty("sku")

    private int attributeSetId;
    private int entityTypeId;
    private String sku;
    private String typeId;


    public ProductPayload( int attributeSetId ,int entityTypeId, String sku, String typeId ) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
    }

}
