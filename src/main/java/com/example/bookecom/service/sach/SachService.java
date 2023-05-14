package com.example.bookecom.service.sach;

import com.example.bookecom.dtos.sach.SachDTO;
import com.example.bookecom.entities.Sach;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.Optional;

public interface SachService {
    Sach create(SachDTO sachDTO, Principal principal);
    Sach update(String id, SachDTO sachDTO, Principal principal);
    Sach delete(String id);
    Page<Sach> filter(String search,
                      int page, int size, String sort, String column);
    Page<Sach> getList(int page, int size, String sort, String column);

    Page<Sach> getSachSearch(String search, int pageNumber, int pageSize);
}
