package com.example.bookecom.controller;

import com.example.bookecom.dtos.nhaxuatban.NhaXuatBanDTO;
import com.example.bookecom.entities.NhaXuatBan;
import com.example.bookecom.service.nhaxuatban.NhaXuatBanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/nhaxuatban")
public class NhaXuatBanController {
    @Autowired
    private NhaXuatBanService nhaXuatBanService;
    public NhaXuatBanController(NhaXuatBanService nhaXuatBanService){
        this.nhaXuatBanService = nhaXuatBanService;
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<NhaXuatBan> create(@Valid @RequestBody NhaXuatBanDTO nhaXuatBanDTO, Principal principal){
        return new ResponseEntity<>(nhaXuatBanService.create(nhaXuatBanDTO,principal), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<NhaXuatBan> update(@PathVariable String id, @Valid @RequestBody NhaXuatBanDTO nhaXuatBanDTO, Principal principal){
        return new ResponseEntity<>(nhaXuatBanService.update(id,nhaXuatBanDTO,principal),HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<NhaXuatBan> delete(@PathVariable String id){
        return new ResponseEntity<>(nhaXuatBanService.delete(id),HttpStatus.OK);
    }

}
