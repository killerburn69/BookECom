package com.example.bookecom.repository;

import com.example.bookecom.entities.DonHang;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DonHangRepository extends MongoRepository<DonHang, String> {
    @Query(value = "{'maDonHang': ?0}", exists = true)
    boolean kiemTraMaDonHang(String maDonHang);

}
