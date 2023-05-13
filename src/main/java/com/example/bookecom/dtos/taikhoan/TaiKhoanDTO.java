package com.example.bookecom.dtos.taikhoan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDTO {
    private String ten;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String password;
    private List<String> role =new ArrayList<>();
}
