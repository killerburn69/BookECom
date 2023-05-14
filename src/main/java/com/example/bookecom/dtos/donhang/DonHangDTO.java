package com.example.bookecom.dtos.donhang;

import com.example.bookecom.entities.embeded.SanPhamDuocChon;
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
public class DonHangDTO {
    private String maDonHang;
    private List<SanPhamDuocChon> sanPhamDuocChonList = new ArrayList<>();
    private String taiKhoan;
}
