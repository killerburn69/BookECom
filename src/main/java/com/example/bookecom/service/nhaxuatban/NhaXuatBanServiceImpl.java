package com.example.bookecom.service.nhaxuatban;

import com.example.bookecom.dtos.nhaxuatban.NhaXuatBanDTO;
import com.example.bookecom.entities.NhaXuatBan;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.exception.NotFoundException;
import com.example.bookecom.repository.NhaXuatBanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
@Slf4j
@Service
public class NhaXuatBanServiceImpl implements NhaXuatBanService{
    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;
    @Override
    public NhaXuatBan create(NhaXuatBanDTO nhaXuatBanDTO, Principal principal) {
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getMaNhaXuatBan())){
            throw new InvalidException("Mã nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getTenNhaXuatBan())){
            throw new InvalidException("Tên nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getDiaChi())){
            throw new InvalidException("Địa chỉ nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getDienThoai())){
            throw new InvalidException("So điện thoại không được bỏ trong");
        }
        if(nhaXuatBanRepository.kiemTraNhaXuatBan(nhaXuatBanDTO.getMaNhaXuatBan())){
            throw new InvalidException("Mã nhà xuất bản này đã có rồi");
        }
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.setMaNhaXuatBan(nhaXuatBanDTO.getMaNhaXuatBan());
        nhaXuatBan.setTenNhaXuatBan(nhaXuatBanDTO.getTenNhaXuatBan());
        nhaXuatBan.setDiaChi(nhaXuatBanDTO.getDiaChi());
        nhaXuatBan.setDienThoai(nhaXuatBanDTO.getDienThoai());
        nhaXuatBanRepository.save(nhaXuatBan);
        return nhaXuatBan;
    }

    @Override
    public NhaXuatBan update(String id, NhaXuatBanDTO nhaXuatBanDTO, Principal principal) {
        NhaXuatBan nhaXuatBan = getNhaXuatBan(id);
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getMaNhaXuatBan())){
            throw new InvalidException("Mã nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getTenNhaXuatBan())){
            throw new InvalidException("Tên nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getDiaChi())){
            throw new InvalidException("Địa chỉ nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(nhaXuatBanDTO.getDienThoai())){
            throw new InvalidException("So điện thoại không được bỏ trong");
        }
        if(nhaXuatBan.getMaNhaXuatBan().equalsIgnoreCase(nhaXuatBanDTO.getMaNhaXuatBan())){
            throw new InvalidException("Mã nhà xuất bản đã tồn tại");
        }
        if(nhaXuatBanRepository.kiemTraNhaXuatBan(nhaXuatBanDTO.getMaNhaXuatBan())){
            throw new InvalidException("Mã nhà xuất bản đã tồn tại");
        }
        nhaXuatBan.setMaNhaXuatBan(nhaXuatBanDTO.getMaNhaXuatBan());
        nhaXuatBan.setTenNhaXuatBan(nhaXuatBanDTO.getTenNhaXuatBan());
        nhaXuatBan.setDiaChi(nhaXuatBanDTO.getDiaChi());
        nhaXuatBan.setDienThoai(nhaXuatBanDTO.getDienThoai());
        nhaXuatBanRepository.save(nhaXuatBan);
        return nhaXuatBan;
    }

    @Override
    public NhaXuatBan delete(String id) {
        NhaXuatBan nhaXuatBan = getNhaXuatBan(id);
        nhaXuatBanRepository.delete(nhaXuatBan);
        return nhaXuatBan;
    }
    private NhaXuatBan getNhaXuatBan(String id){
        return nhaXuatBanRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Nhà xuất bản này không tồn tại", id)));
    }
}
