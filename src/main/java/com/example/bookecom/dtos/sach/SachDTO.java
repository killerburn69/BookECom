package com.example.bookecom.dtos.sach;

import com.example.bookecom.entities.NhaXuatBan;
import com.example.bookecom.entities.TacGia;
import com.example.bookecom.entities.embeded.ChuDe;
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
public class SachDTO {
    private String maSach;
    private String tenSach;
    private Integer soLuong;
    private Float gia;
    private String moTa;
    private List<ChuDe> chuDes = new ArrayList<>();
    private TacGia tacGia = new TacGia();
    private NhaXuatBan nhaXuatBan = new NhaXuatBan();
}
