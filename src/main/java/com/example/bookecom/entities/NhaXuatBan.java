package com.example.bookecom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "nhaxuatban")
public class NhaXuatBan {
    @Id
    private String id;
    private String maNhaXuatBan;
    private String tenNhaXuatBan;
    private String diaChi;
    private String dienThoai;
}
