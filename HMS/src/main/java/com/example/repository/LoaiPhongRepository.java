package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.DonGia;
import com.example.model.LoaiPhong;


public interface LoaiPhongRepository extends JpaRepository<LoaiPhong, Integer> {
}
