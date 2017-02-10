package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DonGia;
import com.example.model.LoaiPhong;
import com.example.repository.DonGiaRepository;
import com.example.repository.LoaiPhongRepository;

@RestController
@RequestMapping("/dongia")
public class DonGiaController {
	DonGiaRepository dgRepository;
	@Autowired
	public DonGiaController(DonGiaRepository dgRepository) {
		this.dgRepository = dgRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<DonGia> getall() {
		return dgRepository.findAll();
	}


	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<DonGia> create(@RequestBody DonGia prs) {
		DonGia pr=new DonGia();
		pr.setTenDG(prs.getTenDG());
		pr.setGiaDemDG(prs.getGiaDemDG());
		pr.setGiaGioDG(prs.getGiaGioDG());
		pr.setPhuThuCT(prs.getPhuThuCT());
		pr.setPhuThuM(prs.getPhuThuM());;
		pr.setKhuyenMai(prs.getKhuyenMai());
		dgRepository.save(pr);
		return dgRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public DonGia getupdate(@PathVariable int id) {

		return dgRepository.findOne(id);
 
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST,produces="application/json;chaset=UTF-8")
	public DonGia postupdate(@RequestBody DonGia prs, @PathVariable int id) {		
		DonGia pr=dgRepository.findOne(id);
		pr.setTenDG(prs.getTenDG());
		pr.setGiaDemDG(prs.getGiaDemDG());
		pr.setGiaGioDG(prs.getGiaGioDG());
		pr.setPhuThuCT(prs.getPhuThuCT());
		pr.setPhuThuM(prs.getPhuThuM());;
		pr.setKhuyenMai(prs.getKhuyenMai());
		dgRepository.save(pr);
		return dgRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<DonGia> remove(@PathVariable int id) {
		dgRepository.delete(id);
		return dgRepository.findAll();

	}
	
}
