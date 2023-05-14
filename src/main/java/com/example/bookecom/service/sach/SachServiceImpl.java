package com.example.bookecom.service.sach;

import com.example.bookecom.dtos.sach.SachDTO;
import com.example.bookecom.entities.Sach;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.repository.SachRepository;
import com.example.bookecom.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
import java.util.Optional;

@Slf4j
@Service
public class SachServiceImpl implements SachService{
    @Autowired
    private SachRepository sachRepository;
    @Override
    public Sach create(SachDTO sachDTO, Principal principal) {
        if(ObjectUtils.isEmpty(sachDTO.getMaSach())){
            throw new InvalidException("Mã sách không đưcọ bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getTenSach())){
            throw new InvalidException("Tên sách không đưcọ bỏ trống");
        }
        if(sachDTO.getChuDes().size()==0){
            throw new InvalidException("Các chủ đề không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getMoTa())){
            throw new InvalidException("Mô tả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getGia())){
            throw new InvalidException("Giá không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getNhaXuatBan())){
            throw new InvalidException("Nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getSoLuong())){
            throw new InvalidException("So lượng không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getTacGia())){
            throw new InvalidException("Tác giả không được bỏ trống");
        }
        if(sachRepository.kiemTraMaSach(sachDTO.getMaSach())){
            throw new InvalidException("Mã sách đã tồn tại");
        }
        Sach sach = new Sach();
        sach.setMaSach(sachDTO.getMaSach());
        sach.setTenSach(sachDTO.getTenSach());
        sach.setSoLuong(sachDTO.getSoLuong());
        sach.setGia(sachDTO.getGia());
        sach.setMoTa(sachDTO.getMoTa());
        sach.setChuDes(sachDTO.getChuDes());
        sach.setTacGia(sachDTO.getTacGia());
        sach.setNhaXuatBan(sachDTO.getNhaXuatBan());
        sachRepository.save(sach);
        return sach;
    }

    @Override
    public Sach update(String id, SachDTO sachDTO, Principal principal) {
        Sach sach = getSach(id);
        if(ObjectUtils.isEmpty(sachDTO.getMaSach())){
            throw new InvalidException("Mã sách không đưcọ bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getTenSach())){
            throw new InvalidException("Tên sách không đưcọ bỏ trống");
        }
        if(sachDTO.getChuDes().size()==0){
            throw new InvalidException("Các chủ đề không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getMoTa())){
            throw new InvalidException("Mô tả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getGia())){
            throw new InvalidException("Giá không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getNhaXuatBan())){
            throw new InvalidException("Nhà xuất bản không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getSoLuong())){
            throw new InvalidException("So lượng không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(sachDTO.getTacGia())){
            throw new InvalidException("Tác giả không được bỏ trống");
        }
        if(sachRepository.kiemTraMaSach(sachDTO.getMaSach())){
            throw new InvalidException("Mã sách đã tồn tại");
        }
        if(sach.getMaSach().equalsIgnoreCase(sachDTO.getMaSach())){
            throw new InvalidException("Mã sách đã tồn tại");
        }
        sach.setMaSach(sachDTO.getMaSach());
        sach.setTenSach(sachDTO.getTenSach());
        sach.setSoLuong(sachDTO.getSoLuong());
        sach.setGia(sachDTO.getGia());
        sach.setMoTa(sachDTO.getMoTa());
        sach.setChuDes(sachDTO.getChuDes());
        sach.setTacGia(sachDTO.getTacGia());
        sach.setNhaXuatBan(sachDTO.getNhaXuatBan());
        sachRepository.save(sach);
        return sach;
    }

    @Override
    public Sach delete(String id) {
        Sach sach = getSach(id);
        sachRepository.delete(sach);
        return sach;
    }
    @Override
    public Page<Sach> filter(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return sachRepository.filter(search, pageable);

    }

    @Override
    public Page<Sach> getList(int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return sachRepository.findAll(pageable);
    }

    @Override
    public Page<Sach> getSachSearch(String search, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sachRepository.getSachSearch(search,pageable);
    }


    private Sach getSach(String id){
        return sachRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Không tìm được id sach nay")));
    }
}
