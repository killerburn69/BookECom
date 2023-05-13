package com.example.bookecom.service.tacgia;

import com.example.bookecom.dtos.tacgia.TacGiaDTO;
import com.example.bookecom.entities.TacGia;
import com.example.bookecom.exception.InvalidException;
import com.example.bookecom.exception.NotFoundException;
import com.example.bookecom.repository.TacGiaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
@Slf4j
@Service
public class TacGiaServiceImpl implements TacGiaService{
    private final TacGiaRepository tacGiaRepository;

    public TacGiaServiceImpl(TacGiaRepository tacGiaRepository) {
        this.tacGiaRepository = tacGiaRepository;
    }

    @Override
    public TacGia create(TacGiaDTO tacGiaDTO, Principal principal) {
        if(ObjectUtils.isEmpty(tacGiaDTO.getTenTacGia())){
            throw new InvalidException("Tên tác giả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(tacGiaDTO.getSoDienThoai())){
            throw new InvalidException("Số điện thoại tác giả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(tacGiaDTO.getNoiSinh())){
            throw new InvalidException("Nơi sinh không được bỏ trống");
        }
        TacGia tacGia = new TacGia();
        tacGia.setTenTacGia(tacGiaDTO.getTenTacGia());
        tacGia.setNoiSinh(tacGiaDTO.getNoiSinh());
        tacGia.setSoDienThoai(tacGiaDTO.getSoDienThoai());
        tacGiaRepository.save(tacGia);
        return tacGia;
    }

    @Override
    public TacGia update(String id, TacGiaDTO tacGiaDTO, Principal principal) {
        TacGia tacGia =getTacGia(id);
        if(ObjectUtils.isEmpty(tacGiaDTO.getTenTacGia())){
            throw new InvalidException("Tên tác giả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(tacGiaDTO.getSoDienThoai())){
            throw new InvalidException("Số điện thoại tác giả không được bỏ trống");
        }
        if(ObjectUtils.isEmpty(tacGiaDTO.getNoiSinh())){
            throw new InvalidException("Nơi sinh không được bỏ trống");
        }
        tacGia.setTenTacGia(tacGiaDTO.getTenTacGia());
        tacGia.setNoiSinh(tacGiaDTO.getNoiSinh());
        tacGia.setSoDienThoai(tacGiaDTO.getSoDienThoai());
        tacGiaRepository.save(tacGia);
        return tacGia;
    }

    @Override
    public TacGia delete(String id) {
        TacGia tacGia = getTacGia(id);
        tacGiaRepository.delete(tacGia);
        return tacGia;
    }

    private TacGia getTacGia(String id) {
        return tacGiaRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Tác giả này không tồn tại",id)));
    }
}
