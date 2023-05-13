package com.example.bookecom.repository;

import com.example.bookecom.entities.NhaXuatBan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface NhaXuatBanRepository extends MongoRepository<NhaXuatBan, String> {
    @Query(value = "{'maNhaXuatBan': ?0}", exists = true)
    boolean kiemTraNhaXuatBan(String maNhaXuatBan);

}
