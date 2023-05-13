package com.example.bookecom.service.chitietnguoidung;

import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.repository.TaiKhoanRepository;
import com.example.bookecom.security.ChiTietNguoiDung;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChiTietNguoiDungService implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        TaiKhoan taiKhoan = taiKhoanRepository.findTaiKhoanByEmail(username);
        if (taiKhoan==null){
            throw new UsernameNotFoundException(username);
        }
        return new ChiTietNguoiDung(taiKhoan);
    }
}
