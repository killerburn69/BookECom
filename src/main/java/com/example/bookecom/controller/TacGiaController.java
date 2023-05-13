package com.example.bookecom.controller;

import com.example.bookecom.dtos.tacgia.TacGiaDTO;
import com.example.bookecom.entities.TacGia;
import com.example.bookecom.service.tacgia.TacGiaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/tacgia")
public class TacGiaController {
    @Autowired
    private TacGiaService tacGiaService;
    public TacGiaController(TacGiaService tacGiaService){
        this.tacGiaService = tacGiaService;
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<TacGia> create(@Valid @RequestBody TacGiaDTO tacGiaDTO, Principal principal){
        return new ResponseEntity<>(tacGiaService.create(tacGiaDTO,principal), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TacGia> update(@PathVariable String id, @Valid @RequestBody TacGiaDTO tacGiaDTO, Principal principal){
        return new ResponseEntity<>(tacGiaService.update(id,tacGiaDTO,principal),HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<TacGia> delete(@PathVariable String id){
        return new ResponseEntity<>(tacGiaService.delete(id),HttpStatus.OK);
    }
}
