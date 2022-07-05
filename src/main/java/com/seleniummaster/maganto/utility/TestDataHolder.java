package com.seleniummaster.maganto.utility;

public class TestDataHolder {
    private String customerGroupName;
    private String subCategoriesName;
    private String subCategoriesDescription;
    private String rootCategoryName;
    private String rootCategoryDescription;
    private  String metaKeyWords;


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

    public TestDataHolder(String rootCategoryName, String rootCategoryDescription, String metaKeyWords) {
        this.rootCategoryName = rootCategoryName;
        this.rootCategoryDescription = rootCategoryDescription;
        this.metaKeyWords = metaKeyWords;
    }

    public String getRootCategoryName() {
        return rootCategoryName;
    }

    public String getRootCategoryDescription() {
        return rootCategoryDescription;
    }

    public String getMetaKeyWords() {
        return metaKeyWords;
    }
}
