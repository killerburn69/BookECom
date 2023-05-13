package com.example.bookecom.controller;

import com.example.bookecom.dtos.taikhoan.TaiKhoanDTO;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.service.taikhoan.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/user")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    public TaiKhoanController(TaiKhoanService taiKhoanService){
        this.taiKhoanService = taiKhoanService;
    }
    @PostMapping
    public ResponseEntity<TaiKhoan> create(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO, Principal principal){
        return new ResponseEntity<>(taiKhoanService.creat(taiKhoanDTO,principal), HttpStatus.OK);
    }
}
