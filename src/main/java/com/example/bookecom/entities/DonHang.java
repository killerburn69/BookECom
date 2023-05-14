package com.example.bookecom.entities;

import com.example.bookecom.entities.embeded.SanPhamDuocChon;
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
@Document(collection = "donHang")
public class DonHang {
    @Id
    private String id;
    private String maDonHang;
    private List<SanPhamDuocChon> sanPhamDuocChonList = new ArrayList<>();
    private String taiKhoan;
}
