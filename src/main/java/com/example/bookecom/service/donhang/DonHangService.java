package com.example.bookecom.service.donhang;

import com.example.bookecom.dtos.donhang.DonHangDTO;
import com.example.bookecom.entities.DonHang;

import java.security.Principal;

public interface DonHangService {
    DonHang create(DonHangDTO donHangDTO, Principal principal);
    DonHang update(String id, DonHangDTO donHangDTO, Principal principal);
}
