package com.example.bookecom.entities.embeded;

import com.example.bookecom.entities.TaiKhoan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDuocChon {
    private String maSach;
    private Integer soLuong;
}
