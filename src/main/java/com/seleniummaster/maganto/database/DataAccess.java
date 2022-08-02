package com.seleniummaster.maganto.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
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

}
