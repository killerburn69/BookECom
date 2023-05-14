package com.example.bookecom.controller;

import com.example.bookecom.dtos.chitietdonhang.ChiTietDonHangDTO;
import com.example.bookecom.entities.ChiTietDonHang;
import com.example.bookecom.service.chitietdonhang.ChiTietDonHangService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/chitietdonhang")
public class ChiTietDonHangController {
    @Autowired
    private ChiTietDonHangService chiTietDonHangService;
    public ChiTietDonHangController(ChiTietDonHangService chiTietDonHangService){
        this.chiTietDonHangService=chiTietDonHangService;
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ChiTietDonHang> update(@PathVariable String id, @Valid @RequestBody ChiTietDonHangDTO chiTietDonHangDTO, Principal principal){
        return new ResponseEntity<>(chiTietDonHangService.updateTrangThai(id,chiTietDonHangDTO,principal), HttpStatus.OK);
    }
}
