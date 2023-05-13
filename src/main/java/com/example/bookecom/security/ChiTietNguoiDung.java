package com.example.bookecom.security;

import com.example.bookecom.entities.TaiKhoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//Khai báo cho securtity bik các trường để đăng nhập
@Data
@AllArgsConstructor
public class ChiTietNguoiDung implements UserDetails {
    private TaiKhoan taiKhoan;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(taiKhoan.getRole().get(0)));
    }

    @Override
    public String getPassword() {
        return taiKhoan.getPassword();
    }

    @Override
    public String getUsername() {
        return taiKhoan.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
