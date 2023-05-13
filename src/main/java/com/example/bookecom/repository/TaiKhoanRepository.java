package com.example.bookecom.repository;

import com.example.bookecom.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {
    TaiKhoan findTaiKhoanByEmail(String email);
    @Query(value = "{'email': ?0}")
    Optional<TaiKhoan> getUser(String email);
    TaiKhoan findByEmail(String email);
}
