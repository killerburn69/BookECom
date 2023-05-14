package com.example.bookecom.service.donhang;

import com.example.bookecom.dtos.donhang.DonHangDTO;
import com.example.bookecom.entities.ChiTietDonHang;
import com.example.bookecom.entities.DonHang;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.repository.ChiTietDonHangRepository;
import com.example.bookecom.repository.DonHangRepository;
import com.example.bookecom.utils.EnumStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DonHangServiceImpl implements DonHangService{
    @Autowired
    private DonHangRepository donHangRepository;
    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;
    @Override
    public DonHang create(DonHangDTO donHangDTO, Principal principal) {
        if(ObjectUtils.isEmpty(donHangDTO.getMaDonHang())){
            throw new InvalidException("Mã đơn hàng không được troongs");
        }
        if(ObjectUtils.isEmpty(donHangDTO.getTaiKhoan())){
            throw new InvalidException("Id tài khaonr không được troongs");
        }
        if(donHangRepository.kiemTraMaDonHang(donHangDTO.getMaDonHang())){
            throw new InvalidException("Mã đơn hàng đã tồn tại");
        }
        DonHang donHang = new DonHang();
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        donHang.setMaDonHang(donHangDTO.getMaDonHang());
        donHang.setSanPhamDuocChonList(donHangDTO.getSanPhamDuocChonList());
        donHang.setTaiKhoan(donHangDTO.getTaiKhoan());

        chiTietDonHang.setDonHangs(donHang);
        chiTietDonHang.setNgayGiaoHang(new Date());
        chiTietDonHang.setTrangThai(EnumStatus.DANGXULY);
        donHangRepository.save(donHang);
        chiTietDonHangRepository.save(chiTietDonHang);
        return donHang;
    }

    @Override
    public DonHang update(String id, DonHangDTO donHangDTO, Principal principal) {
        DonHang donHang = getDonHang(id);

        if(ObjectUtils.isEmpty(donHangDTO.getMaDonHang())){
            throw new InvalidException("Mã đơn hàng không được troongs");
        }
        donHang.setMaDonHang(donHangDTO.getMaDonHang());
        donHang.setSanPhamDuocChonList(donHangDTO.getSanPhamDuocChonList());

        donHangRepository.save(donHang);

        List<ChiTietDonHang> chiTietDonHangs = chiTietDonHangRepository.findAll();
        for(ChiTietDonHang chiTietDonHang:chiTietDonHangs){
            if(chiTietDonHang.getDonHangs().getMaDonHang().equalsIgnoreCase(donHang.getMaDonHang())){
                System.out.println("Đúng");
                chiTietDonHang.setDonHangs(donHang);
                chiTietDonHangRepository.save(chiTietDonHang);
                break;
            }
        }
        return donHang;
    }
    private DonHang getDonHang(String id){
        return donHangRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Don hang khong có", id)));
    }
}
