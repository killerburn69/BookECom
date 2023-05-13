package com.example.bookecom.dtos.chitietdonhang;

import com.example.bookecom.entities.DonHang;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.utils.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHangDTO {
    private List<DonHang> donHangs = new ArrayList<>();
    private Date ngayGiaoHang;
    private EnumStatus trangThai;
}
