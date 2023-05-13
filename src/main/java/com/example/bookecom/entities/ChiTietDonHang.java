package com.example.bookecom.entities;

import com.example.bookecom.entities.embeded.SanPhamDuocChon;
import com.example.bookecom.utils.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chiTietDonHang")
public class ChiTietDonHang {
    @Id
    private String id;
    private List<DonHang> donHangs = new ArrayList<>();
    private Date ngayGiaoHang;
    private EnumStatus trangThai;
}
