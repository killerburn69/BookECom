package com.example.bookecom;

import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.repository.TaiKhoanRepository;
import com.example.bookecom.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class BookEcomApplication implements CommandLineRunner {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    public static void main(String[] args) {
        SpringApplication.run(BookEcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(taiKhoanRepository.count()==0){
            TaiKhoan taiKhoan = new TaiKhoan("kiet", "Thu duc", "0934529859","kiet13@gmail.com","132465", Arrays.asList(EnumRole.ADMIN.name()));
            taiKhoanRepository.save(taiKhoan);
        }
    }
}
