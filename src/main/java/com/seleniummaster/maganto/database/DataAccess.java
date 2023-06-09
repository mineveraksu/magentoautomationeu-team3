package com.seleniummaster.maganto.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    // getNewlyRegisteredUser Method
    public boolean getNewlyRegisteredUser(String userEmail, Connection connection){
        boolean isUserExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String newlyRegisteredUserSqlScript=String.format("select entity_id,email from mg_customer_entity where email='%s'",userEmail);
        try {
            resultSet=statement.executeQuery(newlyRegisteredUserSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isUserExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int entity_id = cachedRowSet.getInt("entity_id");
                    String email = cachedRowSet.getString("email");
                    System.out.println(String.format("entity_id=%d email=%s",entity_id,email));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isUserExist=true;
            return isUserExist;
        }
    }
    //getCustomerGroup Method
    public boolean getCustomerGroup(String customerGroupName, Connection connection){
        boolean isCustomerGroupExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String customerGroupSqlScript=String.format("select customer_group_code,customer_group_id from mg_customer_group where customer_group_code='%s';",customerGroupName);
        try {
            resultSet=statement.executeQuery(customerGroupSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isCustomerGroupExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int groupId = cachedRowSet.getInt("customer_group_id");
                    String groupName = cachedRowSet.getString("customer_group_code");
                    System.out.println(String.format("customer_group_id=%d customer_group_code=%s",groupId,groupName));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isCustomerGroupExist=true;
            return isCustomerGroupExist;
        }
    }
    // getCreditMemo Method
    public boolean getAddedCreditMemo(String creditmemo_id, Connection connection){
        boolean isUserExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String getAddedCreditMemoScript=String.format("select grand_total,increment_id from  mg_sales_flat_creditmemo where increment_id=%s",creditmemo_id);
        try {
            resultSet=statement.executeQuery(getAddedCreditMemoScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isUserExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String increment_id = cachedRowSet.getString("increment_id");
                    String grand_total=cachedRowSet.getString("grand_total");
                    System.out.println(String.format("increment_id=%s grand_total=%s",increment_id,grand_total));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isUserExist=true;
            return isUserExist;
        }
    }

    //getSubCategories Method
    public boolean getSubCategories(int subCategoriesID, Connection connection){
        boolean isSubCategoriesExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String subCategoriesSqlScript=String.format("select entity_id,parent_id from mg_catalog_category_entity where entity_id=%d;",subCategoriesID);
        try {
            resultSet=statement.executeQuery(subCategoriesSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isSubCategoriesExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int entity_id = cachedRowSet.getInt("entity_id");
                    int parent_id=cachedRowSet.getInt("parent_id");
                    System.out.println(String.format("entity_id=%d,parent_id=%d",entity_id,parent_id));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isSubCategoriesExist=true;
            return isSubCategoriesExist;
        }
    }
    //getTaxRule Method
    public boolean getTaxRule(String taxRuleCode, Connection connection){
        boolean isTaxRuleExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String taxRuleSqlScript=String.format("select tax_calculation_rule_id,code from mg_tax_calculation_rule where code='%s';",taxRuleCode);
        try {
            resultSet=statement.executeQuery(taxRuleSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isTaxRuleExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int taxCalculationRuleId = cachedRowSet.getInt("tax_calculation_rule_id");
                    String code = cachedRowSet.getString("code");
                    System.out.println(String.format("taxCalculationRuleId=%d code=%s",taxCalculationRuleId,code));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isTaxRuleExist=true;
            return isTaxRuleExist;
        }
    }

    public boolean getNewlyAddedRefunds(double refunded, Connection connection){
        boolean isRefundExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String newlyCreatedRefundSqlScript=String.format("select id,refunded from mg_sales_refunded_aggregated where refunded=%.2f",refunded);
        //for quire
        try {
            resultSet=statement.executeQuery(newlyCreatedRefundSqlScript);//for execute icon
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("No records found");
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {

                    //int period = cachedRowSet.getInt("period");
                    int id=cachedRowSet.getInt("id");
                    double refunded1=cachedRowSet.getDouble("refunded");
                    System.out.println(String.format("id=%d refunded=%.2f",id,refunded1));
                    count = cachedRowSet.getRow();
                    System.out.println(count);

                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

            if(count>=1)
                isRefundExist=true;
        }
        return isRefundExist;
    }



    //get new  added stock

    public boolean getStock(int productID, Connection connection){
        boolean isStockExist=false;
        Statement statement=null;
        ResultSet resultSet=null;
        CachedRowSet cachedRowSet=null;

        try {
            cachedRowSet= RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String stockSqlScript=String.format("select product_id,qty from mg_cataloginventory_stock_item where product_id=%d;",productID);
        try {
            resultSet=statement.executeQuery(stockSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resultSet==null){
            System.out.println("no records found");
            return isStockExist;
        }else{
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count=0;
            while (true){
                try {
                    if(!cachedRowSet.next()){
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int product_id  = cachedRowSet.getInt("product_id");
                    double qty =cachedRowSet.getDouble("qty");
                    System.out.println(String.format("product_id=%d,qty=%.2f",product_id,qty));
                    count = cachedRowSet.getRow();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(count>=1)
                isStockExist=true;
            return isStockExist;
        }
    }
    //get cart price rule
    public boolean getCartPriceRule(String ruleId,Connection connection) {
        boolean isCartPriceRuleExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String cartPriceRuleSqlScript = String.format("select rule_id,name from mg_salesrule where rule_id=%s", ruleId);
        try {
            resultSet = statement.executeQuery(cartPriceRuleSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //verify  cart price rule
        if (resultSet == null) {
            System.out.println("No records Found");
            return isCartPriceRuleExist;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int rule_id = cachedRowSet.getInt("rule_id");
                    String rule_name = cachedRowSet.getString("name");
                    System.out.println(String.format("rule_id=%d name=%s", rule_id, rule_name));
                    count = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (count >= 1)
                isCartPriceRuleExist = true;
            return isCartPriceRuleExist;

        }

    }

    //Get newly added customer on the database
    public boolean getNewlyAddedCustomer(String customerEmail, Connection connection) {
        boolean isUserExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String newlyRegisteredUserSqlScript = String.format("select entity_id,email from mg_customer_entity where email='%s'",customerEmail);
        try {
            resultSet = statement.executeQuery(newlyRegisteredUserSqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSet == null) {
            System.out.println("no records found");
            return isUserExist;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int entity_id = cachedRowSet.getInt("entity_id");
                    String email = cachedRowSet.getString("email");
                    System.out.println(String.format("entity_id=%d email=%s", entity_id, email));
                    count = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (count >= 1)
                isUserExist = true;
            return isUserExist;
        }

    }


}
