package com.banu.repository;

import com.banu.repository.entity.Calisan;
import com.banu.utility.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CalisanRepository implements ICrud<Calisan> {

    private DataBaseConnection dataBaseConnection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    public CalisanRepository() {
        this.dataBaseConnection = new DataBaseConnection();
    }

    @Override
    public void save(Calisan calisan) {
        String sqlSaveQuery = "INSERT INTO calisanlar (isim,soyisim) VALUES (?,?)";

        try {
            preparedStatement = dataBaseConnection.getPreparedStatement(sqlSaveQuery);
            preparedStatement.setString(1, calisan.getAd());
            preparedStatement.setString(2, calisan.getSoyad());
            preparedStatement.executeUpdate();
            dataBaseConnection.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
