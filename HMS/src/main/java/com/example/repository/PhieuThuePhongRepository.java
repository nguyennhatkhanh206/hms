package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.PhieuThuePhong;
import com.example.model.Phong;



public interface PhieuThuePhongRepository extends JpaRepository<PhieuThuePhong,Integer> {
     Long countByPhong(Phong phong);
     List<PhieuThuePhong> findAllByPhong(Phong phong);
     List<PhieuThuePhong> findByNgayTPAfter(Date ngayTP);
}
