package com.example.bookecom.service.chitietdonhang;

import com.example.bookecom.dtos.chitietdonhang.ChiTietDonHangDTO;
import com.example.bookecom.entities.ChiTietDonHang;

import java.security.Principal;

public interface ChiTietDonHangService {
    ChiTietDonHang updateTrangThai(String id, ChiTietDonHangDTO donHangDTO, Principal principal);
}
