package com.example.bookecom.service.chitietdonhang;

import com.example.bookecom.dtos.chitietdonhang.ChiTietDonHangDTO;
import com.example.bookecom.entities.ChiTietDonHang;
import com.example.bookecom.exception.NotFoundException;
import com.example.bookecom.repository.ChiTietDonHangRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Slf4j
@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;
    @Override
    public ChiTietDonHang updateTrangThai(String id, ChiTietDonHangDTO donHangDTO, Principal principal) {
        ChiTietDonHang chiTietDonHang = getChiTietDonHang(id);
        chiTietDonHang.setTrangThai(donHangDTO.getTrangThai());
        chiTietDonHangRepository.save(chiTietDonHang);
        return chiTietDonHang;
    }
    private ChiTietDonHang getChiTietDonHang(String id){
        return chiTietDonHangRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Chi tiet Don Hnagf nay Hienj khong có",id)));
    }
}
