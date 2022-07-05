package com.seleniummaster.maganto.utility;

public class TestDataHolder {
    private String customerGroupName;
    private String rootCategoryName;
    private String getRootCategoryDescription;

    public TestDataHolder(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }
    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public TestDataHolder(String rootCategoryName, String getRootCategoryDescription) {
        this.rootCategoryName = rootCategoryName;
        this.getRootCategoryDescription = getRootCategoryDescription;
    }

    public String getRootCategoryName() {
        return rootCategoryName;
    }

    public String getGetRootCategoryDescription() {
        return getRootCategoryDescription;
    }
}
