package com.example.bookecom.repository;

import com.example.bookecom.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {
    TaiKhoan findTaiKhoanByEmail(String email);

    TaiKhoan findByEmail(String email);
}
