package com.example.bookecom.service.taikhoan;

import com.example.bookecom.dtos.taikhoan.TaiKhoanDTO;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.repository.TaiKhoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;

@Slf4j
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Override
    public TaiKhoan creat(TaiKhoanDTO taiKhoanDTO, Principal principal) {
        if(ObjectUtils.isEmpty(taiKhoanDTO.getEmail())){
            throw new InvalidException("Tên email không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(taiKhoanDTO.getPassword())){
            throw new InvalidException("Password không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(taiKhoanDTO.getDiaChi())){
            throw new InvalidException("Địa chỉ không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(taiKhoanDTO.getTen())){
            throw new InvalidException("Tên khaách hàng không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(taiKhoanDTO.getSoDienThoai())){
            throw new InvalidException("SDT không được bỏ trống");
        }
        if(taiKhoanRepository.findByEmail(taiKhoanDTO.getEmail())!=null){
            throw new RuntimeException("Email has been exsits");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPass = passwordEncoder.encode(taiKhoanDTO.getPassword());
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setSoDienThoai(taiKhoanDTO.getSoDienThoai());
        taiKhoan.setTen(taiKhoanDTO.getTen());
        taiKhoan.setRole(taiKhoanDTO.getRole());
        taiKhoan.setDiaChi(taiKhoanDTO.getDiaChi());
        taiKhoan.setEmail(taiKhoanDTO.getEmail());
        taiKhoan.setPassword(hashPass);
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }
}
