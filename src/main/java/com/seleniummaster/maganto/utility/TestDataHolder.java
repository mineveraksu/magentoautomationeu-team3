package com.seleniummaster.maganto.utility;

public class TestDataHolder {
    private String customerGroupName;
    private String subCategoriesName;
    private String subCategoriesDescription;
    private String rootCategoryName;
    private String rootCategoryDescription;


    public TestDataHolder(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }
    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public TestDataHolder(String subCategoriesName, String subCategoriesDescription,String rootCategoryName) {
        this.subCategoriesName = subCategoriesName;
        this.subCategoriesDescription = subCategoriesDescription;
        this.rootCategoryName=rootCategoryName;
    }

    public String getSubCategoriesName() {
        return subCategoriesName;
    }
    public String getSubCategoriesDescription() {
        return subCategoriesDescription;
    }

    public TestDataHolder(String rootCategoryName, String rootCategoryDescription){
        this.rootCategoryName = rootCategoryName;
        this.rootCategoryDescription = rootCategoryDescription;

    }

    public String getRootCategoryName() {
        return rootCategoryName;
    }

    public String getRootCategoryDescription() {
        return rootCategoryDescription;
    }


}
