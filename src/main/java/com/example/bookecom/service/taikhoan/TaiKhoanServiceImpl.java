package com.example.bookecom.service.taikhoan;

import com.example.bookecom.dtos.taikhoan.TaiKhoanDTO;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.exception.NotFoundException;
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
            throw new RuntimeException("Email đã có");
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

    @Override
    public TaiKhoan update(String id, TaiKhoanDTO taiKhoanDTO, Principal principal) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
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
            throw new RuntimeException("Email đã có");
        }
        if(taiKhoan.getEmail().equalsIgnoreCase(taiKhoanDTO.getEmail())){
            throw new RuntimeException("Email đã có");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPass = passwordEncoder.encode(taiKhoanDTO.getPassword());
        taiKhoan.setSoDienThoai(taiKhoanDTO.getSoDienThoai());
        taiKhoan.setTen(taiKhoanDTO.getTen());
        taiKhoan.setRole(taiKhoanDTO.getRole());
        taiKhoan.setDiaChi(taiKhoanDTO.getDiaChi());
        taiKhoan.setEmail(taiKhoanDTO.getEmail());
        taiKhoan.setPassword(hashPass);
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan delete(String id) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        taiKhoanRepository.delete(taiKhoan);
        return taiKhoan;
    }
    private TaiKhoan getTaiKhoan(String id){
        return taiKhoanRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Email nay đã đăng ký",id)));
    }
}
