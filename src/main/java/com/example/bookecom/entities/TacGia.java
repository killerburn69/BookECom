package com.example.bookecom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tacgia")
public class TacGia {
    @Id
    private String id;
    private String tenTacGia;
    private String noiSinh;
    private String soDienThoai;
}
