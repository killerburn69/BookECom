package com.example.bookecom.controller;

import com.example.bookecom.dtos.donhang.DonHangDTO;
import com.example.bookecom.entities.DonHang;
import com.example.bookecom.service.donhang.DonHangService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/donhang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;
    public DonHangController(DonHangService donHangService){
        this.donHangService = donHangService;
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<DonHang> create(@Valid @RequestBody DonHangDTO donHangDTO, Principal principal){
        return new ResponseEntity<>(donHangService.create(donHangDTO,principal), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    public ResponseEntity<DonHang> update(@PathVariable String id, @Valid @RequestBody DonHangDTO donHangDTO, Principal principal){
        return new ResponseEntity<>(donHangService.update(id,donHangDTO,principal),HttpStatus.OK);
    }
}
