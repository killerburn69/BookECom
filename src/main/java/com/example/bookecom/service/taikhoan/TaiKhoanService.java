package com.example.bookecom.service.taikhoan;

import com.example.bookecom.dtos.AccountDTO;
import com.example.bookecom.dtos.taikhoan.TaiKhoanDTO;
import com.example.bookecom.entities.TaiKhoan;

import java.security.Principal;

public interface TaiKhoanService {
    TaiKhoan creat(TaiKhoanDTO taiKhoanDTO, Principal principal);

}
