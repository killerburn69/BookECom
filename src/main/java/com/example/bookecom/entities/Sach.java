package com.example.bookecom.entities;

import com.example.bookecom.entities.embeded.ChuDe;
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
@Document(collection = "sach")
public class Sach {
    @Id
    private String id;
    //Ma sach khong duoc trung
    private String maSach;
    private String tenSach;
    private Integer soLuong;
    private Float gia;
    private String moTa;
    private List<ChuDe> chuDes = new ArrayList<>();
    private TacGia tacGia = new TacGia();
    private NhaXuatBan nhaXuatBan = new NhaXuatBan();
}
