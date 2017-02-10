package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.KhachHang;


public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

}
