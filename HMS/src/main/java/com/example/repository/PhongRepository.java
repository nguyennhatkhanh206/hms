package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Phong;


public interface PhongRepository extends JpaRepository<Phong,String>{
          List<Phong> findAllByTrangThaiP(String trangThaiP);
     
}
