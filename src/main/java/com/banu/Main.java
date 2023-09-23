package com.banu;

import com.banu.repository.CalisanRepository;
import com.banu.repository.entity.Calisan;

public class Main {
    public static void main(String[] args) {
        CalisanRepository calisanRepository = new CalisanRepository();
        calisanRepository.save(new Calisan("Selin","Zandolu"));
    }
}