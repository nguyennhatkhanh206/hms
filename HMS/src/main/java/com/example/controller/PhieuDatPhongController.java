package com.example.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PhieuDatPhong;
import com.example.repository.PhieuDatPhongRepository;


@RestController
@RequestMapping("/phieudatphong")
public class PhieuDatPhongController {
	PhieuDatPhongRepository pdpRepository;
	@Autowired
	public PhieuDatPhongController(PhieuDatPhongRepository pdpRepository) {
		this.pdpRepository = pdpRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PhieuDatPhong> getall() {
		return pdpRepository.findAll();
	}


	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<PhieuDatPhong> create(@RequestBody PhieuDatPhong prs) {
		PhieuDatPhong pr=new PhieuDatPhong();
		 Calendar c1 = Calendar.getInstance();
		 c1.setTime(prs.getNgayvaoPDP());
		 c1.set(Calendar.HOUR_OF_DAY, 07);
		 c1.set(Calendar.MINUTE, 00);
		 c1.set(Calendar.MILLISECOND,00);
		 Calendar c2 = Calendar.getInstance();
		 c2.setTime(prs.getNgayvaoPDP());
		 c2.set(Calendar.HOUR,10);
		 c2.set(Calendar.MINUTE, 00);
		 c2.set(Calendar.MILLISECOND,00);
		pr.setHanTraPDP(c1.getTime());
		pr.setNgaydatPDP(prs.getNgaydatPDP());
		pr.setNgayvaoPDP(c2.getTime());
		pr.setNgayraPDP(prs.getNgayraPDP());
		pr.setCmndDK(prs.getCmndDK());
		pr.setSodemPDP(prs.getSodemPDP());
		pr.setKtnhanphong(prs.getKtnhanphong());
		pr.setKtthanhtoan(prs.getKtthanhtoan());
		pr.setEmailDK(prs.getEmailDK());
		pr.setTenDK(prs.getTenDK());
		pr.setPhong(prs.getPhong());
		pr.setHinhthuctt(prs.getHinhthuctt());
		pdpRepository.save(pr);	
		return pdpRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public PhieuDatPhong getupdate(@PathVariable int id) {

		return pdpRepository.findOne(id);
 
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST,produces="application/json;chaset=UTF-8")
	public PhieuDatPhong postupdate(@RequestBody PhieuDatPhong prs, @PathVariable int id) {		
		PhieuDatPhong pr=pdpRepository.findOne(id);
		pdpRepository.save(pr);
		return pdpRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<PhieuDatPhong> remove(@PathVariable int id) {
		pdpRepository.delete(id);
		return pdpRepository.findAll();

	}
	
	@RequestMapping(value = "/dsdatphong/{ktnhanphong}/{ktthanhtoan}", method = RequestMethod.GET)
	public List<PhieuDatPhong> seachnp(@PathVariable int ktthanhtoan,@PathVariable int ktnhanphong) {
		return pdpRepository.findByKtnhanphongAndKtthanhtoan(ktnhanphong,ktthanhtoan);
	

	}
	
	
	@RequestMapping(value = "/dsdatphong/{hantra}/{ktthanhtoan}", method = RequestMethod.GET)
	public List<PhieuDatPhong> toihan(@PathVariable Date hantra,@PathVariable int ktthanhtoan) {
		return pdpRepository.findByHanTraPDPAndKtthanhtoan(hantra,ktthanhtoan);
	

	}
	
	@RequestMapping(value = "/dsdat/{id}", method = RequestMethod.GET)
	public List<PhieuDatPhong> dsdat(@PathVariable String id) {
		Date ngayvao=new Date(id);
		return pdpRepository.findByNgayvaoPDPAfter(ngayvao);
	

	}
	
	
}
