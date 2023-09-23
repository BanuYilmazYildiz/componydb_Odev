package com.banu.utility;

import java.sql.*;
import java.util.Optional;

public class DataBaseConnection {

    String connectionString = "jdbc:postgresql://localhost:5432/companydb";
    String username = "postgres";
    String password = "root";
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public boolean openConnection(){
        try {
            connection= DriverManager.getConnection(connectionString,username,password);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean closeConnection(){
        try {
            if (!connection.isClosed()){
                connection.close();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public PreparedStatement getPreparedStatement(String sql){
        if (openConnection()){
            try {
                preparedStatement=connection.prepareStatement(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                closeConnection();
                throw new RuntimeException(e);
            }
        }
        return preparedStatement;
    }


    public Optional<ResultSet> getAllData(String sqlSorgu){
        if(openConnection()){
            try {
                preparedStatement= connection.prepareStatement(sqlSorgu);
                resultSet = preparedStatement.executeQuery();
                closeConnection();
            } catch (SQLException e) {
                closeConnection();
            }
        }
        return Optional.ofNullable(resultSet);
    }
}
