package com.example.bookecom.service.tacgia;

import com.example.bookecom.dtos.tacgia.TacGiaDTO;
import com.example.bookecom.entities.TacGia;

import java.security.Principal;

public interface TacGiaService {
    TacGia create(TacGiaDTO tacGiaDTO, Principal principal);
}
