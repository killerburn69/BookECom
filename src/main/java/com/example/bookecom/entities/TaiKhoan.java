package com.example.bookecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class TaiKhoan {
    @Id
    private String id;
    private String ten;
    private String diaChi;
    private String soDienThoai;
    private String email;
    @JsonIgnore
    private String password;
    private List<String> role =new ArrayList<>();
    public TaiKhoan(String ten, String diaChi, String soDienThoai, String email, String password, List<String> roles){
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.password = password;
        this.role = roles;
    }
}
