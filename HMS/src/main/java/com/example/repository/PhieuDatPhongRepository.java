package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.PhieuDatPhong;
import com.example.model.PhieuThuePhong;


public interface PhieuDatPhongRepository extends JpaRepository<PhieuDatPhong,Integer> {
List<PhieuDatPhong> findByKtnhanphongAndKtthanhtoan(int ktnhanphong, int ktthanhtoan);
List<PhieuDatPhong> findByHanTraPDPAndKtthanhtoan(Date hanTraPDP, int ktthanhtoan);
List<PhieuDatPhong> findByNgayvaoPDPAfter(Date ngayvaoPDP);
}