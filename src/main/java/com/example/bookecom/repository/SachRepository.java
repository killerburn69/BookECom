package com.example.bookecom.repository;

import com.example.bookecom.entities.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SachRepository extends MongoRepository<Sach,String> {
    @Query(value = "{'maSach': ?0}", exists = true)
    boolean kiemTraMaSach(String maSach);
    @Query(value = "{$or: [ {'tenSach': ?0}, {'tacGia': ?0}, {'nhaXuatBan': ?0}]}",
            sort = "{'gia': -1}")
    Page<Sach> filter(String search, Pageable pageable);
//    Page<Sach> findAll(Pageable pageable);
    @Query(value = "{'tenSach': {$regex: ?0}}")
    Page<Sach> getSachSearch(String tenSach, Pageable pageable);

}
