package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.HinhThucThanhToan;
import com.example.model.KhachHang;
import com.example.model.PhieuDatPhong;
import com.example.repository.HinhThucTTRepository;

@RestController
@RequestMapping("/httt")
public class HinhThucTTController {
	HinhThucTTRepository htttRepository;
	@Autowired
	public HinhThucTTController(HinhThucTTRepository htttRepos){
		this.htttRepository=htttRepos;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<HinhThucThanhToan> getall() {
		return htttRepository.findAll();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public HinhThucThanhToan getupdate(@PathVariable int id) {

		return htttRepository.findOne(id);
 
	}
}
