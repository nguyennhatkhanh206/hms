package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.LoaiPhong;
import com.example.model.Phong;
import com.example.repository.LoaiPhongRepository;
import com.example.repository.PhongRepository;

@RestController
@RequestMapping("/phong")
public class PhongController {
	PhongRepository pRepository;
	LoaiPhongRepository lpRepository;

	@Autowired
	public PhongController(PhongRepository pRepository, LoaiPhongRepository lpRepository) {
		this.pRepository = pRepository;
		this.lpRepository = lpRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Phong> getall() {
		return pRepository.findAll();
	}

	@RequestMapping(value = "/add/{maLP}", method = RequestMethod.POST)
	public List<Phong> create(@RequestBody Phong prs, @PathVariable int maLP) {
		Phong pr = new Phong();
		LoaiPhong lp = lpRepository.findOne(maLP);
		pr.setMaP(prs.getMaP());
		pr.setLoaiphong(lp);
		pr.setTrangThaiP(prs.getTrangThaiP());
		pRepository.save(pr);
		return pRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public Phong getupdate(@PathVariable String id) {

		return pRepository.findOne(id);

	}

	@RequestMapping(value = "/update/{id}/{maLP}", method = RequestMethod.POST, produces = "application/json;chaset=UTF-8")
	public Phong postupdate(@RequestBody Phong prs, @PathVariable String id, @PathVariable int maLP) {
		Phong pr = pRepository.findOne(id);
		LoaiPhong lp = lpRepository.findOne(maLP);
		pr.setMaP(prs.getMaP());
		pr.setLoaiphong(lp);
		pr.setTrangThaiP(prs.getTrangThaiP());
		pRepository.save(pr);
		return pRepository.findOne(id);
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<Phong> remove(@PathVariable String id) {
		pRepository.delete(id);
		return pRepository.findAll();

	}

}
