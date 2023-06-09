package com.example.bookecom.config;

import com.example.bookecom.security.JwtAuthenticationFilter;
import com.example.bookecom.service.chitietnguoidung.ChiTietNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private ChiTietNguoiDungService chiTietNguoiDungService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JwtAuthenticationFilter getJwtAuthFilter() {
        return new JwtAuthenticationFilter();
    }
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(chiTietNguoiDungService)
                .passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/",
                        "/rest/v1/auth/**",
                        "/rest/v1/user").permitAll()
                .antMatchers("/rest/v1/user/**",
                        "/rest/v1/tacgia/**",
                        "/rest/v1/chitietdonhang/**",
                        "/rest/v1/sach",
                        "/rest/v1/sach/**",
                        "/rest/v1/tacgia",
                        "/rest/v1/donhang",
                        "/rest/v1/donhang/**",
                        "/rest/v1/nhaxuatban",
                        "/rest/v1/nhaxuatban/**").authenticated();
        http.addFilterBefore(getJwtAuthFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }
}
