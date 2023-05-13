package com.example.bookecom.controller;

import com.example.bookecom.dtos.tacgia.TacGiaDTO;
import com.example.bookecom.entities.TacGia;
import com.example.bookecom.service.tacgia.TacGiaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/tacgia")
public class TacGiaController {
    @Autowired
    private TacGiaService tacGiaService;
    public TacGiaController(TacGiaService tacGiaService){
        this.tacGiaService = tacGiaService;
    }
//    @SecurityRequirement(name = "Bearer Authentication")
//    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TacGia> create(TacGiaDTO tacGiaDTO, Principal principal){
        return new ResponseEntity<>(tacGiaService.create(tacGiaDTO,principal), HttpStatus.OK);
    }
}
