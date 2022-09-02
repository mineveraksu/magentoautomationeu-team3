package com.seleniummaster.maganto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {





    @JsonProperty("sku")
    private int entityTypeId;
    private int attributeSetId;
    private String typeId;
    private String sku;

    public ProductPayload(int entityTypeId, int attributeSetId, String typeId, String sku) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
    }
    //    public ProductPayload(String entityTypeId,String attributeSetId,String typeId,String sku){
//
//    }
}
