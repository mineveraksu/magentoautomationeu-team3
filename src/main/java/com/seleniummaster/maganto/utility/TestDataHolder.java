package com.seleniummaster.maganto.utility;

public class TestDataHolder {
    private String customerGroupName;
    private String subCategoriesName;
    private String subCategoriesDescription;

    public TestDataHolder(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }
    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public TestDataHolder(String subCategoriesName, String subCategoriesDescription) {
        this.subCategoriesName = subCategoriesName;
        this.subCategoriesDescription = subCategoriesDescription;
    }

    public String getSubCategoriesName() {
        return subCategoriesName;
    }

    public String getSubCategoriesDescription() {
        return subCategoriesDescription;
    }
}
