package com.example.bookecom.service.nhaxuatban;

import com.example.bookecom.dtos.nhaxuatban.NhaXuatBanDTO;
import com.example.bookecom.entities.NhaXuatBan;

import java.security.Principal;

public interface NhaXuatBanService {
    NhaXuatBan create(NhaXuatBanDTO nhaXuatBanDTO, Principal principal);
    NhaXuatBan update(String id, NhaXuatBanDTO nhaXuatBanDTO, Principal principal);
    NhaXuatBan delete(String id);

}
