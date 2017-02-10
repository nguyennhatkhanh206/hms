package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.DonGia;
import com.example.model.LoaiPhong;
import com.example.repository.DonGiaRepository;
import com.example.repository.LoaiPhongRepository;
import com.example.repository.PhongRepository;


@RestController
@RequestMapping("/loaiphong")
public class LoaiPhongController {
	LoaiPhongRepository lpRepository;
	DonGiaRepository dgRepository;
	@Autowired
	public LoaiPhongController(LoaiPhongRepository lpRepository,DonGiaRepository dgRepository) {
		this.lpRepository = lpRepository;
		this.dgRepository=dgRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<LoaiPhong> getall() {
		return lpRepository.findAll();
	}


	
	
	@RequestMapping(value = "/add/{maDG}", method = RequestMethod.POST)
	public List<LoaiPhong> create(@RequestBody LoaiPhong prs,@PathVariable int maDG) {
		LoaiPhong pr=new LoaiPhong();
		DonGia dg=dgRepository.findOne(maDG);
		pr.setTenLP(prs.getTenLP());
		pr.setDienTichLP(prs.getDienTichLP());
		pr.setDongia(dg);
		pr.setMoTaLP(prs.getMoTaLP());
		pr.setSoGiuongLP(prs.getSoGiuongLP());
		pr.setSoNguoiLP(prs.getSoNguoiLP());
		lpRepository.save(pr);
		return lpRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public LoaiPhong update(@PathVariable int id) {

		return lpRepository.findOne(id);
 
	}

	@RequestMapping(value = "/update/{id}/{madg}", method = RequestMethod.POST,produces="application/json;chaset=UTF-8")
	public LoaiPhong update(@RequestBody LoaiPhong prs, @PathVariable int id,@PathVariable int madg) {		
		LoaiPhong pr=lpRepository.findOne(id);
		DonGia dg=dgRepository.findOne(madg);
		pr.setTenLP(prs.getTenLP());
		pr.setDienTichLP(prs.getDienTichLP());
		pr.setDongia(dg);
		pr.setMoTaLP(prs.getMoTaLP());
		pr.setSoGiuongLP(prs.getSoGiuongLP());
		pr.setSoNguoiLP(prs.getSoNguoiLP());
		lpRepository.save(pr);
		return lpRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<LoaiPhong> remove(@PathVariable int id) {
		lpRepository.delete(id);
		return lpRepository.findAll();

	}

	
	
}
