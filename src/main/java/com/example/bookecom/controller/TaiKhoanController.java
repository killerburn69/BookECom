package com.example.bookecom.controller;

import com.example.bookecom.dtos.taikhoan.TaiKhoanDTO;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.service.taikhoan.TaiKhoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @Valid @RequestBody TaiKhoanDTO taiKhoanDTO, Principal principal){
        return new ResponseEntity<>(taiKhoanService.update(id,taiKhoanDTO,principal),HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id){
        return new ResponseEntity<>(taiKhoanService.delete(id),HttpStatus.OK);
    }
}
