package com.seleniummaster.maganto.utility;

public class TestDataHolder {
    private String customerGroupName;
    private String subCategoriesName;
    private String subCategoriesDescription;
    private String rootCategoryName;
    private String rootCategoryDescription;
    private String attributeCode;
    private String adminName;
    private String websiteName;
    private String websiteCode;
    private String storeName;
    private String startDate;
    private String endDate;



    @Override
    public String toString() {
        return "TestDataHolder{" +
                "customerGroupName='" + customerGroupName + '\'' +
                '}';
    }

    public TestDataHolder() {
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public TestDataHolder(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }

    public TestDataHolder(String rootCategoryName, String rootCategoryDescription){
        this.rootCategoryName = rootCategoryName;
        this.rootCategoryDescription = rootCategoryDescription;
    }

    public TestDataHolder(String subCategoriesName, String subCategoriesDescription,String rootCategoryName) {
        this.subCategoriesName = subCategoriesName;
        this.subCategoriesDescription = subCategoriesDescription;
        this.rootCategoryName=rootCategoryName;
    }
    public String getNewRootCategoryDescription() {
        return newRootCategoryDescription;
    }

    private String newRootCategoryDescription;

    public String getCustomerGroupName() {
        return customerGroupName;
    }
    public String getSubCategoriesName() {
        return subCategoriesName;
    }
    public String getSubCategoriesDescription() {
        return subCategoriesDescription;
    }
    public String getRootCategoryName() {
        return rootCategoryName;
    }
    public String getRootCategoryDescription() {
        return rootCategoryDescription;
    }
    public String getattributeCode() {return attributeCode;}
    public String getadminName() {return adminName;}

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public void setWebsiteCode(String websiteCode) {
        this.websiteCode = websiteCode;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getWebsiteCode() {
        return websiteCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
