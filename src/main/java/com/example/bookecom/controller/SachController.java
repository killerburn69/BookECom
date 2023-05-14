package com.example.bookecom.controller;

import com.example.bookecom.dtos.sach.SachDTO;
import com.example.bookecom.entities.Sach;
import com.example.bookecom.service.sach.SachService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/v1/sach")
public class SachController {
    @Autowired
    private SachService sachService;
    public SachController(SachService sachService){
        this.sachService = sachService;
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Sach> creat(@Valid @RequestBody SachDTO sachDTO, Principal principal){
        return new ResponseEntity<>(sachService.create(sachDTO,principal), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Sach> update(@PathVariable String id,@Valid @RequestBody SachDTO sachDTO, Principal principal){
        return new ResponseEntity<>(sachService.update(id,sachDTO,principal), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Sach> delete(@PathVariable String id){
        return new ResponseEntity<>(sachService.delete(id), HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @GetMapping("/filter")
    public ResponseEntity<Page<Sach>> filter(@RequestParam String search,
                                             @RequestParam int page,
                                             @RequestParam int size,
                                             @RequestParam String sort,
                                             @RequestParam String column
    ){
        return new ResponseEntity<>(sachService.filter(search, page, size, sort, column),HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<Sach>> list(@RequestParam int page,
                                           @RequestParam int size,
                                           @RequestParam String sort,
                                           @RequestParam String column){
        return new ResponseEntity<>(sachService.getList(page, size, sort, column),HttpStatus.OK);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @GetMapping("/search")
    public ResponseEntity<Page<Sach>> search(@RequestParam String search,
                                             @RequestParam int page,
                                             @RequestParam int size){
        return new ResponseEntity<>(sachService.getSachSearch(search,page,size),HttpStatus.OK);
    }
}
