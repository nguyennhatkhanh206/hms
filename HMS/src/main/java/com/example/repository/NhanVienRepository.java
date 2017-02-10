package com.example.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.NhanVien;


@Transactional
public interface NhanVienRepository extends JpaRepository<NhanVien,String>{
	
}